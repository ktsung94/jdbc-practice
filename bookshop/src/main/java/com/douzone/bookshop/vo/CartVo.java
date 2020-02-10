package com.douzone.bookshop.vo;

public class CartVo {

	private Long memberNo;
	private Long bookNo;
	private int count; 		
	
	private String title;
	private int price;
	
	public Long getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(Long memberNo) {
		this.memberNo = memberNo;
	}
	public Long getBookNo() {
		return bookNo;
	}
	public void setBookNo(Long bookNo) {
		this.bookNo = bookNo;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "고객 " + memberNo + " 카트에 담긴 도서 [제목 : " + title + ", 개수 : " + count + "(권), 가격 : " + price + "원]";
	}
}
