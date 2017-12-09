/**
 * This Source code is uplode in Github
 * File Name 	: SogongController.Java
 * Version 		: 0.1
 * Writer		: KMS
 * Project Name	: Sogong
 * Funtion		: web.xml�� �̸� Mapping�� URL�� ���� JSP���� �Ѿ�� Request�� ó���ϴ� Controller Servlet.
 * 				  URL ������ SubPath�� ���� ���� ����� �з�.
 * 				  SubPath�� �ش� �۾��� �Ϸ�Ǹ� ��������� ���� viewName Page�� Forwarding�Ѵ�.
 */


package com.example.sogong.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.sogong.model.ClientInfo;
import com.example.sogong.model.ReservationInfo;

/**
 * Servlet implementation class SogongController
 */
//@WebServlet("/SogongController")
public class SogongController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SogongController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Client�κ��� ���� Request�� op/<Subpath>���·� Mapping�Ǿ������Ƿ�
		// op ���� ���ڿ��� ȹ���Ͽ� ��û�� �з��Ѵ�.
		String subPath = request.getPathInfo();
		String viewName = null;
		
		request.setCharacterEncoding("UTF-8");
		
		// ���� �������� �̵�. Session�� �α��� ������ �������� ���� ��� �α��� �������� ����ȴ�.
		if (subPath.equals("/Reservation"))
		{
			HttpSession session = request.getSession();
			
			Object clientId = session.getAttribute("clientid");
			if (clientId != null)
			{
				viewName = "/reservation/Reservation.jsp";
			}
			else
			{
				viewName = "/SignIn.jsp";
			}
		}
		
		// ���� ���. Reservation.jsp���� ���� Parameter���� �������� DB�� �����Ѵ�.
		else if (subPath.equals("/res_commit"))
		{
			SogongDbDao db = new SogongDbDao();
			HttpSession session = request.getSession();
			ReservationInfo resInfo = new ReservationInfo();
			
			int result = 0;
			int clientId = Integer.parseInt(session.getAttribute("clientid").toString());
			
			resInfo.setPart(request.getParameter("part"));
			resInfo.setDoctorName(request.getParameter("doctorName"));
			resInfo.setResDate(request.getParameter("resDate"));
			resInfo.setResTime(request.getParameter("resTime"));
			resInfo.setAddComments(request.getParameter("addComments"));
			
			try {
				result = db.addReservation(resInfo, clientId);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if (result > 0)
			{
				viewName = "/MainPage.jsp";
			}
			else
			{
				viewName = "/ErrorPage.jsp";
			}
		}
		
		
		// �α׾ƿ� ���. Session�� ����Ǿ��ִ� �α��� ������ null�� �ٲ� �� ���� �������� �̵��Ѵ�.
		else if (subPath.equals("/signOut"))
		{
			SogongDbDao db = new SogongDbDao();
			HttpSession session = request.getSession();
			
			if (session.getAttribute("clientid") != null)
			{
				session.setAttribute("clientid", null);
				session.setAttribute("clientName", null);
			}
			viewName = "/MainPage.jsp";
		}
		
		// �� ����� ������ �� ȹ���� viewName �ּҷ� Forwarding
		if(viewName != null) {
			RequestDispatcher view = request.getRequestDispatcher(viewName);
			view.forward(request,response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Client�κ��� ���� Request�� op/<Subpath>���·� Mapping�Ǿ������Ƿ�
		// op ���� ���ڿ��� ȹ���Ͽ� ��û�� �з��Ѵ�.
		String subPath = request.getPathInfo();
		String viewName = null;
		
		request.setCharacterEncoding("UTF-8");
		
		// ȸ������. SignUp.jsp���� �Է��� Parameter���� �������� DB�� �ش� ȸ�� ������ ����Ѵ�.
		if (subPath.equals("/signup"))
		{
			ClientInfo client = new ClientInfo();
			SogongDbDao db = new SogongDbDao();
			
			boolean result = false;
			
			String ssn = request.getParameter("ssn_forward") + request.getParameter("ssn_backword");
			String address = request.getParameter("roadAddrPart1") + " " + request.getParameter("addrDetail");
			
			try{
				System.out.println(db.getLastClientID());
				client.setClientId(db.getLastClientID());
				client.setClientName(request.getParameter("clientName"));
				client.setPhoneNumber(request.getParameter("phonenumber"));
				client.setAddress(address);
				client.setSsn(ssn);
				client.setLogin_Id(request.getParameter("login_id"));
				client.setLogin_Pw(request.getParameter("login_pw"));
			}catch(NullPointerException e)
			{
				e.printStackTrace();
			}
			
			try {
				result = db.signUp(client);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			
			if (result)
				viewName = "/SignIn.jsp";
			else
				viewName = "/SignUp_Failure.jsp";
		}
		
		// �α���. SignIn.jsp���� �Էµ� Parameter���� �������� �ش� ������ �����ϴ��� ��ȸ�Ͽ� �α����Ѵ�.
		else if (subPath.equals("/signIn"))
		{
			ClientInfo client = new ClientInfo();
			SogongDbDao db = new SogongDbDao();
			HttpSession session = request.getSession();
			
			int clientid = 0;

			try{
				client.setLogin_Id(request.getParameter("loginid"));
				client.setLogin_Pw(request.getParameter("loginpw"));
			}catch(NullPointerException e)
			{
				e.printStackTrace();
			}
			
			
			try {
				clientid = db.signIn(client);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if (clientid > 0)
			{
				session.setAttribute("clientid", clientid);
				session.setAttribute("clientName", db.getName(clientid));
				viewName = "/MainPage.jsp";
			}
			else
				viewName = "/LoginError.jsp";
		}
		
		// �� ����� ������ �� ȹ���� viewName �ּҷ� Forwarding
		if(viewName != null) {
			RequestDispatcher view = request.getRequestDispatcher(viewName);
			view.forward(request,response);
		}
		
	}

}
