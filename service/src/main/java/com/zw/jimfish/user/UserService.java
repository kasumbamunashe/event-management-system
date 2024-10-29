package com.zw.jimfish.user;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {
    User createUser (UserRequest request);

    User updateUser (Long userId, UserRequest request);

    void deleteUser (Long id);

    User getUser(Long id);

   Page <User> getAll(String name, Pageable pageable);
}
