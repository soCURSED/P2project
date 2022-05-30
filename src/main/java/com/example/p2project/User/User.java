package com.example.p2project.User;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.*;


@Data @AllArgsConstructor
public class User {
    @NotEmpty(message = "id Most not be empty")
    @Size(min = 3, max = 3)
    private String id;

    @NotEmpty(message = "username Most not be empty")
    @Size(min = 5, max = 5)
    private String username;

    @NotEmpty(message = "password Most not be empty")
    private String password;

    @Email(message = "Email formate only")
    @NotEmpty(message = "email Most not be empty")
    private String email;

    @NotEmpty(message = "role Most not be empty")
    @Pattern(regexp = "(Admin|Customer)", message = "Only Admin or Customer")
    private String role;

    @NotNull(message = "balance Most not be null")
    @Positive
    private Double balance;

}
