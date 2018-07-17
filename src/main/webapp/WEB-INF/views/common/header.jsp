<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="myContextPath" value="${pageContext.request.contextPath}"/>
<c:url value="/resources/styles/style.css" var="cssUrl"/>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" type="text/css" href="${cssUrl}">
        <link rel="stylesheet" href="<c:out value="${myContextPath}"/>/resources/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="<c:out value="${myContextPath}"/>/resources/fontawesome/css/all.css">
        <script src="<c:out value="${myContextPath}"/>/resources/jquery/jquery-3.3.1.js"></script>
        <script src="<c:out value="${myContextPath}"/>/resources/bootstrap/js/bootstrap.min.js"></script>
        <title>JBCP Pets: ${pageTitle}</title>
    </head>
    <body>
        <div class="container-fluid">
            <div id="header">
                <ul>
                	<c:url value="/home" var="homeUrl"/>
                	<li><a href="${homeUrl}">Home</a></li>
                	<c:url value="/logout" var="logoutUrl"/>
                	<li><a href="${logoutUrl}">Log Out</a></li>
                	<c:url value="/account/home" var="accountUrl"/>
                	<li><a href="${accountUrl}">My Account</a></li>
                	<c:url value="/wishlist/home" var="wishlistUrl"/>
                	<li><a href="${wishlistUrl}">My Wishlist</a></li>
                </ul>
                <br>
            </div>

