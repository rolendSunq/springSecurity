<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="myContextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="<c:out value="${myContextPath}"/>/resources/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="<c:out value="${myContextPath}"/>/resources/fontawesome/css/all.css">
        <script src="<c:out value="${myContextPath}"/>/resources/bootstrap/js/bootstrap.min.js"></script>
        <style>
            body{
                font-family: 'Ropa Sans', sans-serif;
                margin-top: 30px;
                background-color: #F0CA00;
                background-color: #F3661C;
                text-align: center;
                color: #fff;
            }
            .error-heading{
                margin: 50px auto;
                width: 250px;
                border: 5px solid #fff;
                font-size: 126px;
                line-height: 126px;
                border-radius: 30px;
                text-shadow: 6px 6px 5px #000;
            }
            .error-heading img{
                width: 100%;
            }
            .error-main h1{
                font-size: 72px;
                margin: 0px;
                color: #F3661C;
                text-shadow: 0px 0px 5px #fff;
            }
        </style>
        <title>403 ERROR!</title>
    </head>
    <body>
    	<div class="error-main">
    		<h1>Oops!</h1>
    		<div class="error-heading">403</div>
    		<p>You do not have permission to access the document or program that you requested.</p>
    	</div>
    </body>
</html>