package com.epam.book_service.controller;
import com.epam.book_service.model.Book;
import com.epam.book_service.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
@AllArgsConstructor
public class BookController {
    private BookService bookService;

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks(){
     return  ResponseEntity.ok(bookService.getAllBooks());
    }
    @PostMapping
    public  ResponseEntity<Book> addBook(@RequestBody Book book){
        return ResponseEntity.ok(bookService.addBook(book));
    }
    @GetMapping("{id}")
    public ResponseEntity<Book> getSpecificBook(@PathVariable int id){
        return  ResponseEntity.ok(bookService.getBook(id));
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteBook(@PathVariable int id){
        return ResponseEntity.ok(bookService.deleteBook(id));
    }
    @PutMapping("{id}")
    public ResponseEntity<String> updateBook(@PathVariable int id,@RequestBody Book book){
        return  ResponseEntity.ok(bookService.updateBook(id, book));
    }
}
