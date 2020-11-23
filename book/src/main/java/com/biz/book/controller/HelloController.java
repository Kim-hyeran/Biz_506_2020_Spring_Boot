package com.biz.book.controller;

import com.biz.book.domain.BookVO;
import com.biz.book.service.BookService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class HelloController {

	@Qualifier("bookServiceV1")
	private final BookService bookService;

	public HelloController(BookService bookService) {
		this.bookService = bookService;
	}

//	@ResponseBody
	@RequestMapping(value="", method=RequestMethod.GET)
	public String Hello() {
//		return "Hello Spring-boot web Application";
		return "home";
	}
	
	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("username", "목요일");
		model.addAttribute("tel", "010-2020-1119");
		
		return "home";
	}

	@RequestMapping(value = "/car", method = RequestMethod.GET)
	public String car(Model model) {
		BookVO bookVO = BookVO.builder().title("자바야 놀자").author("홍길동").comp("우리동네서점").build();
		model.addAttribute("BOOK", bookVO);

		return "book/list-ex";
	}

}
