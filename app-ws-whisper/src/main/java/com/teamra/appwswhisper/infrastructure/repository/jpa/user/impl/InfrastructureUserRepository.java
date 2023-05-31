package com.teamra.appwswhisper.infrastructure.repository.jpa.user.impl;



import org.springframework.stereotype.Component;

import com.teamra.appwswhisper.domain.users.model.User;
import com.teamra.appwswhisper.domain.users.repository.UserRepository;
import com.teamra.appwswhisper.infrastructure.repository.jpa.user.SpringDataJpaUserRepository;
import com.teamra.appwswhisper.infrastructure.repository.jpa.user.UserEntity;



@Component
public class InfrastructureUserRepository implements UserRepository{

    public final SpringDataJpaUserRepository userRepository;

    public InfrastructureUserRepository(SpringDataJpaUserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public User findByIdUser(Integer id) {
        UserEntity userEntity = userRepository.findByIdUser(id);
        return userEntity.toUser();
    }


    
}
