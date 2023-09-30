package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.UserEntity;
import com.example.demo.repository.UserRepository;

/**
 * ユーザー情報 Service
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserService{
	/**
	 * ユーザー情報 Repository
	 */
	
	 private UserRepository userRepository;
	 
	 
	 public UserService(UserRepository userRepository) {
	        this.userRepository = userRepository;
	    }
	/**
	 * ユーザー情報 全検索
	 * @return  検索結果
	 */
	public List<UserEntity> searchAll() {
		return userRepository.findAll();
	 }
}
