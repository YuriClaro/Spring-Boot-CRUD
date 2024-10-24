package com.humanit.yuriclaro_exercicio_spring_boot_1.controller;

import com.humanit.yuriclaro_exercicio_spring_boot_1.dto.UserAccountDTO;
import com.humanit.yuriclaro_exercicio_spring_boot_1.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Operation(summary = "Create a new user", description = "Endpoint to create a new user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "UserAccount created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid request")
    })
    @PostMapping
    public ResponseEntity<UserAccountDTO> createUser(@Valid @RequestBody UserAccountDTO userAccountDTO) {
        userService.createUser(userAccountDTO);
        return new ResponseEntity<>(userAccountDTO, HttpStatus.CREATED);
    }

    @Operation(summary = "A paginated list of users", description = "Endpoint to retrieve all users with pagination")
    @ApiResponse(responseCode = "200", description = "UserAccount list retrieved successfully")
    @GetMapping
    public ResponseEntity<Page<UserAccountDTO>> getAllUsers(Pageable pageable) {
        Page<UserAccountDTO> userAccounts = userService.getAllUsers(pageable);
        return new ResponseEntity<>(userAccounts, HttpStatus.OK);
    }

    @Operation(summary = "Retrieves a user by ID", description = "Endpoint to fetch a specific user by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "UserAccount retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "UserAccount not found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<UserAccountDTO> getUserById(@PathVariable Long id) {
        UserAccountDTO userAccountDTO = userService.getUserById(id);
        return new ResponseEntity<>(userAccountDTO, HttpStatus.OK);
    }

    @Operation(summary = "Search users by name", description = "Endpoint to search for users by the provided name")
    @ApiResponse(responseCode = "200", description = "Users found successfully")
    @GetMapping("/search/{name}")
    public ResponseEntity<Page<UserAccountDTO>> searchUsersByName(@PathVariable String name, Pageable pageable) {
        Page<UserAccountDTO> userAccountDTO = userService.searchByName(name, pageable);
        return new ResponseEntity<>(userAccountDTO, HttpStatus.OK);
    }

    @Operation(summary = "Updates an existing user", description = "Endpoint to update a specific user by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "UserAccount updated successfully"),
            @ApiResponse(responseCode = "404", description = "UserAccount not found"),
            @ApiResponse(responseCode = "400", description = "Invalid request")
    })
    @PutMapping("/{id}")
    public ResponseEntity<UserAccountDTO> updateUser(@PathVariable Long id, @Valid @RequestBody UserAccountDTO userAccountDTO) {
        UserAccountDTO userAccountUpdatedDTO = userService.updateUser(id, userAccountDTO);
        return new ResponseEntity<>(userAccountUpdatedDTO, HttpStatus.OK);
    }

    @Operation(summary = "Deletes an existing user", description = "Endpoint to delete a specific user by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "UserAccount deleted successfully"),
            @ApiResponse(responseCode = "404", description = "UserAccount not found")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
