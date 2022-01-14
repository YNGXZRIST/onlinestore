package com.kulaginvasily.onlinestore.users;


import com.kulaginvasily.onlinestore.exception.UserExistException;
import com.kulaginvasily.onlinestore.rest.dto.user.User;

import java.util.List;

public interface UserService {
    void addUser(User user) throws UserExistException;

    List<User> getUsers();

    Long getUserId(String number);
}

