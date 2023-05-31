package com.teamra.appwswhisper.domain.users.service;

import org.springframework.stereotype.Service;

import com.teamra.appwswhisper.domain.users.model.User;
import com.teamra.appwswhisper.domain.users.repository.UserRepository;

@Service
public class DomainUserService implements UserService{

    public final UserRepository userRepository;

    public DomainUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findUserById(Integer id) {
        return userRepository.findByIdUser(id);
    }
    
}
