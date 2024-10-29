package com.zw.jimfish.user;

import com.zw.jimfish.embedables.Audit;
import com.zw.jimfish.exceptions.FileDoesNotExistsException;
import jimfish.user.UserRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Data
@RequiredArgsConstructor
@Slf4j
@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    @Override
    public User createUser(UserRequest request) {
        User user = User.builder()
                .email(request.getEmail())
                .name(request.getName())
                .surname(request.getSurname())
                .phoneNumber(request.getPhoneNumber())
                .role(request.getRole())
                .username(request.getUsername())
                .password(request.getPassword())
                .audit(new Audit())
                .build();
        return userRepository.save(user);
    }
    @Override
    public User updateUser(Long userId, UserRequest request) {
     var existingUser = userRepository.findById(userId).orElseThrow(() ->
             new FileDoesNotExistsException("User not found"+ userId));
     existingUser.setEmail(request.getEmail());
     existingUser.setName(request.getName());
     existingUser.setSurname(request.getSurname());
     existingUser.setPhoneNumber(request.getPhoneNumber());
     existingUser.setUsername(request.getUsername());
     existingUser.setRole(request.getRole());
     existingUser.setPassword(request.getPassword());
     existingUser.setAudit(new Audit());
        return userRepository.save(existingUser);
    }
    @Override
    public void deleteUser(Long id) {
        User deleteUser = userRepository.findById(id)
                .orElseThrow(() -> new FileDoesNotExistsException("User not found"));

        userRepository.delete(deleteUser);
    }


    @Override
    public User getUser(Long id) {
        return userRepository.findById(id).orElseThrow(() ->
                new FileDoesNotExistsException("User not Found"+id));
    }
    @Override
    public Page <User> getAll(String name, Pageable pageable) {
        if (Objects.nonNull(name))
            return userRepository.findUserByNameIgnoreCase(name);
        return userRepository.findAll(pageable);
    }
}
