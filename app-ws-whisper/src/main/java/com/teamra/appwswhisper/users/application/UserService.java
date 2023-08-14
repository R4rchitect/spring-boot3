package com.teamra.appwswhisper.users.application;

import com.teamra.appwswhisper.users.domain.model.User;

public interface UserService {
    public User findUserById(Integer id);
    public void createUser(User user);
}
