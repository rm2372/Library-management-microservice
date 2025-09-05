package com.epam.libraray_service.controller;
import com.epam.libraray_service.dto.BookDto;
import com.epam.libraray_service.service.LibraryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/library")
@Slf4j
public class LibraryBookController {
    @Autowired
    private LibraryService libraryService;

    @GetMapping("/books")
    public ResponseEntity<List<BookDto>> getallBooks(){
        log.info("checking purpose");
      return   libraryService.getallBooks();
    }
    @GetMapping("/books/{bookId}")
    public ResponseEntity<BookDto> getSpecificBook(@PathVariable int bookId){
        log.info("reached here");
         return    libraryService.getSpecificBook(bookId);
    }
    @PostMapping("/books")
    public ResponseEntity<BookDto> addBook(@RequestBody BookDto bookDto){
        log.info("reached here add");
        return libraryService.addBook(bookDto);
    }
    @PutMapping("/books/{bookId}")
    public ResponseEntity<String> updateBook(@PathVariable int bookId, @RequestBody BookDto bookDto){
        log.info("reached here update");
        return libraryService.updateBook(bookId,bookDto);
    }

    @DeleteMapping("/books/{bookId}")
    public ResponseEntity<String> deleteBook(@PathVariable int bookId){
        log.info("reached here Delete");
        return libraryService.deleteBook(bookId);
    }



}
