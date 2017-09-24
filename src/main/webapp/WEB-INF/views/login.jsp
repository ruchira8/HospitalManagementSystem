<%@ include file="header.jsp" %>
<div class="col-md-6">
    <div class="panel panel-primary">
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
                <button type="submit" class="btn btn-default">Submit</button>
            </form>
        </div>
    </div>
</div>
<%@ include file="footer.jsp" %>
