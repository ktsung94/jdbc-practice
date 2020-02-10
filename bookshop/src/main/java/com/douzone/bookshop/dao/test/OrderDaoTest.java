package com.douzone.bookshop.dao.test;

import java.util.List;

import com.douzone.bookshop.dao.OrderDao;
import com.douzone.bookshop.vo.OrdersVo;

public class OrderDaoTest {

	public static void main(String[] args) {
//		insertOrderTest(10000, "서울", "20200114-00001", 1L);
//		
//		insertOrderBookTest(1L, 2L, 1);
//		insertOrderBookTest(1L, 2L, 2);
		selectTest();
	}
	
	public static void selectTest() {
		List<OrdersVo> list = new OrderDao().findAll();
		for(OrdersVo vo : list) {
			System.out.println(vo);
		}
	} 

	public static void insertOrderTest(int price, String location, String orderNo, Long memberNo) {
		OrdersVo vo = new OrdersVo();
		vo.setPrice(price);
		vo.setLocation(location);
		vo.setOrderNo(orderNo);
		vo.setMemberNo(memberNo);
		
		new OrderDao().insertOrder(vo);
	}
	
	public static void insertOrderBookTest(Long ordersNo, Long bookNo, int count) {
		OrdersVo vo = new OrdersVo();
		vo.setOrdersNo(ordersNo);
		vo.setBookNo(bookNo);
		vo.setCount(count);
		
		new OrderDao().insertOrderBook(vo);
	}
}
