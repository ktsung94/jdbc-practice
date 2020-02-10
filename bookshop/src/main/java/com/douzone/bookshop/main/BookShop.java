package com.douzone.bookshop.main;

import com.douzone.bookshop.dao.test.BookDaoTest;
import com.douzone.bookshop.dao.test.CartDaoTest;
import com.douzone.bookshop.dao.test.CategoryDaoTest;
import com.douzone.bookshop.dao.test.MemberDaoTest;
import com.douzone.bookshop.dao.test.OrderDaoTest;

public class BookShop {

	public static void main(String[] args) {

		// 카테고리 : 소설, 수필...이 나오게 출력
		//new CategoryDaoTest().main(args);
		CategoryDaoTest.insertTest("IT");
		CategoryDaoTest.insertTest("소설");
		CategoryDaoTest.insertTest("인문");
		CategoryDaoTest.selectTest();
		System.out.println("========================");

		// 서적 : 제목, 가격이 나오게 출력
		//new BookDaoTest().main(args);
		BookDaoTest.insertTest("이것은 자바다", 8500, 2L);
		BookDaoTest.insertTest("해리포터", 10000, 3L);
		BookDaoTest.insertTest("팩트폴니스", 10000, 3L);
		BookDaoTest.selectTest();
		System.out.println("========================");
		
		// 고객 : 이름, 전화번호, 이메일, 비밀번호가 나오게 출력
		//new MemberDaoTest().main(args);
		MemberDaoTest.insertTest("한해용", "010-5567-7317", "yong80211@gmail.com", "1234");
		MemberDaoTest.insertTest("유재석", "010-2345-6789", "you@naver.com", "5678");
		MemberDaoTest.selectTest();
		System.out.println("========================");

		// 카트 : 도서제목, 수량, 가격이 나오게 출력
		//new CartDaoTest().main(args);
		CartDaoTest.insertTest(1L, 1L, 3);
		CartDaoTest.insertTest(2L, 2L, 2);
		CartDaoTest.selectTest();
		System.out.println("========================");
		
		// 주문 : 주문번호, 주문자, 결제금액, 배송지이 나오게 출력
		//new OrderDaoTest().main(args);
		OrderDaoTest.insertOrderTest(10000, "서울", "20200114-00001", 1L);

		// 주문도서 : 도서번호, 도서제목, 수량
		OrderDaoTest.insertOrderBookTest(1L, 1L, 5);
		OrderDaoTest.insertOrderBookTest(1L, 2L, 7);
		OrderDaoTest.insertOrderBookTest(1L, 3L, 8);

		OrderDaoTest.selectTest();





	}

}
