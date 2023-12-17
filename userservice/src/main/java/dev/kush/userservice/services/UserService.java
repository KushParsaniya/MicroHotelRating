package dev.kush.userservice.services;

import dev.kush.userservice.models.User;

import java.util.List;

public interface UserService {
    // save user
    User saveUser(User user);

    //get user by id
    User getUser(Long userId);

    //get all users
    List<User>  getAllUsers();

    //get users with their ratings
    User getUsersWithDetails(Long userId);


    //TODO: update user

    //TODO: delete user


}
