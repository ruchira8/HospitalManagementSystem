<%@ include file="header.jsp" %>
<%@ include file="adminNavBar.jsp" %>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-12">
            <div class="table-responsive">
                <table id="mytable" class="table table-bordered" style="margin:10px;width:60%;">
                    <thead>
                    <th>#</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Age</th>
                    <th>Gender</th>
                    <th>Phone</th>
                    <th>Address</th>
                    <th>Email</th>
                    <th>Designation</th>
                    <th></th>
                    </thead>
                    <tbody>
                    <c:forEach var="admin" items="${admins}">
                        <tr>
                            <td>${admin.id }</td>
                            <td>${admin.firstName }</td>
                            <td>${admin.lastName }</td>
                            <td>${admin.age }</td>
                            <td>${admin.gender }</td>
                            <td>${admin.phone }</td>
                            <td>${admin.address }</td>
                            <td>${admin.emailId }</td>
                            <td>${admin.designation }</td>
                            <td>
                                <a class="btn btn-primary"
                                   href="<%=contextPath%>/admin/edit/${admin.id}">Edit</a>
                                <a class="btn btn-warning"
                                   href="<%=contextPath%>/admin/delete/${admin.id}">Delete</a>
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
