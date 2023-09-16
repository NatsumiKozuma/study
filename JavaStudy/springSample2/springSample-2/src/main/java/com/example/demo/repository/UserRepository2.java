package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.UserEntity2;

/**
 * ユーザー情報 Repository
 */
@Repository
public interface UserRepository2 extends JpaRepository<UserEntity2, Long> {

}