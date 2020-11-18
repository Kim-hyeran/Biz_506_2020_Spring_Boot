package com.biz.bbs.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.biz.bbs.domain.BbsVO;

public interface BbsDao extends JpaRepository<BbsVO, Long> {

}
