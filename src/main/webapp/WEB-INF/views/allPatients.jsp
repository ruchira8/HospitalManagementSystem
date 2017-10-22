<%@ include file="header.jsp" %>
<%@ include file="adminNavBar.jsp" %>
<div class="container-fluid">
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
