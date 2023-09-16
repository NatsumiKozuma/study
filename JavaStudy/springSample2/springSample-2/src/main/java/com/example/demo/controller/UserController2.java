package com.example.demo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.UserEntity2;
import com.example.demo.service.UserService2;
/**
 * ユーザー情報 Controller
 */
@Controller
public class UserController2 {

//   * ユーザー情報 Service
   
  @Autowired
  private UserService2 userService;

  /**
   * ユーザー情報一覧画面を表示
   * @param  model Model
   * @return  ユーザー情報一覧画面のHTML
   */
  @RequestMapping("/user/list")
 	public String displayList(Model model) {

	  List<UserEntity2>   userList  = userService.searchAll();
      model.addAttribute("userList", userList); 
      return "user/list"; 

  }
  
}