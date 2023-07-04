package com.example.demodata12.service;

import com.example.demodata12.data.dao.IUserRepository;
import com.example.demodata12.data.enity.User;
import com.example.demodata12.data.request.UserRequest;
import java.util.List;
import java.util.Optional;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IUserServiceImpl implements IUserService {

  @Autowired
  private IUserRepository iUserRepository;

  @Override
  public User createUser(UserRequest user) {
    User user1 = new User();
    user1.setUsername(user.getUsername());
    user1.setPassword(user.getPassword());
    return iUserRepository.save(user1);
  }

  @SneakyThrows
  @Override
  public User getById(Long id) {
    Optional<User> userOptional = iUserRepository.findById(id);
    if (userOptional.isPresent()) {
      return userOptional.get();
    } else {
      throw new Exception("loi id");
    }
  }

  @Override
  public List<User> findAll() {
    return iUserRepository.findAll();
  }

  @Override
  public User getByUsername(String username) {
    return iUserRepository.findByUsername(username);
  }

  @Override
  public void deleteById(Long id) {
    iUserRepository.deleteById(id);
  }
}
