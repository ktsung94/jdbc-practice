package com.douzone.bookshop.dao.test;

import java.util.List;

import com.douzone.bookshop.dao.CartDao;
import com.douzone.bookshop.vo.CartVo;

public class CartDaoTest {

	public static void main(String[] args) {
		//insertTest(1L, 1L, 3);
		//insertTest(1L, 2L, 2);
		selectTest();
	}
	
	public static void selectTest() {
		List<CartVo> list = new CartDao().findAll();
		for(CartVo vo : list) {
			System.out.println(vo);
		}
	} 

	public static void insertTest(Long memberNo, Long bookNo, int count) {
		CartVo vo = new CartVo();
		vo.setMemberNo(memberNo);
		vo.setBookNo(bookNo);
		vo.setCount(count);
		
		new CartDao().insert(vo);
	}
}
