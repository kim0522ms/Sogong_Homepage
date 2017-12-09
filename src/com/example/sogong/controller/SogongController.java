/**
 * This Source code is uplode in Github
 * File Name 	: SogongController.Java
 * Version 		: 0.1
 * Writer		: KMS
 * Project Name	: Sogong
 * Funtion		: web.xml에 미리 Mapping된 URL에 의해 JSP에서 넘어온 Request를 처리하는 Controller Servlet.
 * 				  URL 뒤쪽의 SubPath에 따라 각각 기능을 분류.
 * 				  SubPath별 해당 작업이 완료되면 결과값으로 얻은 viewName Page로 Forwarding한다.
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
		// Client로부터 받은 Request는 op/<Subpath>형태로 Mapping되어있으므로
		// op 뒤의 문자열을 획득하여 요청을 분류한다.
		String subPath = request.getPathInfo();
		String viewName = null;
		
		request.setCharacterEncoding("UTF-8");
		
		// 예약 페이지로 이동. Session에 로그인 정보가 존재하지 않을 경우 로그인 페이지로 연결된다.
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
		
		// 예약 등록. Reservation.jsp에서 얻은 Parameter들을 바탕으로 DB에 저장한다.
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
		
		
		// 로그아웃 기능. Session에 저장되어있는 로그인 정보를 null로 바꾼 후 메인 페이지로 이동한다.
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
		
		// 각 기능을 실행한 후 획득한 viewName 주소로 Forwarding
		if(viewName != null) {
			RequestDispatcher view = request.getRequestDispatcher(viewName);
			view.forward(request,response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Client로부터 받은 Request는 op/<Subpath>형태로 Mapping되어있으므로
		// op 뒤의 문자열을 획득하여 요청을 분류한다.
		String subPath = request.getPathInfo();
		String viewName = null;
		
		request.setCharacterEncoding("UTF-8");
		
		// 회원가입. SignUp.jsp에서 입력한 Parameter들을 바탕으로 DB에 해당 회원 정보를 등록한다.
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
		
		// 로그인. SignIn.jsp에서 입력된 Parameter들을 바탕으로 해당 유저가 존재하는지 조회하여 로그인한다.
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
		
		// 각 기능을 실행한 후 획득한 viewName 주소로 Forwarding
		if(viewName != null) {
			RequestDispatcher view = request.getRequestDispatcher(viewName);
			view.forward(request,response);
		}
		
	}

}
