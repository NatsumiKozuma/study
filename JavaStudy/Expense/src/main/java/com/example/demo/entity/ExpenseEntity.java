
package com.example.demo.entity;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
/**
 * ユーザー情報 Entity(データベースへ登録するためのデータを格納しておくためのクラス)
 */
@Entity
@Table(name = "expense" , schema = "public")
public class ExpenseEntity {

	/**
	 *経費ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "expense_id")
			private int expense_id;

	/**
	 * ユーザーID
	 */
	@Column(name = "user_id")
			private int user_id;
	/**
	 *申請日
	 */
	@Column(name = "application_date")
	private Date application_date;

	/**
	 *経費項目
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "expense_category")
	private String expense_category;

	/**
	 * 金額
	 */
	@Column(name = "amount")
	private int amount;

	/**
	 * 備考
	 */
	@Column(name = "description")
	private String	 description;

	public void setExpenseCategory(Object getexpense_category) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	public void setAmount(Integer amount2) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	public void setApplicationDate(java.sql.Date date) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	public void setDescription(String description2) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

}