<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  
    pageEncoding="ISO-8859-1"%>  
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">  
<title>Login Application</title>  
<script type="text/javascript">
	var queryString = window.location.search;
	var urlParams = new URLSearchParams(queryString);
	var errorValue = urlParams.get('error');
	
	if (errorValue === "1") {
	  // Xử lý khi error = 1
		document.getElementById("message").innerHTML = "Username, password fails!";
	} else {
	  // Xử lý khi error khác 1 hoặc không có error parameter
	  console.log("Error value is not 1");
	}
	function validateForm() {
		var username = document.getElementById("username").value;
		
		var password = document.getElementById("password").value;
		console.log(document.getElementById("password"))
		if(username.trim() === "") {
			console.log("abc")
			document.getElementById("message").innerHTML = "Please enter your Username.";
			document.getElementById("message").innerHTML = "Please enter your Username.";
			return false;
		}
		if(password.trim() === "") {
			document.getElementById("message").innerHTML = "Please enter your Password.";
			return false;
		}
		return true
	};
	function resetMessage() {
		document.getElementById("message").innerHTML = "Message";
	};
	function errorMessage() {
		document.getElementById("message").innerHTML = "Username, password fails!";
	}
</script> 
</head>  
<body>  
	<div style="text-align: center;">
	<h1 style="color: red">Login</h1>
	<h1 id="message" style="color: red">Message</h1>
	</div>
    <form style="display: flex; justify-content: center; align-items: center;" action="T001" method="post" onsubmit="return validateForm();">  
            
            <table>  
                <tr>    
                    <td>User ID</td>  
                    <td><input id="username" type="text" name="username" /></td>  
                
                </tr>  
                
                <tr>  
                    <td>Password</td>  
                    <td><input id="password" type="password" name="userpass" /></td>  
                
                </tr>
                  
                <tr> 	
                   
                    <td style="text-align: center;">
                    <input type="submit" value="Login" 
                    style=" color: black;
            		border-radius: 4px;
             		
             		margin-top: 10;
             		margin-bottom: 12;" />
                 
                    </td>  
                    <td style="text-align: center;">
                    <input onClick="resetMessage();"  type="reset" value="Clear" 
                    style=" color: black;
            		border-radius: 4px;
             		
             		margin-top: 10;
             		margin-bottom: 12;" />
                    </td>
                	
                </tr>
                <tr>
                <td><a href="#">Forgot password?</a></td>
                </tr>  
                
            </table>  
    </form>
    <div style="position: fixed; left: 0; bottom: 0; right: 0;">
    	<hr/>
    	<h4>CopyRight c abc</h4>
    </div>  
</body>  
<script type="text/javascript">
	var queryString = window.location.search;
	var urlParams = new URLSearchParams(queryString);
	var errorValue = urlParams.get('error');
	
	if (errorValue === "1") {
	  // Xử lý khi error = 1
		document.getElementById("message").innerHTML = "Username, password fails!";
	} else {
	  // Xử lý khi error khác 1 hoặc không có error parameter
	  console.log("Error value is not 1");
	}
</script> 
</html> 