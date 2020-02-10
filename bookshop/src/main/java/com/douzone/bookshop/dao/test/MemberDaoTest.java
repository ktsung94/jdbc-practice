package com.douzone.bookshop.dao.test;

import java.util.List;

import com.douzone.bookshop.dao.MemberDao;
import com.douzone.bookshop.vo.MemberVo;

public class MemberDaoTest {

	public static void main(String[] args) {
		//insertTest("한해용", "010-5567-7317", "yong80211@gmail.com", "1234");
		//insertTest("유재석", "010-2345-6789", "you@naver.com", "5678");
		selectTest();
	}
	
	public static void selectTest() {
		List<MemberVo> list = new MemberDao().findAll();
		for(MemberVo vo : list) {
			System.out.println(vo);
		}
	} 

	public static void insertTest(String name, String number, String email, String password) {
		MemberVo vo = new MemberVo();
		vo.setName(name);
		vo.setNumber(number);
		vo.setEmail(email);
		vo.setPassword(password);
		
		new MemberDao().insert(vo);
	}
}
