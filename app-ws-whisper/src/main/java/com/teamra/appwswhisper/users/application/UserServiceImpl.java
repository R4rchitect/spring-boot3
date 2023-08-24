package com.teamra.appwswhisper.users.application;
import org.springframework.stereotype.Service;
import com.teamra.appwswhisper.users.domain.model.User;
import com.teamra.appwswhisper.users.domain.repository.IUserRepository;

@Service
public class UserServiceImpl implements UserService{

    public final IUserRepository userRepository;

    public UserServiceImpl(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findUserById(Integer id) {
        return userRepository.findById(id).get();
    }

    @Override
    public void createUser(User user) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createUser'");
    }
    
}
