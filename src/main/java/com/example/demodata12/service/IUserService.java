package com.example.demodata12.service;

import com.example.demodata12.data.enity.User;
import com.example.demodata12.data.request.UserRequest;
import java.util.List;

public interface IUserService {
   User createUser(UserRequest user);
   User getById(Long id);
   List<User> findAll();

   User getByUsername(String username);
   void deleteById(Long id);
}
