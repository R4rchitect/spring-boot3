package com.teamra.appwswhisper.users.infrastructure.adapters.output.persistence.jpa.impl;



import org.springframework.stereotype.Component;

import com.teamra.appwswhisper.users.infrastructure.adapters.output.persistence.jpa.SpringDataJpaUserRepository;
import com.teamra.appwswhisper.users.infrastructure.adapters.output.persistence.jpa.UserEntity;
import com.teamra.appwswhisper.users.domain.model.User;
import com.teamra.appwswhisper.users.domain.repository.IUserRepository;



@Component
public class InfrastructureUserRepository implements IUserRepository{

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
