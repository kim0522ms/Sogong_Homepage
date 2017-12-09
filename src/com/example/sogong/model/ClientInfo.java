/**
 * File Name 	: ClientInfo.Java
 * Version 		: 0.1
 * Writer		: KMS
 * Project Name	: Sogong
 * Funtion		: JSP - Servlet�� �ְ� �޴� Client(��)�� ������ ��� ���� Attribute Model Class
 * 				  EL-Expression���μ� ����ϱ� ���� �� ��� ������ getter�� setter �Լ��� ������.
 * 				  EL-Expression�� ����ϱ� ���� ������ ����ϴ� ��Ģ�� �����ϱ� ������ private�������� ������ Underscore(_)�� ���Խ�Ű�� �ʴ´�.
 */

package com.example.sogong.model;

public class ClientInfo {
	// Client(ȸ��)�� ������ ��� ���� ��� ���� ����
	private int clientId;
	private String clientName;
	private String phoneNumber;
	private String address;
	private String ssn;
	private String login_Id;
	private String login_Pw;
	
	// �ܺο��� Read/Write�� �� �� �ֵ��� Getter / Setter �Լ��� ����
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
