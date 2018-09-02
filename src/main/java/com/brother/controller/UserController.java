package com.brother.controller;

import com.brother.entity.po.Consumer;
import com.brother.entity.vo.IdentifyModul;
import com.brother.jsonResult.JsonResult;
import com.brother.service.UserService;
import com.brother.util.PropertiesUtil;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.util.StringUtils;

import javax.annotation.Resource;
import java.io.IOException;

@RestController
public class UserController {

    @Resource
    private UserService userService;

    //百度云,短信验证码功能
    @RequestMapping(value = "/sendIdentify",method = RequestMethod.POST)
    public JsonResult sendIdentify(@RequestBody String telephone){

        String path = "identify.properties";
        //获取Properties配置文件信息
        String appId = PropertiesUtil.getValue(path,"appId");
        String appKey = PropertiesUtil.getValue(path,"appKey");
        String templateId = PropertiesUtil.getValue(path,"templatedId");
        String smsSign = PropertiesUtil.getValue(path,"smsSign");

        SmsSingleSenderResult result = null;

        if(!StringUtils.isEmpty(appId) && !StringUtils.isEmpty(appKey) && !StringUtils.isEmpty(templateId) && !StringUtils.isEmpty(smsSign)){
            try {
                //{1}为您的登录验证码，请于{2}分钟内填写。如非本人操作，请忽略本短信。
                String random = IdentifyModul.randomForIdentify();
                String[] params = {random,"1"};
                SmsSingleSender ssender = new SmsSingleSender(Integer.parseInt(appId),appKey);
                result = ssender.sendWithParam("86",telephone,Integer.parseInt(templateId),params,"","",random);
            }catch (Exception e){
                return new JsonResult(e.getMessage());
            }
        }
        return new JsonResult(result);
    }


    //检查用户是否已经存在
    @RequestMapping(value = "/confirmUsername",method = RequestMethod.POST)
    public JsonResult confirmUsername(@RequestBody String username){
        return  new JsonResult(userService.confirmUsername(username));
    }

    //检查用户是否已经存在
    @RequestMapping(value = "/confirmTelephone",method = RequestMethod.POST)
    public JsonResult confirmTelephone(@RequestBody String telephone){
        return  new JsonResult(userService.confirmTelephone(telephone));
    }

    @RequestMapping(value = "/registeConsumer",method = RequestMethod.POST)
    public JsonResult registeConsumer(@RequestBody Consumer consumer){
        userService.registeConsumer(consumer);
        return new JsonResult();
    }

}
