package com.example.demo.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;
/**
 * スコア情報更新リクエストデータ
 *
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class ScoreUpdateRequest extends ScoreRequest implements Serializable {
  /**
   * ユーザーID
   */
  @NotNull
  private Integer id;
}