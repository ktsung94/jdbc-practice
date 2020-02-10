package com.douzone.bookmall.test;

import java.util.List;

import com.douzone.bookmall.dao.BookDao;
import com.douzone.bookmall.vo.BookVo;

public class BookDaoTest {

	public static void main(String[] args) {
//		insertTest("트와일라잇", "대여가능", 1L);
//		insertTest("뉴문", "대여가능", 1L);
//		insertTest("이클립스", "대여가능", 1L);
//		insertTest("브레이킹던", "대여가능", 1L); 	  // 1L : 스테파니메이어
//		insertTest("아리랑", "대여가능", 2L);	 	  // 2L : 조정래
//		insertTest("젊은그들", "대여중", 3L); 	 	  // 3L : 김동인
//		insertTest("아프니까 청춘이다", "대여가능", 4L); // 4L : 김난도
//		insertTest("귀천", "대여가능", 5L); 		  // 5L : 천상병
//		insertTest("태백산맥", "대여가능", 6L);		  // 6L : 조정래
//		insertTest("풀하우스", "대여가능", 7L);		  // 7L : 원수연
		selectTest();
	}

	public static void insertTest(String title, String state, Long authorNo) {
		BookVo bookVo = new BookVo();
		bookVo.setTitle(title);
		bookVo.setState(state);
		bookVo.setAuthorNo(authorNo);
		
		new BookDao().insert(bookVo);
	}
	
	public static void selectTest() {
		List<BookVo> list = new BookDao().findAll();
		for(BookVo vo : list) {
			System.out.println(vo);
		}
	} 
}
