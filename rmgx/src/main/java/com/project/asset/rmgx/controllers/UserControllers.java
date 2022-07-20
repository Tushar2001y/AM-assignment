package com.project.asset.rmgx.controllers;

import com.project.asset.rmgx.payloads.ApiResponse;
import com.project.asset.rmgx.payloads.UserDto;
import com.project.asset.rmgx.services.UserService;
import org.hibernate.mapping.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserControllers {
    @Autowired
    private UserService userService;




    //POST -- to create a user/employee
    @PostMapping("/")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
        UserDto createdUserDto = this.userService.createUser(userDto);
        return new ResponseEntity<>(createdUserDto, HttpStatus.CREATED);
    }
    //PUT update user details
    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto,@PathVariable("userId") Integer uid){
        UserDto updatedUser = this.userService.updateUser(userDto,uid);
        return ResponseEntity.ok(updatedUser);
    }
    //Delete delete user
    @DeleteMapping("/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable("userId") Integer uid){
        this.userService.deleteUser(uid);

        return new ResponseEntity(new ApiResponse("user deleted successfully",true),HttpStatus.OK);
    }
    //GET -- get user
    @GetMapping("/")
    public ResponseEntity<List<UserDto>> getAllUsers(){
        return ResponseEntity.ok(this.userService.getAllUsers());
    }
    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getSingleUser(@PathVariable Integer userId){
        return ResponseEntity.ok(this.userService.getUserById(userId));
    }

}
