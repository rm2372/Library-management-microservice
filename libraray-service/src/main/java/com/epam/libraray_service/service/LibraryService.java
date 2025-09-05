package com.epam.libraray_service.service;

import com.epam.libraray_service.Repository.LibraryRepository;
import com.epam.libraray_service.client.BookFeignCLient;
import com.epam.libraray_service.client.UserFeignClient;
import com.epam.libraray_service.dto.BookDto;
import com.epam.libraray_service.dto.UserDto;
import com.epam.libraray_service.model.Library;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@AllArgsConstructor
@Service
public class LibraryService {

    private LibraryRepository libraryRepository;
    private UserFeignClient userFeignClient;
    private BookFeignCLient bookFeignCLient;

    //books
    public ResponseEntity<List<BookDto>> getallBooks(){
      return   bookFeignCLient.getAllBooks();
    }

    public ResponseEntity<BookDto> getSpecificBook(int boookId){
        return bookFeignCLient.getSpecificBook(boookId);
    }
    public  ResponseEntity<BookDto> addBook(BookDto bookDto){
        return bookFeignCLient.addBook(bookDto);
    }

    public ResponseEntity<String> updateBook(int id, BookDto bookDto){
        return bookFeignCLient.updateBook(id,bookDto);
    }

    public ResponseEntity<String> deleteBook(int id){
        return bookFeignCLient.deleteBook(id);
    }

    //users
    public ResponseEntity<List<UserDto>> getAllUsers(){
        return userFeignClient.getAll();
    }

    public ResponseEntity<UserDto> getSpecificUser(String username){
        return userFeignClient.getSpecificUser(username);
    }

    public ResponseEntity<UserDto> addUser(UserDto userDto){
        return userFeignClient.addUser(userDto);
    }

    public ResponseEntity<String> upateUser(String username,UserDto userDto){
        return userFeignClient.updateUser(username,userDto);
    }

    public  ResponseEntity<String> deleteUser(String username){
        return userFeignClient.deleteUser(username);
    }

    //Special use case points

    public ResponseEntity<Library> issueBook(String userName, int id){

        List<Library> existingIssuedBook=libraryRepository.findByBook(id);

        if(!existingIssuedBook.isEmpty() && !existingIssuedBook.get(0).getUsername().equalsIgnoreCase(userName)){
            throw new  IllegalArgumentException("Book is already issued to "+ existingIssuedBook.get(0).getUsername());
        }
        if(!existingIssuedBook.isEmpty() && existingIssuedBook.get(0).getUsername().equalsIgnoreCase(userName)){
            throw new  IllegalArgumentException("Book is already issued to you"+ existingIssuedBook.get(0).getUsername());
        }
            List<Library> listOfBooksWithUser=libraryRepository.findByUsername(userName);

            if(listOfBooksWithUser.size()>=3){
                throw new RuntimeException("Exceeded amount of books");  //create a custom exception to make code more good
            }

            Library libraryRecord=new Library();
            libraryRecord.setUsername(userName);
            libraryRecord.setBook(id);
            libraryRepository.save(libraryRecord);
            return ResponseEntity.ok(libraryRecord);
    }

    public ResponseEntity<Library> deleteUserDetails(String userName,int id){
        Library collection=libraryRepository.findByUsernameAndBook(userName,id);
        if(collection==null){
            throw new IllegalArgumentException("Cannot delete the non-existing user");
        }
        libraryRepository.delete(collection);
        return ResponseEntity.ok(collection);
    }
}
