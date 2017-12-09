<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
  <title>HOME PAGE</title>
  
  
  <link rel='stylesheet prefetch' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css'>

      <link rel="stylesheet" href="/Sogong/css/style_main.css">
</head>

<body>
<div id="main-background-image"></div>
<div id="address-bar"></div>
<div id="menu-bar"></div>
<div id="under-choose-us-back"></div>
<div id="promise-background"></div>
<div id="white"></div>
<div id="footer-back"></div>
<div id="footer-back2"></div>

<div id="main-wrap">
  
    <div id="threediv-back"></div>
  
  <a href="#"><i class="fa fa-facebook-square"></i></a>
  <a href="#"><i class="fa fa-twitter-square"></i></a>
  <div id="phone-sec">
   <i class="fa fa-phone"></i>
    <i class="fa fa-home"></i>
    <i class="fa fa-clock-o"></i>
    <div id="large-p">(051) 999 5467</div>
    <div id="large-p2">부산광역시  사상구 </div>
    <div id="large-p3">영업시간</div>
    
    
    <div id="small-p">admin@sillahospital.com</div>
    <div id="small-p2">백양대로  700번길   140</div>
    <div id="small-p3">월-금 AM 9.00 - PM 06.00</div>
   
    

    
    <div id="main-background-text">
      <div id="main-b-t-1">신라대학병원</div>  
    </div>
    
    
    
    
  </div>  
  <!--<a href="#"><i class="fa fa-youtube-square"></i></a>-->
  
  <%
  	if (session.getAttribute("clientid") == null)
  	{%>
  		<div id="adress-bar-text">모든 서비스를 이용하시려면 로그인해 주시기 바랍니다. <a href="/Sogong/SignIn.jsp">로그인</a></div>	
  	<%}
  	else
  	{%>
  		<div id="adress-bar-text">${sessionScope.clientName} 회원님 반갑습니다! <a href="/Sogong/op/signOut">로그아웃</a></div>
  	<%}
  	
  %>
  
  <div id="menu-bar2"></div>
  <div id="logo"><img src="/Sogong/images/logo.jpg"/></div>
  <div id="nav-one">
    <ul>
      <li><a href="#">홈페이지</a></li>
      <li><a href="#">병원소개</a></li>
      <li><a href="#">갤러리</a></li>
      <li><a href="/Sogong/op/Reservation">예약</a></li>
      <li><a href="#">고객지원</a></li>
    </ul>
  </div>
  
  <div id="main-background-box-1">
  
    <div class="m-b-b1">대표전화</div>
    <div class="m-b-b2">원무과&nbsp&nbsp&nbsp&nbsp&nbsp051-999-5497<br>
   						간호사실 &nbsp051-999-4426<br>
   						전산실&nbsp&nbsp&nbsp&nbsp&nbsp051-999-26721
   	</div>
  </div>
  
  <div id="main-background-box-2">
  
  <div class="m-b-b1">의료진 소개</div>
    <div class="m-b-b2">클릭하시면 당 병원의<br>의료진 소개를 볼 수 있습니다.</div>
  
  </div>
  
  <div id="main-background-box-3">
  <div class="m-b-b1">학술연구활동</div>
    <div class="m-b-b2">제1회 당뇨발센터 심포지엄<br>응급의학과 이재훈 교수 _대한내과학회 우수논문상 수상</div>
    
  </div>
  
  
  <div id="why-choose-box">
    
    <div id="why-choose-lt">
      <p><span class="underline"><span>공지사항</p>
    </div>
   <div class="fa fa-check"></div>
      <div class="why-choose-pt">경비/주차관리 용역 입찰공고</div>
      <div class="why-choose-pt2">1. 입찰에 부치는 사항  <br> 2. 입찰방법 : 협상에 의한 제한경쟁입찰(긴급)<br><div align="right">more...</div></div>
      
 
   <div class="fa fa-check"></div>
      <div class="why-choose-pt">KNN 건강강좌 _정형외과 왕립 교수</div>
      <div class="why-choose-pt2">첨부 사진 확인<div align="right">more...</div></div>
            
            
   <div class="fa fa-check"></div>
      <div class="why-choose-pt">제증명료 항목 및 금액에 관한 기준 제정 안내</div>
      <div class="why-choose-pt2"> 보건복지부 고시 제2017-166호에 의거, 의료기관의 제증명수수료 항목 및 금액이 정해짐에 따라 본원의 제증명료 변경 내용을 안내해 드립니다.* 적용일자: 2017.9.21.<div align="right">more...</div></div>
  
  </div>
    
    <div id="why-choose-box2">
    
    <div id="why-choose-lt">
      <p><span class="underline">언론보도</p>
    </div>
   <div class="fa fa-check"></div>
      <div class="why-choose-pt">제목</div>
      <div class="why-choose-pt2">본문
</br></br>
본문2</div>





<a href=""><div id="about-us-button">

  <p>더 보기</p>
  
  </div></a>



</div> 



<div id="testimonial-header">

  <p>이번달의 모범직원 칭찬글</p>
</div>

<div id="testimonial-box-1">

  <i class="fa fa-quote-left"></i>
  
  <div class="quote-txt">내용<br>　<br>　<br><br>　</div>
  
  <div id="test-box"><p>김민석</p></div>
  <div id="test-box2"><p>정형외과</p>
  </div>
</div>

<div id="testimonial-box-2">

  <i class="fa fa-quote-left"></i>
  
  <div class="quote-txt">내용<br>　<br>　<br><br>　</div>
  
  <div id="test-box"><p>조성민</p>
  </div>
  
    <div id="test-box2"><p>내과</p>
  </div>
  
  

  
</div>

<div id="triangle-topleft1"></div>
<div id="triangle-topleft2"></div>



<!-- <div id="promise-1">총장 인사말</div>

<div id="promise-2">"At CMT Panels we promise to always offer our dedicated knowledge to all of our customers in an

honest and reliable manner with integrity to always deliver on time. Our aim is to bring your project vision to reality."</div>

<div id="promise-sig"><img src="https://s8.postimg.org/57zxbvzud/maria_logo.png"/></div>
 -->
<div id="australia-pxl">
  
  <img src="https://images.discordapp.net/eyJ1cmwiOiJodHRwczovL2Rpc2NvcmQuc3RvcmFnZS5nb29nbGVhcGlzLmNvbS9hdHRhY2htZW50cy8yNTgxMjg1MzE0NjcyNzIxOTQvMjgzNTc5MDU2OTAwMDE0MDgwL0FVU19DSVJDTEVTX0JBUkFOLnBuZyJ9.srWDh0vHJJV5FlUMugqZfOwRC7A?width=625&height=441"/> 
</div>

<div id="australia-txt1">신라대학병원 해외의료활동 </div>
<div id="australia-txt2">&nbsp&nbsp신라대학병원 학생들과 의료진들은 주기적인 해외 의료봉사 활동을 하고 있습니다.<br>&nbsp&nbsp의료봉사활동을 함께하실 소중한 자원봉사자분들을<br>모집하고 있습니다.</div>

<a href=""><div id="contact-us-button2"><p>참여하기</p></div></a>








</div><!-- end main wrap -->
  <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

    <script  src="js/index.js"></script>

</body>
</html>
