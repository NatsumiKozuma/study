package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.UserEntity2;

/**
 * ユーザー情報 Repository
 */

public interface UserRepository2 extends JpaRepository<UserEntity2, Long> {

}