package com.example.demodata12.repository;

import com.example.demodata12.data.enity.User;
import java.util.List;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {

  // mấy tên hàm mà JPA có support thì không cần viết NativeQuery nữa, gọi thẳng là được.
  // JPA hien thi tat ca duw lieu trong db
  @Query(value = "select *from demo.test", nativeQuery = true)
  List<User> findAll();

  // Jpa lay du lieu ra theo id
  @Query(value = "select * from demo.test where id= :id", nativeQuery = true)
  Optional<User> findById(@Param("id") Long id);

  // jpql lay du lieu ra theo username
  @Query(value = "select * from demo.test where username= :username", nativeQuery = true)
  User findByUsername(@Param("username") String username);

  // jpa xoa du lieu theo id
  @Query(value = "delete from demo.test where id= :id", nativeQuery = true)
  void deleteById(@Param("id") Long id);

  // jpa tim theo id and username
  @Query(value = "select * from demo.test where id= :id and username= :username", nativeQuery = true)
  User findByIdAndUsername(@Param("id") Long id, @Param("username") String username);
}
