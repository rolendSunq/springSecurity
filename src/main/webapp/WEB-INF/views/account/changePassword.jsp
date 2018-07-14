<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param name="pageTitle" value="Change Password"/>
</jsp:include>
            <h1>Change Password</h1>
            <form method="post">
            	<%-- Ch 4 UserDetailsManager --%>
            	<label for="oldpassword">Old Password</label>:
            	<input id="oldpassword" name="oldpassword" maxlength="50" type="password"/>
            	<br>
            	<label for="password">New Password</label>:
            	<input id="password" name="password" maxlength="50" type="password"/>
            	<br>
            	<input type="submit" value="Change Password"/>
            </form>
<jsp:include page="/WEB-INF/views/common/footer.jsp"/>