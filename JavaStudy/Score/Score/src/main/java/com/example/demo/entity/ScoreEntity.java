package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Data
@Entity
@Table(name = "score" , schema = "public")
public class ScoreEntity implements Serializable{
/**
 *ID
 */
@Id
@Column(name = "id")
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;

/**
 *名前
 */
@Column(name = "name")
private String name;
/**
 *数学のスコア
 */
@Column(name = "math_score")
private Integer Math_score;

/**
 *英語のスコア
 */
@Column(name = "english_score")
private Integer English_score;


}