package com.biz.bbs.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.biz.bbs.domain.BbsVO;
import com.biz.bbs.domain.persistence.BbsDao;

@CrossOrigin({"http://localhost:3000", "*"})
@RestController
@RequestMapping(value="/api")
public class BbsApiController {
	
	@Autowired
	private BbsDao bbsDao;
	
	@RequestMapping(value="/bbsList", method=RequestMethod.GET)
	public List<BbsVO> List() {
		
		List<BbsVO> bbsList = bbsDao.findAll();
		
		return bbsList;
	}
	
	@RequestMapping(value="/view/{id}", method=RequestMethod.GET)
	public BbsVO findBy(@PathVariable("id") String id) {
		Optional<BbsVO> optionalVO = bbsDao.findById(Long.valueOf(id));
		BbsVO bbsVO = optionalVO.get();
		
		return bbsVO;
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String insert(@ModelAttribute BbsVO bbsVO) {
		bbsDao.save(bbsVO);
		
		return "OK";
	}

}
