package com.example.clothstore.clothstore.repository;

import com.example.clothstore.clothstore.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
