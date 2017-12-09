<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Sign Up</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">  
      <link rel="stylesheet" href="/Sogong/css/style.css">
      <script>
      function goPopup(){
    		var pop = window.open("jusoPopup.jsp","pop","width=570,height=420, scrollbars=yes, resizable=yes"); 
    	}      
      
	   function jusoCallBack(roadFullAddr, roadAddrPart1, addrDetail){
	  		document.getElementById("address").value = roadFullAddr;
	  		document.getElementById("roadAddrPart1").value = roadAddrPart1;
	  		document.getElementById("addrDetail").value = addrDetail;
	  		
	  }
      </script>
</head>

<body>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Sign Up Form</title>
        <link rel="stylesheet" href="css/normalize.css">
        <link href='https://fonts.googleapis.com/css?family=Nunito:400,300' rel='stylesheet' type='text/css'>
        <link rel="stylesheet" href="css/main.css">
    </head>
    <body>
      <form action="/Sogong/op/signup" method="post">
      
        <h2>회원 가입</h2>
        
        <fieldset>
          <legend><span class="number">1</span>&nbsp기본 정보</legend>
          <label for="name">이름</label>
          <input type="text" id="clientName" name="clientName">
          
          <label for="mail">ID</label>
          <input type="text" id="login_id" name="login_id">
          
          <label for="password">패스워드</label>
          <input type="password" id="login_pw" name="login_pw">
          
          <label for="ssn">주민번호</label>
          <input type="text" id="ssn" style="width:180px;" name="ssn_forward" maxlength="6" onKeypress="if(event.keyCode < 45 || event.keyCode > 57) event.returnValue = false;" style="IME-MODE:disabled;">
          <input type="password" id="ssn" name="ssn_backword" style="width:180px;" maxlength="7" onKeypress="if(event.keyCode < 45 || event.keyCode > 57) event.returnValue = false;" style="IME-MODE:disabled;">
          
          
          <!-- <label>Age:</label>
          <input type="radio" id="under_13" value="under_13" name="user_age"><label for="under_13" class="light">Under 13</label><br>
          <input type="radio" id="over_13" value="over_13" name="user_age"><label for="over_13" class="light">13 or older</label> -->
        </fieldset>
        
        <fieldset>
          <legend><span class="number">2</span>상세 정보</legend>
          <label for="bio">주소</label>
          
          <input type="hidden" id="address" name="address">
          <input type="text" id="roadAddrPart1"  name="roadAddrPart1" placeholder="기본 주소" />
          <input type="text" id="addrDetail"  name="addrDetail" placeholder="상세 주소" />
          <input type="button" name="findAddr" value="주소 찾기" onClick="goPopup();">
          <p>
          <!-- <textarea id="roadFullAddr" name="roadFullAddr"></textarea> -->
          
          
        </fieldset>
        <fieldset>
          <label for="bio">전화번호</label>
          <input type="text" id="phonenumber"  name="phonenumber"/>

          <input type="checkbox" id="development" value="interest_development" name="user_interest"><label class="light" for="development">회원 약관에 동의합니다.</label><br>
        
        </fieldset>
        <button type="submit">Sign Up</button>
      </form>
      
    </body>
</html>
  
  
</body>
</html>
