package com.example.demo.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.ScoreRequest;
import com.example.demo.dto.ScoreUpdateRequest;
import com.example.demo.entity.ScoreEntity;
import com.example.demo.repository.ScoreRepository;

/**
 * ユーザー情報 Service
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ScoreService {

	/**
	 *スコア 情報 Repository
	 */
	@Autowired
	  private ScoreRepository scoreRepository;
	
	/**
	   * スコア情報 主キー検索
	   * @return 検索結果
	   */
	  public ScoreEntity findById(Integer id) {
	    return scoreRepository.findById(id).orElse(null);
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
	 */

    public void create(ScoreRequest scoreRequest) {
    	ScoreEntity score = new ScoreEntity();
		score.setName(scoreRequest.getName());
		score.setMath_score(scoreRequest.getMath_score());
		score.setEnglish_score(scoreRequest.getEnglish_score());
		scoreRepository.save(score);

	}

    /**
     * スコア情報 更新
     * @param user スコア情報
     */
    public void update(ScoreUpdateRequest scoreUpdateRequest) {
    ScoreEntity score = findById(scoreUpdateRequest.getId());
    score.setName(scoreUpdateRequest.getName());
	score.setMath_score(scoreUpdateRequest.getMath_score());
	score.setEnglish_score(scoreUpdateRequest.getEnglish_score());
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