package com.openclassrooms.service;

import com.openclassrooms.model.User;
import com.openclassrooms.repositories.UserRepository;
import com.openclassrooms.webParams.ContactParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User save(ContactParams contactParams) {
        final User user = new User();
        user.setEmail(contactParams.getEmail());

        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Integer id) {
        return userRepository.findById(id);
    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public Optional<User> getUserByEmailAndPassword(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }

    public void createUser(User user) {
        userRepository.save(user);
    }

    public void updateUser(User user) {
        Optional<User> modified = userRepository.findById(user.getUserId());
        if (modified.isPresent()) {
            userRepository.save(user);
        }
    }

    public void deleteUser(User user) {
        Optional<User> removeUser = userRepository.findById(user.getUserId());
        if (removeUser.isPresent()) {
            userRepository.deleteById(user.getUserId());
        }
    }

    public void addFriend(User user, User myFriend) {
        user.getContact().add(myFriend);
        userRepository.save(user);
    }

    public void removeFriend(User user, User friendUser) {
        user.getContact().remove(friendUser);
        userRepository.save(user);
    }
  /*  public void addAccount (User user, Account account){
        user.getAccount();
        userRepository.save(user);
    }
    public  void removeAccount (User user, Account account){
        user.getAccountList().remove(account);
        userRepository.save(user);
    }*/
  /*  public void addTransfer (User user, Transaction transaction){
        user.getTransactionList().add(transaction);
        userRepository.save(user);
    }
    public void removeTransfer (User user, Transaction transaction){
        .remove(transaction);
        userRepository.save(user);
    }*/


}
