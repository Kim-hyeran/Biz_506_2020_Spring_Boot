package com.biz.bbs;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InitData {
	
	public CommandLineRunner initData() {
		
		return new CommandLineRunner() {
			
			@Override
			public void run(String... args) throws Exception {
				// TODO Auto-generated method stub
				System.out.println("여기는 초기화 method");
			}
		};
	}

}
