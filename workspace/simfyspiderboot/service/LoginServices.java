package edu.cqjtu.zhang.simfyspiderboot.service;

import edu.cqjtu.zhang.simfyspiderboot.web.form.LoginForm;

/**
 * @author Lewis
 */
public interface LoginServices {
    /**
     * 实现登录
     * @param form
     * @return
     */
    boolean login(LoginForm form);
}
