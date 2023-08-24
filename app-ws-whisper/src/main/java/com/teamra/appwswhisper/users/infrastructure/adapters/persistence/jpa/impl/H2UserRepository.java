package com.teamra.appwswhisper.users.infrastructure.adapters.persistence.jpa.impl;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.teamra.appwswhisper.users.infrastructure.adapters.persistence.jpa.IH2UserRepository;
import com.teamra.appwswhisper.users.infrastructure.adapters.persistence.jpa.UserEntity;


import com.teamra.appwswhisper.shared.domain.ApplicationException;
import com.teamra.appwswhisper.users.domain.model.User;
import com.teamra.appwswhisper.users.domain.repository.IUserRepository;

@Component
public class H2UserRepository implements IUserRepository{

    public final IH2UserRepository userRepository;

    public H2UserRepository(IH2UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public Optional<User> findById(Integer id) {
        Optional<UserEntity> userEntity = userRepository.findById(id);

        if(userEntity.isEmpty()) throw new ApplicationException("user-not-found",
                                                                String.format("User with id=%d not found", id),
                                                                HttpStatus.NOT_FOUND);
        return Optional.ofNullable(userEntity.get().toUser());
    }

    @Override
    public void insert(User user) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insert'");
    }


    @Override
    public void update(User user) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }


    @Override
    public void removeById(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeById'");
    }
    
}
