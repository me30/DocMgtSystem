package com.commons.auth.service;

import com.commons.auth.model.User;

public interface UserService {
    void save(User user) throws Exception;

    User findByUsername(String username) throws Exception;
    
    User findByEmail(String email) throws Exception;
}
