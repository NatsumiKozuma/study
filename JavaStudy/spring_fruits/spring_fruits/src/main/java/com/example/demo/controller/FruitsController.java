package com.example.demo.controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dto.FruitsRequest;
import com.example.demo.entity.FruitsEntity;
import com.example.demo.service.FruitsService;

/**
 * 果物情報 Controller
 */
@Controller
public class FruitsController {

	/**
	 * 果物情報 Service
	 */
	@Autowired
	FruitsService fruitsService;

	/**
	 * 果物情報一覧画面を表示
	 * @param  model Model
	 * @return  果物情報一覧画面のHTML
	 */
	@GetMapping("/fruits/list")
	public String fruitsList(Model model) {
		List<FruitsEntity> fruitslist = fruitsService.searchAll();
		model.addAttribute("fruitslist", fruitslist);
		return "fruits/list";
	}
	/**
	 * 果物新規登録画面を表示
	 * @param  model Model
	 * @return  果物情報一覧画面
	 */
	@GetMapping("/fruits/add")
	public String fruitsRegister(Model model) {
		model.addAttribute("fruitsRequest", new FruitsRequest());
		return "fruits/add";
	}
	/**
	 * 果物新規登録
	 * @param  userRequest リクエストデータ
	 * @param  model Model
	 * @return  果物情報一覧画面
	 */
	@PostMapping("/fruits/create")
	public String fruitsCreate(@Validated  @ModelAttribute  FruitsRequest fruitsRequest, BindingResult result, Model model) {
		if (result.hasErrors()) {
			// 入力チェックエラーの場合
			List<String> errorList = new ArrayList<String>();
			for (ObjectError error : result.getAllErrors()) {
				errorList.add(error.getDefaultMessage());
			}
			model.addAttribute("fruitsRequest", new FruitsRequest());
			model.addAttribute("validationError", errorList);
			return "fruits/add";
		}
		// 果物情報の登録
		fruitsService.create(fruitsRequest);
		return "redirect:/fruits/list";
	}	
	/**
	 * 果物情報詳細画面を表示
	 * @param  id 表示する科目ID
	 * @param  model Model
	 * @return  果物情報詳細画面
	 */
	@GetMapping("/fruits/{id}")
	public String userDetail(@PathVariable  Integer id, Model model) {
		FruitsEntity fruits = fruitsService.findById(id);
		model.addAttribute("fruits", fruits);
		return "fruits/detail";
	}
	/**
	 * 果物編集画面を表示
	 * @param  id 表示する科目ID
	 * @param  model Model
	 * @return  果物編集画面
	 */
	@GetMapping("/fruits/{id}/edit")
	public String userEdit(@PathVariable  Integer id, Model model) {
		FruitsEntity fruits = fruitsService.findById(id);
		FruitsRequest fruitsUpdateRequest = new FruitsRequest();
		fruitsUpdateRequest.setId(fruits.getId());
		fruitsUpdateRequest.setFruits(fruits.getFruits());
		model.addAttribute("fruitsUpdateRequest", fruitsUpdateRequest);
		return "fruits/edit";
	}
	/**
	 * 果物更新
	 * @param  userRequest リクエストデータ
	 * @param  model Model
	 * @return  果物情報詳細画面
	 */
	@PostMapping("/fruits/update")
	public String fruitsUpdate(@Validated  @ModelAttribute FruitsRequest fruitsUpdateRequest, BindingResult result, Model model) {
		if (result.hasErrors()) {
			List<String> errorList = new ArrayList<String>();
			for (ObjectError error : result.getAllErrors()) {
				errorList.add(error.getDefaultMessage());
			}
			model.addAttribute("validationError", errorList);
			return "fruits/edit";
		}
		// 果物情報の更新
		fruitsService.update(fruitsUpdateRequest);
		return String.format("redirect:/fruits/%d", fruitsUpdateRequest.getId());
	}
	/**
	 * 果物情報削除
	 * @param  id 表示するID
	 * @param  model Model
	 * @return  果物情報詳細画面
	 */
	@GetMapping("/fruits/{id}/delete")
	public String fruitsDelete(@PathVariable Integer id, Model model) {
		// 果物情報の削除
		fruitsService.delete(id);
		return "redirect:/fruits/list";
	}
}
