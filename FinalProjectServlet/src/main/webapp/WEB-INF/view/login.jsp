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
<!--     Latest compiled and minified CSS-->
<!--    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"-->
<!--          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">-->
<!--     Optional theme-->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
          integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/WEB-INF/css/login.css">
</head>
<body>
<%@ include file="/WEB-INF/fragments/header.jspf" %>
<div id="login">
    <div class="container" style="width: 30%;">
        <div id="login-row" class="row justify-content-center align-items-center">
            <div id="login-column" class="col-md-12">
                <c:if test="${requestScope.logout}">
                    <div class="alert alert-info" role="alert">You've been logged out successfully.</div>
                </c:if>
                <c:if test="${requestScope.get('error_empty')}">
                    <div class="alert alert-danger" role="alert">Some fields are empty!</div>
                </c:if>
                <c:if test="${requestScope.get('error_password')}">
                    <div class="alert alert-danger" role="alert">Password is not correct!</div>
                </c:if>
                <div id="login-box" class="col-md-12">
                    <form id="login-form" class="form" method="post">
                        <a class="text-info" href="${pageContext.request.contextPath}/" style="text-decoration: none"><fmt:message key="login.back" /></a>
                        <h3 class="text-center text-info"><fmt:message key="login.title" /></h3>
                        <div class="form-group">
                            <label for="email" class="text-info"><fmt:message key="login.email" /></label><br>
                            <input type="text" name="email" id="email" class="form-control">
                        </div>
                        <div class="form-group">
                            <label for="password" class="text-info" style="padding-top: 20px"><fmt:message key="login.password" /></label><br>
                            <input type="password" name="password" id="password" class="form-control">
                        </div>
                        <div class="form-group" style="padding-top: 20px">
<!--                            <label for="remember-me" class="text-info"><span>Remember me</span> <span><input id="remember-me" name="remember-me" type="checkbox"></span></label><br>-->
                            <input type="submit" name="submit" class="btn btn-primary btn-md" value="<fmt:message key="login.submit" />">
                        </div>
<!--                        <div id="register-link" class="text-right">-->
<!--                            <a href="#" class="text-info">Register here</a>-->
<!--                        </div>-->
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</html>