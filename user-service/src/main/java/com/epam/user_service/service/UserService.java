package com.epam.user_service.service;
import com.epam.user_service.model.User;
import com.epam.user_service.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepository userRepository;

    public List<User> getAll(){
        return userRepository.findAll();
    }
    public User getSpecificUser(String id){
        return userRepository.findById(id).orElseThrow(IllegalAccessError::new);
    }
    public User addUser(User user){
        return userRepository.save(user);
    }

    public String deleteUser(String username){
        Optional<User> existingUser=userRepository.findById(username);

        if(existingUser.isPresent()){
            userRepository.deleteById(username);
            return "User deleted";
        }
        return "User doesnot exist";
    }

    public String updateUser(String username,User user){
        Optional<User> existingUser=userRepository.findById(username);

        if(existingUser.isPresent()){
          User updatedUser=existingUser.get();
          updatedUser.setName(user.getName());
          updatedUser.setEmail(user.getEmail());
          userRepository.save(updatedUser);
            return "User updated";
        }
        return "User does not exist";
    }

}
