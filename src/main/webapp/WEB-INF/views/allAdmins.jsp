<%@ include file="header.jsp" %>
<div class="container-fluid">
    <div class="row" align="center" style="padding-top: 10px">
        <form action="<%=request.getContextPath()%>/admin/search" method="post"
              role="form">
            <div class="form-group input-group col-md-4">
                <input type="text" class="form-control" id="searchTerm" name="searchTerm" placeholder="Search Admins">
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
                    <th>#</th>
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
