<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param name="pageTitle" value="Change Password"/>
</jsp:include>
            <h1>Change Password</h1>
            <form method="post">
            	<%-- Ch 4 UserDetailsManager --%>
            	<div class="input-group mb-3">
                    <div class="input-group-prepend">
            			<label for="oldpassword" class="input-group-text">Old Password</label>
            		</div>
           			<input id="oldpassword" name="oldpassword" maxlength="50" type="password" class="form-control"/>
            	</div>
            	<div class="input-group mb-3">
                    <div class="input-group-prepend">
		            	<label for="password" class="input-group-text">New Password</label>
            		</div>
            		<input id="password" name="password" maxlength="50" type="password" class="form-control"/>
            	</div>
            	<button type="submit" value="Change Password" class="btn btn-primary">Change Password <i class="fas fa-exchange-alt"></i></button>
            </form>
<jsp:include page="/WEB-INF/views/common/footer.jsp"/>