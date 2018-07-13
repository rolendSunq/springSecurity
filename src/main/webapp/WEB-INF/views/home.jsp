<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param name="pageTitle" value="Home"/>
</jsp:include>
        <h1>Welcome to JBCP Petstore!</h1>
        <span>${serverTime}</span>
        <p>We have many great breeds of pet available for your perusal.</p>
        <ul>
        	<li><a href="listPets?species=dog">Dogs</a></li>
        	<li><a href="listPets?species=cat">Cats</a></li>
        </ul>
<jsp:include page="/WEB-INF/views/common/footer.jsp"/>
