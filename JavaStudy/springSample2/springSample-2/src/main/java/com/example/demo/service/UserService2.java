package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.UserEntity2;
import com.example.demo.repository.UserRepository2;

/**
 * ユーザー情報 Service
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserService2{
	/**
	 * ユーザー情報 Repository
	 */
	@Autowired
	 private UserRepository2 userRepository2;

	/**
	 * ユーザー情報 全検索
	 * @return  検索結果
	 */
	public List<UserEntity2> searchAll() {
		return userRepository2.findAll();
	 }
}