package com.kulaginvasily.onlinestore.users;


import com.kulaginvasily.onlinestore.exception.UserExistException;
import com.kulaginvasily.onlinestore.rest.dto.user.User;


public interface UserService {
    void addUser(User user) throws UserExistException;
    Long getUserId(String number);
}
