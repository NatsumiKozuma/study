package com.example.demo.service;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.ExpenseRequest;
import com.example.demo.entity.ExpenseEntity;
import com.example.demo.repository.ExpenseRepository;

@Service
@Transactional(rollbackFor = Exception.class)
public class ExpenseService {

	/**
	 * ユーザー情報 Repository
	 */
	@Autowired
	private ExpenseRepository expenseRepository;

	/**
	 * 経費情報 全検索
	 * 
	 * @return 検索結果
	 */
	public List<ExpenseEntity> searchAll() {
		// TODO 自動生成されたメソッド・スタブ
		return expenseRepository.findAll();
	}

	/**
	 * 経費情報 新規登録
	 * 
	 * @param expense 経費情報
	 * 
	 * 
	 */
	
	
	private Date applicationDate;

	public void update(ExpenseRequest expenseRequest) {
		ExpenseEntity expense = findById(expenseRequest.getUser_id());
		 java.util.Date applicationDate = convertStringToDate(expenseRequest.getApplicationDate());
		expense.setApplicationDate(applicationDate);
		expense.setExpenseCategory(expenseRequest.getExpenseCategory().toString());
		expense.setAmount(expenseRequest.getAmount());
		expense.setDescription(expenseRequest.getDescription());
		expenseRepository.save(expense);

	}
	
	private java.util.Date convertStringToDate(String dateString) {
		String str = "yyyy-MM-dd";
	    SimpleDateFormat sdf  = new SimpleDateFormat("yyyy-MM-dd");
	    try {
	    	java.util.Date date = sdf.parse(str);
            System.out.println(date.toString());
	    } catch (ParseException e) {
	        e.printStackTrace();
	        return null;
	    }
		return applicationDate;
	}

	private ExpenseEntity findById(int user_id) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}
}
