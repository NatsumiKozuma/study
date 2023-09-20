package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.service.UserService2;
/**
 * ユーザー情報 Controller
 */
@Controller
public class UserController2 {

//   * ユーザー情報 Service
   
  @Autowired
  private UserService2 userService2;

  /**
   * ユーザー情報一覧画面を表示
   * @param  model Model
   * @return  ユーザー情報一覧画面のHTML
   */
  @RequestMapping("/user/list2")
 	public String listUsers(Model model) {

	  model.addAttribute("users", userService2.searchAll());
      return "user/list2"; 

  }
  
}