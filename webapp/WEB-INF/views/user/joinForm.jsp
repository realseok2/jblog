<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JBlog</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/assets/js/jquery/jquery-1.12.4.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/jblog.css">

</head>
<body>
	<div id="center-content">
		
		<!-- 메인 해더 -->
		<c:import url="/WEB-INF/views/includes/main-header.jsp"></c:import>

		<div>		
			<form id="joinForm" method="post" action="${pageContext.request.contextPath}/user/join">
				<table>
			      	<colgroup>
						<col style="width: 100px;">
						<col style="width: 170px;">
						<col style="">
					</colgroup>
		      		<tr>
		      			<td><label for="txtId">아이디</label></td>
		      			<td><input id="txtId" type="text" name="id" placeholder="아이디를 입력하세요."></td>
		      			<td><button id="btnIdCheck" type="button">아이디체크</button></td>
		      		</tr>
		      		<tr>
		      			<td></td>
		      			<td id="tdMsg" colspan="2"></td>
		      		</tr> 
		      		<tr>
		      			<td><label for="txtPassword">패스워드</label> </td>
		      			<td><input id="txtPassword" type="password" name="password"  value="" placeholder="비밀번호를 입력하세요."></td>   
		      			<td></td>  			
		      		</tr>
		      		<tr>
		      			<td><label for="txtUserName">이름</label> </td>
		      			<td><input id="txtUserName" type="text" name="userName"  value="" placeholder="이름을 입력하세요."></td>   
		      			<td></td>  			
		      		</tr>  
		      		<tr>
		      			<td><span>약관동의</span> </td>
		      			<td colspan="3">
		      				<input id="chkAgree" type="checkbox" name="agree" value="y">
		      				<label for="chkAgree">서비스 약관에 동의합니다.</label>
		      			</td>   
		      		</tr>   		
		      	</table>
	      		<div id="btnArea">
					<button id="btnJoin" class="btn" type="submit" >회원가입</button>
				</div>
	      		
			</form>
			
		</div>
		
		
		<!-- 메인 푸터  자리-->
		<c:import url="/WEB-INF/views/includes/main-footer.jsp"></c:import>
	</div>

</body>





<script type="text/javascript">

//아이디 중복체크
$("#btnIdCheck").on("click", function(){
	console.log("아이디중복체크 버튼클릭");
	
	var txtId = $("#txtId").val();		//id창에 입력된 id값을 추출합니다.
	console.log(txtId);					//id창에 입력된 id를 콘솔창에 출력하여 제대로 작동하는지 확인합니다.
	
	var userInfo = {
			txtId	:	txtId
	}
	
	$.ajax({
		
		url : "${pageContext.request.contextPath }/user/idcheck",
		type : "post",					//	항상 post방식을 사용하세요.
		//contentType : "application/json",
		data : userInfo,
		
		//데이터 받을 때 사용하는 옵션
		dataType : "json",
		success : function(result){
			console.log(result);
			
			/*성공시 처리해야될 코드 작성*/
			if(result == true) {
				$("#tdMsg").html("사용할 수 있는 아이디입니다.", "color", "red");
			} else {
				$("#tdMsg").html("다른 아이디로 가입해 주세요.", "color", "red");
			}

		},
		error : function(XHR, status, error) {
			console.error(status + " : " + error);
		}
		
	});
	
	
	
	
	
	
	
	
	
	
	
	
	
	
});
























</script>



</html>