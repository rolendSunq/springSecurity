<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param name="pageTitle" value="Login"/>
</jsp:include>
            <h1>Please Log Into Your Account</h1>
            <p>Please use the form below to log into your account.</p>
            <span>Login</span>
            <form action="j_spring_security_check" method="post">
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
            	       <label for="username" class="input-group-text">username</label>
                    </div>
            	   <input id="username" name="username" maxlength="60" type="text" class="form-control"/>
                </div>
            <%-- For experimentation with an alternate checkbox name
            	<input id="_remember_me" name="_remember_me" type="checkbox" value="true"/>
            	<label for="_remember_me">Remember Me?</label>
            	<br>
            --%>
            	<input id="_spring_security_remember_me" name="_spring_security_remember_me" type="checkbox" value="true"/>
            	<label for="_spring_security_remember_me">Remember Me?</label>
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
            	       <label for="password" class="input-group-text">Password</label>
                    </div>
            	   <input id="password" name="password" maxlength="60" type="password" class="form-control"/>
                </div>
            	<input type="submit" value="Login"/>
            </form>
<jsp:include page="/WEB-INF/views/common/footer.jsp"/>