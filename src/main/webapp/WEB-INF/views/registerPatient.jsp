<%@ include file="header.jsp" %>
<div class="col-md-6">
    <div class="panel panel-primary">
        <div class="panel-heading">Patient Registration</div>
        <div class="panel-body">
            <form action="<%=request.getContextPath()%>/patients/register" method="post" role="form">
                <div class="form-group">
                    <label for="id">PatientNumber:</label>
                    <input type="text" class="form-control" id="id" name="id" required>
                </div>
                <div class="form-group">
                    <label for="userName">Preferred Username:</label>
                    <input type="text" class="form-control" id="userName" name="userName">
                </div>
                <div class="form-group">
                    <label for="password">Password:</label>
                    <input type="password" class="form-control" id="password" name="password">
                </div>
                <div class="form-group">
                    <label for="passwordConfirm">Re-Type Password:</label>
                    <input type="password" class="form-control" id="passwordConfirm" name="passwordConfirm">
                </div>
                <button type="submit" class="btn btn-default">Register</button>
            </form>
        </div>
    </div>
</div>
<%@ include file="footer.jsp" %>
