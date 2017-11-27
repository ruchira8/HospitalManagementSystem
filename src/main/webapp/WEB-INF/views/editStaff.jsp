<%@ include file="header.jsp" %>
<div class="col-md-6">
    <div class="panel panel-primary">
        <div class="panel-heading">Edit Details</div>
        <div class="panel-body">
            <form action="<%=request.getContextPath()%>/staff/update" method="post" role="form">
                <div class="form-group">
                    <label for="designation">Designation:</label>
                    <input type="text" class="form-control" id="designation" name="designation"
                           value="${staff.designation }" required>
                </div>
                <div class="form-group">
                    <label for="firstName">First Name:</label>
                    <input type="text" class="form-control" id="firstName" name="firstName" value="${staff.firstName }"
                           required>
                </div>
                <div class="form-group">
                    <label for="lastName">Last Name:</label>
                    <input type="text" class="form-control" id="lastName" name="lastName" value="${staff.lastName }"
                           required>
                </div>
                <div class="form-group">
                    <label for="age">Age:</label>
                    <input type="number" class="form-control" id="age" name="age" value="${staff.age }" required>
                </div>
                <div class="form-group">
                    <label for="gender">Gender:</label>
                    <input type="text" class="form-control" id="gender" name="gender" value="${staff.gender }" required>
                </div>
                <div class="form-group">
                    <label for="phone">Phone:</label>
                    <input type="text" class="form-control" id="phone" name="phone" value="${staff.phone }" required>
                </div>
                <div class="form-group">
                    <label for="address">Address:</label>
                    <input type="phone" class="form-control" id="address" name="address" value="${staff.address }"
                           required>
                </div>
                <div class="form-group">
                    <label for="emailId">Email:</label>
                    <input type="email" class="form-control" id="emailId" name="emailId" value="${staff.emailId }"
                           required>
                </div>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <button type="submit" class="btn btn-default">Save</button>
            </form>
        </div>
    </div>
</div>
<%@ include file="footer.jsp" %>

