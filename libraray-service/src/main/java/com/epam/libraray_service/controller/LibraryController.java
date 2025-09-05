package com.epam.libraray_service.controller;
import com.epam.libraray_service.model.Library;
import com.epam.libraray_service.service.LibraryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/library/users")


public class LibraryController {
    @Autowired
    private LibraryService libraryService;

// Approperiate error handling and custom exception are left
    @PostMapping("/{userName}/books/{booksId}")
    public ResponseEntity<Library> getLibraryUserInformation(@PathVariable String userName,@PathVariable int booksId){
        log.info("hello");
        return libraryService.issueBook(userName,booksId);
    }
    @DeleteMapping("/{userName}/books/{bookId}")
    public ResponseEntity<?> deleteUserDetails(
            @PathVariable String userName,
            @PathVariable int bookId) {
        return libraryService.deleteUserDetails(userName, bookId);
    }

}
