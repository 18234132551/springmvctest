package cn.test.controller;

import cn.test.pojo.JsonResponseState;
import cn.test.pojo.TUser;
import cn.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2017/5/1.
 */
@Controller
@RequestMapping("/User")
public class TUserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/qurey/{id}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    TUser findUserById(@PathVariable("id") Integer id) {
        TUser tUser = null;
        try {
            tUser = userService.findUserById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tUser;
    }

    //此处如果只接收json，则可以使用@RequestBody，不能接收表单数据
    //不使用RequestBody，则可以接收表单数据
    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    TUser addUserBy(@RequestBody TUser tUser) {
        try {
            userService.addUserById(tUser);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tUser;
    }

    @RequestMapping(value = "/delet/{id}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JsonResponseState deletUserById(@PathVariable Integer id) {
        JsonResponseState jsonResponseState =null;
        int temp=0;
        try {
             temp  = userService.deleteUserById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        jsonResponseState.setHandler("delet");
        jsonResponseState.setObject("user");
        if (temp!=0){
            jsonResponseState.setCode(201);
            jsonResponseState.setState("成功");
        }else{
            jsonResponseState.setCode(202);
            jsonResponseState.setState("失败");
        }
        return  jsonResponseState;
    }

    @RequestMapping(value = "/undate", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    JsonResponseState updateUserById(@RequestBody TUser tUser) {
        JsonResponseState jsonResponseState =null;
        int temp=0;
        try {
            userService.updateUserById(tUser.getId(), tUser);
        } catch (Exception e) {
            e.printStackTrace();
        }
        jsonResponseState.setHandler("delet");
        jsonResponseState.setObject("user");
        if (temp!=0){
            jsonResponseState.setCode(201);
            jsonResponseState.setState("成功");
        }else{
            jsonResponseState.setCode(202);
            jsonResponseState.setState("失败");
        }
        return  jsonResponseState;
    }
}
