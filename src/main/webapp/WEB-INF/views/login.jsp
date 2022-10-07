<!DOCTYPE web-app PUBLIC "-//Sun Microsystems, Inc.//DTD Web Application 2.3//EN" "http://java.sun.com/dtd/web-app_2_3.dtd" >
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%
    request.setAttribute("contextName",request.getContextPath());
%>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="resources/css/login.css">
    <title>Coffe Shop</title>
  </head>
  <body>
    <div class="dashboard">

    <div class="container-sm">
    <div id="welcoming" class="mx-5 position-absolute top-50 start-0 translate-middle-y">
        <h1>Welcome!</h1>
        <p>Coffee Shop</p>
        <a href="#" >Let's have take a look!</a>
    </div>

    <div id="login-form" class="px-5 position-absolute top-50 end-0 translate-middle-y" >  
    <c:if test="${param.error != null}">
<div class="alert alert-danger">Failed to login.
	<c:if test="${SPRING_SECURITY_LAST_EXCEPTION != null}">
Reason: <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}" />
	</c:if>
		</div>
</c:if>
   
   <c:url value="/loginPage" var="loginUrl"/>
        <form action="${loginUrl}" method="post" id="logon">
        <h4>Enter your account to get more benefit!</h4>
        <div class="mb-3">
          <label  for="exampleInputEmail1" class="form-label">Username</label>
          <input id="userid" name="userid" type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
        </div>
        <div class="mb-3">
          <label for="exampleInputPassword1" class="form-label">Password</label>
          <input name="password" id="password" type="password" class="form-control" id="exampleInputPassword1">
        </div>
   
        <button type="submit" class="btn btn-primary">Submit</button>
      </form>
</div>
</div>
</div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
  
</body>
</html>