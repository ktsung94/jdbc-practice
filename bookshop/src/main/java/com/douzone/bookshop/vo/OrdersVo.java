package com.douzone.bookshop.vo;

public class OrdersVo {

	private Long no;
	private int price;
	private String location;
	private String orderNo;	// 20200213-00001
	private Long memberNo;
	
	private Long bookNo;
	private Long ordersNo;	// orderNo와 다른 것.
	private String title;
	private int count;
	private String info;
	
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
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
	
	public Long getOrdersNo() {
		return ordersNo;
	}
	public void setOrdersNo(Long ordersNo) {
		this.ordersNo = ordersNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}	
	@Override
	public String toString() {
		return "주문한 사람의 정보 [orderNo : " + orderNo + ", info : " + info + ", price : " + price + ", location : " + location + "]\n"
				+ "주문한 책 [번호 : " + bookNo + ", title : " + title + ", count : " + count + "(권)]";
	}
}
