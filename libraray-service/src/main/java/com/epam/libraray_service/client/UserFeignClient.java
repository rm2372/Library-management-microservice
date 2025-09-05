package com.epam.libraray_service.client;

import com.epam.libraray_service.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "user-service")
public interface UserFeignClient {
    @GetMapping("/users")
    public ResponseEntity<List<UserDto>> getAll();

    @GetMapping("/users/{userName}")
    public ResponseEntity<UserDto> getSpecificUser(@PathVariable String userName);


    @PostMapping("/users")
    public ResponseEntity<UserDto> addUser(@RequestBody UserDto user);

    @DeleteMapping("/users/{userName}")
    public ResponseEntity<String> deleteUser(@PathVariable String userName);

    @PutMapping("/users/{userName}")
    public ResponseEntity<String> updateUser(@PathVariable String userName,@RequestBody UserDto user);
}
