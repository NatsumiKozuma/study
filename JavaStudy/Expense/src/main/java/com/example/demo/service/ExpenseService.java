package com.example.demo.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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
     * @return 検索結果
     */
	public List<ExpenseEntity> searchAll() {
		// TODO 自動生成されたメソッド・スタブ
		return expenseRepository.findAll();
	}
    

	/**
	   * 経費情報 新規登録
	   * @param　expense 経費情報
	   */

	
	@DateTimeFormat(pattern = "yyyy/MM/dd")
    private Date applicationDate;
	
	public void update(ExpenseRequest expenseRequest) {
		ExpenseEntity expense = findById(expenseRequest.getUser_id());
		if (expense != null) {
			Date sqlDate= Date.valueOf("yyyy/MM/dd");
            expense.setApplicationDate(applicationDate);
			expense.setExpenseCategory(expenseRequest.getexpense_category());
			expense.setAmount(expenseRequest.getAmount());
			expense.setDescription(expenseRequest.getDescription());
			expenseRepository.save(expense);
		}
	}


	private ExpenseEntity findById(Long user_id) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}




	public void create(ExpenseRequest expenseRequest) {
		// TODO 自動生成されたメソッド・スタブ
		
	}
}
    

   
	
