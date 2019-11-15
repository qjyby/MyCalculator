package com.example.demo.sms.controller;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.example.demo.sms.SmsUtils;
import com.example.demo.sms.entity.UserInfo;
import com.example.demo.sms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.HashMap;
import java.util.Map;



@Controller
@RequestMapping("/api")
public class SendController {
    private int newcode;
    private  HashMap<String, String> hashMap = new HashMap<>();
    public  int getNewcode() {
        return newcode;
    }
    public  void setNewcode() {
        newcode = (int) (Math.random() * 9999) + 100;  //每次调用生成一次四位数的随机数
    }

  @Autowired
  private UserService userService;

    @PostMapping("/smscode")
    public void send(@RequestParam("phone") String phone) {
        setNewcode();
        String code = Integer.toString(getNewcode());
        hashMap.put(phone, code);
  /*      try {
            SendSmsResponse sendSms = SmsUtils.sendSms(phone, code);
            System.out.println("短信接口返回的数据----------------");
            System.out.println("Code=" + sendSms.getCode());
            System.out.println("Message=" + sendSms.getMessage());
            System.out.println("RequestId=" + sendSms.getRequestId());
            System.out.println("BizId=" + sendSms.getBizId());
        } catch (ClientException e) {
            e.printStackTrace();
        }*/
    }

    @GetMapping("/register")
    public ModelAndView register() {
        return new ModelAndView("register");
    }

    @GetMapping("/index")
    public ModelAndView index() {
        return new ModelAndView("index");
    }

    @GetMapping("/login")
    public ModelAndView login() {
        return new ModelAndView("login");
    }

    @PostMapping("/check")
    public ModelAndView register(@RequestParam("mobile")String phone,@RequestParam("phoneCode")String code,@RequestParam("password")String password,Map<String, Object> map) {
        String checkCode=hashMap.get(phone);
        if (code.equals(checkCode)){
            UserInfo userInfo=new UserInfo();
            userInfo.setPhone(phone);
            userInfo.setUsername(phone);
            userInfo.setPassword(password);
            userService.save(userInfo);
            map.put("url","/api/login");
            return  new ModelAndView("success",map);
        }
        else
        {
            map.put("url","/api/register");
            return  new ModelAndView("error",map);
        }

    }
    @PostMapping("/checkLogin")
    public ModelAndView checkLogin(@RequestParam("mobile")String phone,@RequestParam("password")String password,Map<String, Object> map){
       UserInfo userInfo =userService.findOne(phone);
       if (userInfo.getPassword().equals(password)){
           map.put("url","/api/index");
           return  new ModelAndView("success",map);
       }
       else {
           map.put("url","/api/login");
           return  new ModelAndView("error",map);
       }
    }


}
