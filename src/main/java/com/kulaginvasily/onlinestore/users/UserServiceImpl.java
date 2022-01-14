package com.kulaginvasily.onlinestore.users;

import com.kulaginvasily.onlinestore.exception.UserExistException;
import com.kulaginvasily.onlinestore.rest.dto.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void addUser(User user) throws UserExistException {
        if (!userRepository.existsUserByNumber(user.getNumber())) {
            throw new UserExistException("пользователь с таким номером телефона существует");
        }
        UserEntity userEntity = new UserEntity();
        userEntity.setName(user.getName());
        userEntity.setNumber(user.getNumber());
        userRepository.saveAndFlush(userEntity);
    }

    @Override
    public Long getUserId(String number) {
        return userRepository.findUserByNumber(number).getId();
    }
}
