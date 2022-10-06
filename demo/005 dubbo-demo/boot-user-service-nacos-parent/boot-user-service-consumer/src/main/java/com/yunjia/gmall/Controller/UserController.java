package com.yunjia.gmall.Controller;

import com.yunjia.gmall.bean.Result;
import com.yunjia.gmall.bean.User;
import com.yunjia.gmall.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/user")
@ResponseBody
public class UserController {

    @Reference
    private UserService userService;

    /**
     * 查询所有记录
     * @param
     * @return
     */
    @RequestMapping(value = "/getAllUser",method = RequestMethod.GET)
    public Result getAllUser() throws Exception {
        List<User> users = userService.getAllUser();
        if (users.size() == 0){
            return Result.build(-1,"未查询到信息");
        }
        return Result.ok(users);
    }

    /**
     * 根据id获取数据
     * @param
     * @return
     */
    @RequestMapping(value = "/getUserById",method = RequestMethod.POST)
    public Result getUserById(@RequestBody User user) throws Exception {
        log.info("收到了请求：" + user.getId());
        Object selectRet = userService.getUserById(user.getId());
        if (selectRet == null){
            System.out.println("空对象");
            return Result.build(-1,"未查询到信息");
        }
        User userSelect = (User) selectRet;
        log.info("查到了对象：" + userSelect);
        return Result.ok(userSelect);
    }

    /**
     * 根据用户Id更新用户信息
     * @param user
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/updateUser",method = RequestMethod.POST)
    public Result updateUser(@RequestBody User user) throws Exception {
        User ret = userService.updateUser(user);
        if (ret == null){
            return Result.build(-1,"更新失败");
        }
        return Result.ok(ret);
    }

    /**
     * 新增用户信息
     * @param user
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/saveUser",method = RequestMethod.POST)
    public Result saveUser(@RequestBody User user) throws Exception {
        User ret = userService.saveUser(user);
        if (ret == null){
            return Result.build(-1,"新增用户失败");
        }
        return Result.ok(ret);
    }

    /**
     * 根据用户Id删除用户信息
     * @param user
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/deleteUser",method = RequestMethod.POST)
    public Result deleteUser(@RequestBody User user) throws Exception {
        System.out.println("收到请求，参数：" + user.toString());
        boolean ret = userService.deleteUser(user.getId());
        if (!ret){
            return Result.build(-1,"删除用户失败");
        }
        return Result.ok();
    }
}
