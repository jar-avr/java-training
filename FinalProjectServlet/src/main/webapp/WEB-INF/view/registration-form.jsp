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
</head>
<body>

<%@ include file="/WEB-INF/fragments/header.jspf"%>
<div class="container" style="width: 30%;">
    <div class="row">
        <c:choose>
            <c:when test="${requestScope.get('success')}">
                <div style="margin-top: 100px; text-align: center">
                    <div class="alert alert-info">
                        You have been successfully registered, proceed to login
                    </div>
                    <a id="custom-btn" class="btn btn-primary" href="/login" role="button"
                       style="background-color: #0d6efd; width: 200px; height: 50px"><fmt:message key="login" /></a>
                </div>
                <a href="/" style="text-decoration: none; color: white; position: relative; bottom: 260px; z-index: 0" data-th-text="back"></a>
            </c:when>
            <c:otherwise>
                <a href="/" style="text-decoration: none; color: white; position: relative; bottom: 40px; z-index: 0" data-th-text="back"></a>
                <h1>Registration</h1>
                <c:if test="${requestScope.get('duplicateEmail')}">
                    <div class="alert alert-danger" role="alert">A person with such email already exists!</div>
                </c:if>
                <form action="/registration" method="post">
<%--                    <p class="error-message"--%>
<%--                       th:if="${#fields.hasGlobalErrors()}"--%>
<%--                       th:each="error : ${#fields.errors('global')}"--%>
<%--                       th:text="${error}">Validation error</p>--%>

                    <div class="form-group"
<%--                         th:classappend="${#fields.hasErrors('firstName')}? 'has-error':''">--%>
                        <label for="firstName" class="control-label">First name</label>
                        <input id="firstName"
                               name="firstName"
                               class="form-control"
                        />
<%--                        <p class="error-message"--%>
<%--                           th:each="error: ${#fields.errors('firstName')}"--%>
<%--                           th:text="${error}">Validation error</p>--%>
                    </div>
                    <div class="form-group"
<%--                         th:classappend="${#fields.hasErrors('lastName')}? 'has-error':''">--%>
                        <label for="lastName" class="control-label">Last name</label>
                        <input id="lastName"
                               name="lastName"
                               class="form-control"
                        />
<%--                        <p class="error-message"--%>
<%--                           th:each="error : ${#fields.errors('lastName')}"--%>
<%--                           th:text="${error}">Validation error</p>--%>
                    </div>
                    <div class="form-group"
<%--                         th:classappend="${#fields.hasErrors('email')}? 'has-error':''">--%>
                        <label for="email" class="control-label">E-mail</label>
                        <input id="email"
                               name="email"
                               class="form-control"
                        />
<%--                        <p class="error-message"--%>
<%--                           th:each="error : ${#fields.errors('email')}"--%>
<%--                           th:text="${error}">Validation error</p>--%>
                    </div>
                    <div class="form-group"
<%--                         th:classappend="${#fields.hasErrors('city')}? 'has-error':''">--%>
                        <label for="city" class="control-label">City</label>
                        <input id="city"
                               name="city"
                               class="form-control"
                        />
<%--                        <p class="error-message"--%>
<%--                           th:each="error : ${#fields.errors('city')}"--%>
<%--                           th:text="${error}">Validation error</p>--%>
                    </div>
                    <div class="form-group"
<%--                         th:classappend="${#fields.hasErrors('street')}? 'has-error':''">--%>
                        <label for="street" class="control-label">Street</label>
                        <input id="street"
                               name="street"
                               class="form-control"
                        />
<%--                        <p class="error-message"--%>
<%--                           th:each="error : ${#fields.errors('street')}"--%>
<%--                           th:text="${error}">Validation error</p>--%>
                    </div>
                    <div class="form-group"
<%--                         th:classappend="${#fields.hasErrors('password')}? 'has-error':''">--%>
                        <label for="password" class="control-label">Password</label>
                        <input id="password"
                               name="password"
                               class="form-control"
                               type="password"
                        />
<%--                        <p class="error-message"--%>
<%--                           th:each="error : ${#fields.errors('password')}"--%>
<%--                           th:text="${error}">Validation error</p>--%>
                    </div>
                    <div class="form-group"
<%--                         th:classappend="${#fields.hasErrors('matchingPassword')}? 'has-error':''">--%>
                        <label for="matchingPassword" class="control-label">Confirm Password</label>
                        <input id="matchingPassword"
                               name="matchingPassword"
                               class="form-control"
                               type="password"
                        />
<%--                        <p class="error-message"--%>
<%--                           th:each="error : ${#fields.errors('matchingPassword')}"--%>
<%--                           th:text="${error}">Validation error</p>--%>
                    </div>
                    <fieldset class="form-group" id="ToBeRevealed" style="padding-top: 30px">
                        <div class="row">
                            <legend class="col-form-label col-sm-2 pt-0" style="display: inline;">User type:</legend>
                            <div class="col-sm-10" style="padding-left: 30px">
                                <div class="form-check">
                                    <input class="form-check-input" type="radio" name="gridRadios" id="gridRadios3" value="NATURAL">
                                    <label class="form-check-label" for="gridRadios3">
                                        Natural person
                                    </label>
                                </div>
                                <div class="form-check">
                                    <input class="form-check-input" type="radio" name="gridRadios" id="gridRadios4" value="LEGAL">
                                    <label class="form-check-label" for="gridRadios4">
                                        Legal person
                                    </label>
                                </div>
                            </div>
                        </div>
                    </fieldset>
                    <div class="form-group">
                        <button type="submit" class="btn btn-primary">Register</button>
                    </div>
                </form>
            </c:otherwise>
        </c:choose>
    </div>
</div>
</body>
</html>