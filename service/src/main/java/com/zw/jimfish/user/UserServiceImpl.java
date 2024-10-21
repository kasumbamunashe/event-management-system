package com.zw.jimfish.user;

import com.zw.jimfish.embedables.Audit;
import com.zw.jimfish.exceptions.FileDoesNotExistsException;
import jimfish.user.UserRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
     existingUser.setUsername(request.getUsername());
     existingUser.setRole(request.getRole());
     existingUser.setPassword(request.getPassword());
     existingUser.setAudit(new Audit());
        return userRepository.save(existingUser);
    }
    @Override
    public void deleteUser(Long id) {
        Optional<User> deleteOptionalUser = userRepository.findById(id);
        if(deleteOptionalUser.isEmpty()){
            throw  new FileDoesNotExistsException("User not found");
        }
        User deleteUser = deleteOptionalUser.get();
        userRepository.delete(deleteUser);
    }

    @Override
    public User getUser(Long id) {
        return userRepository.findById(id).orElseThrow(() ->
                new FileDoesNotExistsException("User not Found"+id));
    }
    @Override
    public User getAll(String searchName, Pageable pageable) {
        return null;
    }
}
