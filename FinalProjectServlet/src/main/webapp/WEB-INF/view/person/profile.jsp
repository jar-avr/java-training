<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<fmt:setLocale value="${cookie['lang'].value}"/>
<fmt:setBundle basename="messages"/>
<html lang="en" xmlns:th="http://www.thymeleaf.org"
      xmlns:sec = "http://www.thymeleaf.org/extras/spring-security">
<head>
    <title>Tax Office</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/WEB-INF/css/landing.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/WEB-INF/css/profile.css">
</head>
<body>

<%@ include file="/WEB-INF/fragments/header.jspf" %>
<c:if test="${requestScope.get('sideMenu')}">
    <div id="sidebar-wrapper">
        <ul class="sidebar-nav">
            <li>
                <a href="/submit-report">Submit a report</a>
            </li>
        </ul>
    </div>
</c:if>
<div class="container center">
    <div class="col-md-6 col-md-offset-3">
        <div style="width: 100%; text-align: center">
            <h1><fmt:message key="greeting" /></h1>
            <h1><c:out value="${requestScope.get('firstName')}"/></h1>
            <br>
            <h1><fmt:message key="authentication.label" /></h1>
            <h1>User</h1>
            <br>
            <h1>Your email:</h1>
            <h1><c:out value="${requestScope.get('email')}"/></h1>
            <br>
            <h1>Your EDRPOU code:</h1>
            <c:choose>
                <c:when test="${requestScope.get('sideMenu')}">
                    <h1><c:out value="${requestScope.get('eCode')}"/></h1>
                </c:when>
                <c:otherwise>
                    <h1>'You have not been assigned an EDRPOU code by an inspector yet'</h1>
                </c:otherwise>
            </c:choose>
            <br>
        </div>
    </div>
</div>
</body>
</html>