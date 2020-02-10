package com.douzone.bookshop.dao.test;

import java.util.List;

import com.douzone.bookshop.dao.CategoryDao;
import com.douzone.bookshop.vo.CategoryVo;


public class CategoryDaoTest {

	public static void main(String[] args) {
		insertTest("수필");
		insertTest("소설");
		insertTest("it");
		selectTest();
	}
	
	public static void selectTest() {
		List<CategoryVo> list = new CategoryDao().findAll();
		for(CategoryVo vo : list) {
			System.out.println(vo);
		}
	} 

	public static void insertTest(String name) {
		CategoryVo vo = new CategoryVo();
		vo.setName(name);
		
		new CategoryDao().insert(vo);
	}
}
