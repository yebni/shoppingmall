<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form role="form" action="/shop/productcontroll" method="post" autocomplete="off"> 

<div class="inputArea">   
<label>분류</label>  
<select class="category" name="category">   
<option value="1">핸드폰</option>  
<option value="2">노트북</option>  
</select> 
</div> 

<div class="inputArea">  
<label for="gdsName">상품명</label>  
<input type="text" id="gdsName" name="pname" /> 

</div> 
<div class="inputArea">  
<label for="gdsPrice">상품가격</label>  
<input type="number" id="gdsPrice" name="price" /> 
</div> 

<div class="inputArea">  
<label for="gdsStock">상품수량</label>  
<input type="number" id="gdsStock" name="stack" /> 
</div> 

<div class="inputArea">  
<label for="gdsNum">상품고유번호</label>  
<input type="number" id="gdsNum" name="pnum" /> 
</div> 

<div class="inputArea">  
<label for="gdsPw">상품관리비밀번호 : 9로 통일</label>  
<input type="number" id="gdsPw" name="password" /> 
</div> 

<div class="inputArea">  
<button type="submit" id="register_Btn" class="btn btn-primary">등록</button> 
</div> 

<%-- <div class="inputArea">  
<label for="gdsImg">이미지</label>  
<input type="file" id="gdsImg" name="file" />  
<div class="select_img"><img src="" /></div>   
<script>   
$("#gdsImg").change(function(){    
	if(this.files && this.files[0]) {     
		var reader = new FileReader;     
		reader.onload = function(data) {      
			$(".select_img img").attr("src", data.target.result).width(500);        
			} reader.readAsDataURL(this.files[0]);  
			}  
	});  
</script> 
<%=request.getRealPath("/") %>
</div> --%>
	


</form>
</body>
</html>