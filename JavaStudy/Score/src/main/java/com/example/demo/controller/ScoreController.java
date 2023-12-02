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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.dto.ScoreRequest;
import com.example.demo.entity.ScoreEntity;
import com.example.demo.service.ScoreService;

@Controller
public class ScoreController {

	@Autowired
	private ScoreService scoreService;
	
	/**
	 * スコア一覧画面を表示
	 * @param model Model
	 * @return スコア情報一覧画面
	 */
	@GetMapping(value = "/score/list")
	public String displayList(Model model) {
		List<ScoreEntity> scorelist = scoreService.searchAll();
		model.addAttribute("scorelist", scorelist);
		return "score/list";
	}

	/**
	 * スコア新規登録画面を表示
	 * @param model Model
	 * @return スコア情報一覧画面
	 */
	@GetMapping("/score/add")
	public String displayAdd(Model model) {
		model.addAttribute("scoreRequest", new ScoreRequest());
		return "score/add";
	}


	/**
	 * データベースへの登録
	 * @param userRequest リクエストデータ
	 * @param model Model
	 * @return スコア一覧画面
	 */
	@RequestMapping(value = "/score/update", method = RequestMethod.POST)
	public String update(@ModelAttribute @Validated  ScoreRequest scoreRequest, BindingResult result, Model model) {

		if (result.hasErrors()) {
			// 入力チェックエラーの場合
			List<String> errorList = new ArrayList<String>();
			for (ObjectError error : result.getAllErrors()) {
				errorList.add(error.getDefaultMessage());
			}
			model.addAttribute("validationError", errorList);
			return "score/add";
		}
		// スコア情報の登録
		scoreService.update(scoreRequest);
		return "redirect:/score/list";
	}

	 /**
     * 経費情報削除
     * @param id 表示するユーザーID
     * @param model Model
     * @return  一覧画面
     */
    @GetMapping("/score/{id}/delete")
    public String delete(@PathVariable Integer id, Model model) {
      // スコア情報の削除
      scoreService.delete(id);
      return "redirect:/score/list";
    }

}