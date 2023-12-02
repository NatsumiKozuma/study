package com.example.demo.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.ScoreRequest;
import com.example.demo.entity.ScoreEntity;
import com.example.demo.repository.ScoreRepository;

@Service
@Transactional(rollbackFor = Exception.class)
public class ScoreService {

	/**
	 * 情報 Repository
	 */
	@Autowired
	 ScoreRepository scoreRepository;
	
	/**
	   * スコア情報 主キー検索
	   * @return 検索結果
	   */
	  public ScoreEntity findById(Integer id) {
	    return scoreRepository.findById(id).get();
	  }
    
	/**
	 * スコア情報 全検索
	 * 
	 * @return 検索結果
	 */
	public List<ScoreEntity> searchAll() {
		return scoreRepository.findAll();
	}

	
	/**
	 * スコア情報 新規登録
	 * 
	 * @param score スコア情報
	 * 
	 * 
	 */

    public void update(ScoreRequest scoreRequest) {
		ScoreEntity score = new ScoreEntity();
		score.setName(scoreRequest.getName());
		score.setMath_score(scoreRequest.getMath_score());
		score.setEnglish_score(scoreRequest.getEnglish_score());
		scoreRepository.save(score);

	}

    /**
	   * スコア情報 物理削除
	   * @param id ユーザーID
	   */
	  public void delete(Integer id) {
	    ScoreEntity score = findById(id);
	    scoreRepository.delete(score);
	  }
}