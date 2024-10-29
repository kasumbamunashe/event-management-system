package com.zw.jimfish.user;

import com.zw.jimfish.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRequest {
    private String username;
    private String name;
    private String surname;
    private String phoneNumber;
    private String email;
    private String password;
    private Role role;
}
