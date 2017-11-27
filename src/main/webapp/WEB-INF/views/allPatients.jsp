<%@ include file="header.jsp" %>
<div class="container-fluid">
    <div class="row" align="center" style="padding-top: 10px">
        <form action="<%=request.getContextPath()%>/patients/search" method="post"
              role="form">
            <div class="form-group input-group col-md-4">
                <input type="text" class="form-control" id="searchTerm" name="searchTerm" placeholder="Search Patients">
                <span class="input-group-btn">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <button class="btn btn-default" type="submit">
                <span class="glyphicon glyphicon-search"></span>
            </button>
            </span>
            </div>
        </form>
    </div>
    <div class="row">
        <div class="col-md-12">
            <div class="table-responsive">
                <table id="mytable" class="table table-bordered" style="margin:10px;width:60%;">
                    <thead>
                    <th>Patient#</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Age</th>
                    <th>Gender</th>
                    <th>Phone</th>
                    <th>Address</th>
                    <th>Email</th>
                    <th></th>
                    </thead>
                    <tbody>
                    <c:forEach var="patient" items="${patients}">
                        <tr>
                            <td>${patient.id }</td>
                            <td>${patient.firstName }</td>
                            <td>${patient.lastName }</td>
                            <td>${patient.age }</td>
                            <td>${patient.gender }</td>
                            <td>${patient.phone }</td>
                            <td>${patient.address }</td>
                            <td>${patient.emailId }</td>
                            <td>
                                <a class="btn btn-primary"
                                   href="<%=contextPath%>/patients/edit/${patient.id}">Edit</a>
                                <a class="btn btn-warning"
                                   href="<%=contextPath%>/patients/delete/${patient.id}">Delete</a>
                                <a class="btn btn-warning"
                                   href="<%=contextPath%>/admin/patient/reports/${patient.id}">View Reports</a>
                                <a class="btn btn-warning"
                                   href="<%=contextPath%>/admin/patient/reports/add/${patient.id}">Add Report</a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <div class="clearfix"></div>
            </div>
        </div>
    </div>
</div>
<%@ include file="footer.jsp" %>
