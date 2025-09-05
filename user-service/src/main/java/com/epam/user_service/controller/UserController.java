package com.epam.user_service.controller;
import com.epam.user_service.model.User;
import com.epam.user_service.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAll(){
        return ResponseEntity.ok(userService.getAll());
    }

    @GetMapping("/{userName}")
    public ResponseEntity<User> getSpecificUser(@PathVariable String userName){
        return ResponseEntity.ok(userService.getSpecificUser(userName));
    }

    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User user){
        return ResponseEntity.ok(userService.addUser(user));
    }

    @DeleteMapping("/{userName}")
    public ResponseEntity<String> deleteUser(@PathVariable String userName){
        return ResponseEntity.ok(userService.deleteUser(userName));
    }

    @PutMapping("/{userName}")
    public ResponseEntity<String> updateUser(@PathVariable String userName,@RequestBody User user){
        return  ResponseEntity.ok(userService.updateUser(userName,user));
    }
}
