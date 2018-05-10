package com.example.springboot.dao;

import com.example.springboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created with IDEA
 * Author: GuiqiHu
 * Created in: 2018/4/26 19:15
 */
public interface UserRepository extends JpaRepository<User, Integer> {
}
