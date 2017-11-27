<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<c:set var="appPath" value="${pageContext.request.contextPath}"/>
<%
    String contextPath = request.getContextPath();
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link href='<%=contextPath+"/css/common.css" %>' rel="stylesheet">
    <link rel="shortcut icon" href='<%=contextPath+"/images/logo.PNG" %>'/>
</head>
<body>
<div class="navbar navbar-inverse navbar-fixed-left">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav">
                <li>
                    <c:if test="${pageContext.request.userPrincipal.name != null}">
                        <a href="<%=contextPath%>/homepage">Home</a>
                    </c:if>
                    <c:if test="${pageContext.request.userPrincipal.name == null}">
                        <a href="<%=contextPath%>/">Home</a>
                    </c:if>
                </li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <form id="logout" action="<%=contextPath%>/logout" method="post">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                </form>
                <c:if test="${pageContext.request.userPrincipal.name != null}">
                    <li><a href="javascript:document.getElementById('logout').submit()"><span
                            class="glyphicon glyphicon-log-in"></span> Logout</a></li>
                </c:if>
                <c:if test="${pageContext.request.userPrincipal.name == null}">
                    <li><a href="<%=contextPath%>/register"><span class="glyphicon glyphicon-user"></span> New User -
                        Register Here</a></li>
                    <li><a href="<%=contextPath%>/login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
                </c:if>
            </ul>
        </div>
    </div>
</div>
