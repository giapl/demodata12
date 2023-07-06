package com.example.demodata12.contronller;


import com.example.demodata12.data.enity.User;
import com.example.demodata12.data.request.UserRequest;
import com.example.demodata12.service.IUserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserContronller {

  @Autowired
  private IUserService iUserService;

  @PostMapping("/user")
  public ResponseEntity<?> createUser(@RequestBody UserRequest user) {
    User user1 = iUserService.createUser(user);
    return ResponseEntity.ok(user1);
  }

  @GetMapping("/id")
  public ResponseEntity<?> getById(@RequestParam Long id) {
    User user = iUserService.getById(id);
    return ResponseEntity.ok(user);
  }

  @GetMapping("/all")
  public ResponseEntity<?> findAll() {
    List<User> userList = iUserService.findAll();
    return ResponseEntity.ok(userList);
  }

  @GetMapping("/username")
  public ResponseEntity<?> getByUsername(@RequestParam String username) {
    User userRequest = iUserService.getByUsername(username);
    return ResponseEntity.ok(userRequest);
  }

  @DeleteMapping("/delete")
  public ResponseEntity<?> deleteById(@RequestParam Long id) {
    iUserService.deleteById(id);
    return ResponseEntity.ok("dã xoa thanh cong account có id: " + id);
  }
  @GetMapping("/search")
  public ResponseEntity<?> getByIdAndUsername(@RequestParam Long id, String username){
    User user2= iUserService.getByIdAndUsername(id,username);
    return ResponseEntity.ok(user2);
  }
}
