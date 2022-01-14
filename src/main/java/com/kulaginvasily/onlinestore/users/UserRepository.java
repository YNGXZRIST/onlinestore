package com.kulaginvasily.onlinestore.users;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
        boolean existsUserByNumber(String number);

        UserEntity findUserByNumber(String number);
    }

