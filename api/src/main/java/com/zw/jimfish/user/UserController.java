package com.zw.jimfish.user;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
@Tag(name = "User", description = "User")
@CrossOrigin

public class UserController {
    private final UserService userService;
    @PostMapping("/create")
    @Operation(description = "Create User")
    public ResponseEntity<User>  createUser (@RequestBody UserRequest request){
        return ResponseEntity.ok(userService.createUser(request));
    }
    @PutMapping("/{id}")
    @Operation(description = "Update User")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody UserRequest userRequest){
        return ResponseEntity.ok(userService.updateUser(id,userRequest));
    }
    @DeleteMapping("/{id}")
    @Operation(description = "Delete User")
    public ResponseEntity<User>deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/{id}")
    @Operation(description = "Get user by Id")
    public ResponseEntity<User>getById(@PathVariable Long id){
        return ResponseEntity.ok(userService.getUser(id));
    }
    @GetMapping("/getAll")
    @Operation(description = "get all users")
    ResponseEntity<Page<User>>getAll(Pageable pageable, @Nullable String userName){
        return ResponseEntity.ok(userService.getAll(userName,pageable));
    }

}
