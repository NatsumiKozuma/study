package com.example.demo.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;

/**
 * 果物情報 リクエストデータ
 */
@Data
public class FruitsRequest {
  /**
   * ID
   */
  private Integer id;
  
  /**
   * 果物
   */
  @NotEmpty(message = "果物を入力してください")
  @Size(max = 8, message = "果物は8文字以内で入力してください")
  private String fruits;

}
