package com.biz.bbs.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
/*
 * JPA 기능을 사용하여 table을 자동으로 생성하도록 설정
 * @Entity : JPA에서 논리적인 연산을 수행할 때 사용하도록 설정
 * @Table : 물리적인 table을 만들 때 사용
 * "tbl_bbs"라는 table의 필드 변수를 칼럼 값으로 하여 생성
 */
@Entity
@Table(name="tbl_bbs")
public class BbsVO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long b_id;
	
	@Column(columnDefinition = "VARCHAR(30)")
	private String b_writer;
	
	@Column(length = 30)
	private String b_date_time;
	
	@Column(columnDefinition = "VARCHAR(125)")
	private String b_subject;
	
	@Column(columnDefinition = "VARCHAR(125)")
	private String b_content;
	
	@Column(columnDefinition = "BLOB")
	private int b_count;

}
