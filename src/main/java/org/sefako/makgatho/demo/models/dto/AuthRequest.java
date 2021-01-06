package org.sefako.makgatho.demo.models.dto;

public class AuthRequest {
	private Long studentNum;
	private String password;
	
	public Long getStudentNum() {
		return studentNum;
	}
	public void setStudentNum(Long studentNum) {
		this.studentNum = studentNum;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
