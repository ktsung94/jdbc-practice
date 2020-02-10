package com.douzone.bookshop.vo;

public class MemberVo {
	
	private Long no;
	private String name;
	private String number;
	private String email;
	private String password;
	
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "고객 " + no +" [이름 : " + name + ", 전화번호 : " + number + ", email : " + email + ", 비밀번호 : "
				+ password + "]";
	}
}
