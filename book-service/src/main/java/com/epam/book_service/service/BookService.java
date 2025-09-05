package com.epam.book_service.service;

import com.epam.book_service.Repository.BookRepository;
import com.epam.book_service.model.Book;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BookService {
    private BookRepository bookRepository;

    public List<Book> getAllBooks(){
      return   bookRepository.findAll();
    }
    public Book getBook(int id){
        return bookRepository.findById(id).get();
    }

    public Book addBook(Book book){
        return  bookRepository.save(book);
    }

    public String deleteBook(int id){
         bookRepository.deleteById(id);
         return "Book deleted successfully";
    }
   public String updateBook(int id,Book uBook){
       Optional<Book>   existingBook= bookRepository.findById(id);

       if(existingBook.isPresent()){
           Book book=existingBook.get();
           book.setAuthor(uBook.getAuthor());
           book.setName(uBook.getName());
           book.setPublisher(uBook.getPublisher());
           bookRepository.save(book);
           return "Book updated";
       }
      return "Book with id not found";

   }


}
