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
    <div id="large-p2">�λ걤����  ��� </div>
    <div id="large-p3">�����ð�</div>
    
    
    <div id="small-p">admin@sillahospital.com</div>
    <div id="small-p2">�����  700����   140</div>
    <div id="small-p3">��-�� AM 9.00 - PM 06.00</div>
   
    

    
    <div id="main-background-text">
      <div id="main-b-t-1">�Ŷ���к���</div>  
    </div>
    
    
    
    
  </div>  
  <!--<a href="#"><i class="fa fa-youtube-square"></i></a>-->
  
  <%
  	if (session.getAttribute("clientid") == null)
  	{%>
  		<div id="adress-bar-text">��� ���񽺸� �̿��Ͻ÷��� �α����� �ֽñ� �ٶ��ϴ�. <a href="/Sogong/SignIn.jsp">�α���</a></div>	
  	<%}
  	else
  	{%>
  		<div id="adress-bar-text">${sessionScope.clientName} ȸ���� �ݰ����ϴ�! <a href="/Sogong/op/signOut">�α׾ƿ�</a></div>
  	<%}
  	
  %>
  
  <div id="menu-bar2"></div>
  <div id="logo"><img src="/Sogong/images/logo.jpg"/></div>
  <div id="nav-one">
    <ul>
      <li><a href="#">Ȩ������</a></li>
      <li><a href="#">�����Ұ�</a></li>
      <li><a href="#">������</a></li>
      <li><a href="/Sogong/op/Reservation">����</a></li>
      <li><a href="#">������</a></li>
    </ul>
  </div>
  
  <div id="main-background-box-1">
  
    <div class="m-b-b1">��ǥ��ȭ</div>
    <div class="m-b-b2">������&nbsp&nbsp&nbsp&nbsp&nbsp051-999-5497<br>
   						��ȣ��� &nbsp051-999-4426<br>
   						�����&nbsp&nbsp&nbsp&nbsp&nbsp051-999-26721
   	</div>
  </div>
  
  <div id="main-background-box-2">
  
  <div class="m-b-b1">�Ƿ��� �Ұ�</div>
    <div class="m-b-b2">Ŭ���Ͻø� �� ������<br>�Ƿ��� �Ұ��� �� �� �ֽ��ϴ�.</div>
  
  </div>
  
  <div id="main-background-box-3">
  <div class="m-b-b1">�м�����Ȱ��</div>
    <div class="m-b-b2">��1ȸ �索�߼��� ��������<br>�������а� ������ ���� _���ѳ�����ȸ ������� ����</div>
    
  </div>
  
  
  <div id="why-choose-box">
    
    <div id="why-choose-lt">
      <p><span class="underline"><span>��������</p>
    </div>
   <div class="fa fa-check"></div>
      <div class="why-choose-pt">���/�������� �뿪 ��������</div>
      <div class="why-choose-pt2">1. ������ ��ġ�� ����  <br> 2. ������� : ���� ���� ���Ѱ�������(���)<br><div align="right">more...</div></div>
      
 
   <div class="fa fa-check"></div>
      <div class="why-choose-pt">KNN �ǰ����� _�����ܰ� �ո� ����</div>
      <div class="why-choose-pt2">÷�� ���� Ȯ��<div align="right">more...</div></div>
            
            
   <div class="fa fa-check"></div>
      <div class="why-choose-pt">������� �׸� �� �ݾ׿� ���� ���� ���� �ȳ�</div>
      <div class="why-choose-pt2"> ���Ǻ����� ��� ��2017-166ȣ�� �ǰ�, �Ƿ����� ����������� �׸� �� �ݾ��� �������� ���� ������ ������� ���� ������ �ȳ��� �帳�ϴ�.* ��������: 2017.9.21.<div align="right">more...</div></div>
  
  </div>
    
    <div id="why-choose-box2">
    
    <div id="why-choose-lt">
      <p><span class="underline">��к���</p>
    </div>
   <div class="fa fa-check"></div>
      <div class="why-choose-pt">����</div>
      <div class="why-choose-pt2">����
</br></br>
����2</div>





<a href=""><div id="about-us-button">

  <p>�� ����</p>
  
  </div></a>



</div> 



<div id="testimonial-header">

  <p>�̹����� ������� Ī����</p>
</div>

<div id="testimonial-box-1">

  <i class="fa fa-quote-left"></i>
  
  <div class="quote-txt">����<br>��<br>��<br><br>��</div>
  
  <div id="test-box"><p>��μ�</p></div>
  <div id="test-box2"><p>�����ܰ�</p>
  </div>
</div>

<div id="testimonial-box-2">

  <i class="fa fa-quote-left"></i>
  
  <div class="quote-txt">����<br>��<br>��<br><br>��</div>
  
  <div id="test-box"><p>������</p>
  </div>
  
    <div id="test-box2"><p>����</p>
  </div>
  
  

  
</div>

<div id="triangle-topleft1"></div>
<div id="triangle-topleft2"></div>



<!-- <div id="promise-1">���� �λ縻</div>

<div id="promise-2">"At CMT Panels we promise to always offer our dedicated knowledge to all of our customers in an

honest and reliable manner with integrity to always deliver on time. Our aim is to bring your project vision to reality."</div>

<div id="promise-sig"><img src="https://s8.postimg.org/57zxbvzud/maria_logo.png"/></div>
 -->
<div id="australia-pxl">
  
  <img src="https://images.discordapp.net/eyJ1cmwiOiJodHRwczovL2Rpc2NvcmQuc3RvcmFnZS5nb29nbGVhcGlzLmNvbS9hdHRhY2htZW50cy8yNTgxMjg1MzE0NjcyNzIxOTQvMjgzNTc5MDU2OTAwMDE0MDgwL0FVU19DSVJDTEVTX0JBUkFOLnBuZyJ9.srWDh0vHJJV5FlUMugqZfOwRC7A?width=625&height=441"/> 
</div>

<div id="australia-txt1">�Ŷ���к��� �ؿ��Ƿ�Ȱ�� </div>
<div id="australia-txt2">&nbsp&nbsp�Ŷ���к��� �л���� �Ƿ������� �ֱ����� �ؿ� �Ƿ���� Ȱ���� �ϰ� �ֽ��ϴ�.<br>&nbsp&nbsp�Ƿ����Ȱ���� �Բ��Ͻ� ������ �ڿ������ںе���<br>�����ϰ� �ֽ��ϴ�.</div>

<a href=""><div id="contact-us-button2"><p>�����ϱ�</p></div></a>








</div><!-- end main wrap -->
  <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

    <script  src="js/index.js"></script>

</body>
</html>
