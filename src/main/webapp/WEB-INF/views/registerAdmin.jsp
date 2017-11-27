<%@ include file="header.jsp" %>
<div class="col-md-6">
    <div class="panel panel-primary">
        <div class="panel-heading">New Admin</div>
        <div class="panel-body">
            <form action="<%=request.getContextPath()%>/admin/register" method="post" role="form">
                <div class="form-group">
                    <label for="firstName">First Name:</label>
                    <input type="text" class="form-control" id="firstName" name="firstName" required>
                </div>
                <div class="form-group">
                    <label for="lastName">Last Name:</label>
                    <input type="text" class="form-control" id="lastName" name="lastName" required>
                </div>
                <div class="form-group">
                    <label for="age">Age:</label>
                    <input type="number" class="form-control" id="age" name="age" required>
                </div>
                <div class="form-group">
                    <label for="gender">Gender:</label>
                    <input type="text" class="form-control" id="gender" name="gender" required>
                </div>
                <div class="form-group">
                    <label for="phone">Phone:</label>
                    <input type="text" class="form-control" id="phone" name="phone" required>
                </div>
                <div class="form-group">
                    <label for="address">Address:</label>
                    <input type="phone" class="form-control" id="address" name="address" required>
                </div>
                <div class="form-group">
                    <label for="emailId">Email:</label>
                    <input type="email" class="form-control" id="emailId" name="emailId" required>
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
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <button type="submit" class="btn btn-default">Register</button>
            </form>
        </div>
    </div>
</div>
<%@ include file="footer.jsp" %>
