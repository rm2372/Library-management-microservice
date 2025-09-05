package com.epam.libraray_service.controller;


import com.epam.libraray_service.dto.UserDto;
import com.epam.libraray_service.service.LibraryService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/library")
@AllArgsConstructor
@Slf4j
public class LibraryUserController {
    private LibraryService libraryService;

    @GetMapping("/users")
    public ResponseEntity<List<UserDto>> getAll(){
        log.info("reaching here");
        return libraryService.getAllUsers();
    }

    @GetMapping("/users/{userName}")
    public ResponseEntity<UserDto> getSpecificUser(@PathVariable String userName){
        return libraryService.getSpecificUser(userName);
    }

    @PostMapping("/users")
    public ResponseEntity<UserDto> addUser(@RequestBody UserDto user){
        return libraryService.addUser(user);
    }

    @DeleteMapping("/users/{userName}")
    public ResponseEntity<String> deleteUser(@PathVariable String userName){
        return libraryService.deleteUser(userName);
    }

    @PutMapping("/users/{userName}")
    public ResponseEntity<String> updateUser(@PathVariable String userName,@RequestBody UserDto user){
        return  libraryService.upateUser(userName,user);
    }

}
