/**
 * File Name 	: ClientInfo.Java
 * Version 		: 0.1
 * Writer		: KMS
 * Project Name	: Sogong
 * Funtion		: JSP - Servlet이 주고 받는 Client(고객)의 정보를 담기 위한 Attribute Model Class
 * 				  EL-Expression으로서 사용하기 위해 각 멤버 변수는 getter와 setter 함수를 가진다.
 * 				  EL-Expression를 사용하기 위해 변수를 명명하는 규칙이 존재하기 때문에 private변수지만 변수명에 Underscore(_)를 포함시키지 않는다.
 */

package com.example.sogong.model;

public class ClientInfo {
	// Client(회원)의 정보를 담기 위한 멤버 변수 선언
	private int clientId;
	private String clientName;
	private String phoneNumber;
	private String address;
	private String ssn;
	private String login_Id;
	private String login_Pw;
	
	// 외부에서 Read/Write를 할 수 있도록 Getter / Setter 함수를 선언
	public String getLogin_Id() {
		return login_Id;
	}
	public void setLogin_Id(String login_Id) {
		this.login_Id = login_Id;
	}
	public String getLogin_Pw() {
		return login_Pw;
	}
	public void setLogin_Pw(String login_Pw) {
		this.login_Pw = login_Pw;
	}
	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
}
