package edu.cqjtu.zhang.simfyspiderboot.service.impl;

import edu.cqjtu.zhang.simfyspiderboot.dal.UserRepository;
import edu.cqjtu.zhang.simfyspiderboot.domain.User;
import edu.cqjtu.zhang.simfyspiderboot.service.LoginServices;
import edu.cqjtu.zhang.simfyspiderboot.web.form.LoginForm;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Lewis
 */
@Service
public class LoginServicesImpl implements LoginServices {

    @Autowired
    private UserRepository userRepository;
    @Override
    public boolean login(LoginForm form) {
        // 根据User对象来创建条件对象
        User user = new User();
        user.setUsername(form.getUsername());
        user.setPassword(form.getPassword());
        Example<User> userExample = Example.of(user);
        // 查询
        Optional<User> result = userRepository.findOne(userExample);
        // 是否存在此用户
        return result.isPresent();
    }
}
