package com.example.demo.dto;

import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

/**
 * 経費情報 リクエストデータ
 */
@Data
public class ScoreRequest implements Serializable {

	/**
	 * 名前
	 */
	
	@Size(min=1, max=10,message ="10文字以内にしてください")
	@NotNull(message = "名前を入力してください")
	private String name;

	/**
	 * 数学のスコア
	 */
	@NotNull(message = "0~100の数値を入力してください")
	@Min(value = 0, message = "点数は0以上である必要があります")
	@Max(value = 100, message = "点数は100以下である必要があります")
	private Integer math_score;
	
	/**
	 * 英語のスコア
	 */
	@NotNull(message = "0~100の数値を入力してください")
	@Min(value = 0, message = "点数は0以上である必要があります")
	@Max(value = 100, message = "点数は100以下である必要があります")
	private Integer english_score;


}