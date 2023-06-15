package com.teamra.appwswhisper.users.domain.service;

import org.springframework.stereotype.Service;

import com.teamra.appwswhisper.users.domain.model.User;
import com.teamra.appwswhisper.users.domain.repository.IUserRepository;

@Service
public class DomainUserService implements UserService{

    public final IUserRepository userRepository;

    public DomainUserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findUserById(Integer id) {
        return userRepository.findByIdUser(id);
    }
    
}
