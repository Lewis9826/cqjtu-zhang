package edu.cqjtu.zhang.simfyspiderboot.web;

import edu.cqjtu.zhang.simfyspiderboot.common.Result;
import edu.cqjtu.zhang.simfyspiderboot.service.LoginServices;
import edu.cqjtu.zhang.simfyspiderboot.web.form.LoginForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Lewis
 */
@RestController
public class LoginController {

    @Autowired
    private LoginServices loginServices;

    @RequestMapping(value = "login")
    public Result login(LoginForm form){
        boolean loginSuccess = loginServices.login(form);
        return loginSuccess?Result.success():Result.fail("1001","用户名或者密码不正确");
    }
}
