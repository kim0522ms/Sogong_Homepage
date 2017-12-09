/**
 * File Name 	: SogongDbBao.Java
 * Version 		: 0.1
 * Writer		: KMS
 * Project Name	: Sogong
 * Funtion		: DataBase와 연결하여 수행되는 모든 기능들을 멤버 함수로 구현해 놓은 Class.
 * 			  	    상수로 연결되어야 하는 DB 정보를 가지고 있으며 connect(), disconnect() 함수를 통하여 DataBase 접속을 관리한다.
 * 				    각 Function들은 내부적으로 connect(), disconnect() 함수를 반드시 호출하여야 한다. 
 */

package com.example.sogong.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import com.example.sogong.model.ClientInfo;
import com.example.sogong.model.ReservationInfo;

public class SogongDbDao {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private final String DB_URL = "jdbc:oracle:thin://@localhost:1521/xe";
	private final String DB_USER = "beauty";
	private final String DB_PW = "BEAST";
	
	public void connect() throws ClassNotFoundException, SQLException{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PW);
	}
	
	public void disconnect() throws SQLException{
		if (pstmt != null){
			pstmt.close();
			pstmt = null;
		}
		
		if (conn != null){
			conn.close();
			conn = null;
		}
	}
	
	public int getLastClientID()
	{
		int id = 0;
		
		try {
			connect();
			
			String sql = "select max(clientID) as clientid from client";
			
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next())
			{
				id = rs.getInt("clientid") + 1;
			}
			else
			{
				id = 1;
			}
			
			disconnect();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return id;
	}
	
	public int addReservation(ReservationInfo res, int clientId) throws ClassNotFoundException, SQLException
	{
		int result = 0;
		
		connect();

		SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat ( "yyyyMMdd HH:mm:ss", Locale.KOREA );
		Date currentTime = new Date ();

		String mTime = mSimpleDateFormat.format (currentTime);
		
		String sql = "insert into reservation values(?, ?, ?, ?, ?, ?, ?)";
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, mTime);
		pstmt.setString(2, res.getPart());
		pstmt.setString(3, res.getDoctorName());
		pstmt.setInt(4, clientId);
		pstmt.setString(5, res.getResDate());
		pstmt.setString(6, res.getResTime());
		pstmt.setString(7, res.getAddComments());
		
		result = pstmt.executeUpdate();
		
		return result;
	}
	
	public boolean signUp(ClientInfo client) throws ClassNotFoundException, SQLException
	{
		connect();
		
		String sql = "insert into client values (?, ?, ?, ?, ?, ?, ?)";
		
		
		System.out.println("----Inputted text----");
		System.out.println(client.getClientId());
		System.out.println(client.getClientName());
		System.out.println(client.getPhoneNumber());
		System.out.println(client.getAddress());
		System.out.println(client.getSsn());
		System.out.println(client.getLogin_Id());
		System.out.println(client.getLogin_Pw());
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, client.getClientId());
		pstmt.setString(2, client.getClientName());
		pstmt.setString(3, client.getPhoneNumber());
		pstmt.setString(4, client.getAddress());
		pstmt.setString(5, client.getSsn());
		pstmt.setString(6, client.getLogin_Id());
		pstmt.setString(7, client.getLogin_Pw());
		
		int rs = pstmt.executeUpdate();
		
		disconnect();
		
		if (rs > 0)
			return true;
		else
			return false;
	}
	
	public String getName(int clinetid)
	{
		String name = "";
		try {
			connect();
			String sql = "select clientname from client where clientid = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, clinetid);
			
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next())
			{
				return rs.getString("clientname");
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return name;
	}
	
	public int signIn(ClientInfo client) throws ClassNotFoundException, SQLException
	{
		int clientId = 0;
		connect();
		
		String sql = "SELECT * FROM CLIENT WHERE login_id = ? AND login_pw = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, client.getLogin_Id());
		pstmt.setString(2, client.getLogin_Pw());
		
		ResultSet rs = pstmt.executeQuery();
		
		if (rs.next()){
			System.out.println("Login Success!");
			clientId = rs.getInt("clientid");
		}
		else
		{
			System.out.println("Login Failed!!");
			clientId = 0;
		}
		
		disconnect();
		
		return clientId;
	}
}