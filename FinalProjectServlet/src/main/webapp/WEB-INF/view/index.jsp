<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<fmt:setLocale value="${cookie['lang'].value}"/>
<fmt:setBundle basename="messages"/>
<html>
<head>
    <title>Tax Office</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/WEB-INF/css/landing.css" type="text/css" media="all">
</head>
<body>
<%@ include file="/WEB-INF/fragments/header.jspf" %>
<div class="container center">
    <div class="row">
        <div style="padding-top: 50px; width: 100%; text-align: center">
            <h1>
                <fmt:message key="site.name" />
            </h1>
        </div>
        <div style="padding-top: 100px; width: 100%; text-align: center">
            <a id="custom-btn" class="btn btn-primary" href="${pageContext.request.contextPath}/login" role="button" style="margin-left: auto;
    margin-right: auto; background-color: #0d6efd; width: 200px; height: 50px">
                <fmt:message key="login" />
            </a>
        </div>
        <div style="padding-top: 50px; width: 100%; text-align: center">
            <a id="custom-btn2" class="btn btn-primary" href="${pageContext.request.contextPath}/registration" role="button" style="margin-left: auto;
    margin-right: auto; background-color: #0d6efd; width: 200px; height: 50px">
                <fmt:message key="register" />
            </a>
        </div>
    </div>
</div>
</body>
</html>