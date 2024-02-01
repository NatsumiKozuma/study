package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.FruitsRequest;
import com.example.demo.entity.FruitsEntity;
import com.example.demo.repository.FruitsRepository;

/**
 * 果物情報 Service
 */
@Service
public class FruitsService {
	/**
	 * 果物情報 Repository
	 */
	@Autowired
	private FruitsRepository fruitsRepository;

	/**
	 * 果物情報 全検索
	 * @return  検索結果
	 */
	public List<FruitsEntity> searchAll() {
		return fruitsRepository.findAll();
	}
	/**
	 * 果物情報 新規登録
	 * @param  fruits 果物情報
	 */
	public void create(FruitsRequest fruitsRequest) {
		FruitsEntity fruits = new FruitsEntity();
		fruits.setFruits(fruitsRequest.getFruits());
		fruitsRepository.save(fruits);
	}
	/**
	 * 果物情報 主キー検索
	 * @return  検索結果
	 */
	public FruitsEntity findById(Integer id) {
		return fruitsRepository.getOne(id);
	}
	
	/**
	 * 果物情報 更新
	 * @param  subject 果物情報
	 */
	public void update(FruitsRequest fruitsUpdateRequest) {
		FruitsEntity fruits = findById(fruitsUpdateRequest.getId());
		fruits.setFruits(fruitsUpdateRequest.getFruits());
		fruitsRepository.save(fruits);
	}
	/**
	 * 果物情報 物理削除
	 * @param  id ID
	 */
	public void delete(Integer id) {
		FruitsEntity fruits = findById(id);
		fruitsRepository.delete(fruits);
	}
}