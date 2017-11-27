<%@ include file="header.jsp" %>
<div class="col-md-6">
    <div class="panel panel-primary">
        <c:if test="${not empty error}">
            <div>${error}</div>
        </c:if>
        <c:if test="${not empty message}">
            <div>${message}</div>
        </c:if>
        <div class="panel-heading">Login</div>
        <div class="panel-body">
            <form action="<%=request.getContextPath()%>/login/verify" method="post" role="form">
                <div class="form-group">
                    <label for="userName">Username:</label>
                    <input type="text" class="form-control" id="userName" name="userName">
                </div>
                <div class="form-group">
                    <label for="password">Password:</label>
                    <input type="password" class="form-control" id="password" name="password">
                </div>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <button type="submit" class="btn btn-default">Submit</button>
            </form>
        </div>
    </div>
</div>
<%@ include file="footer.jsp" %>
