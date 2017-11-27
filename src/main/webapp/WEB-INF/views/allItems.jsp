<%@ include file="header.jsp" %>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-12">
            <div class="table-responsive">
                <table id="mytable" class="table table-bordered" style="margin:10px;width:60%;">
                    <thead>
                    <th>#</th>
                    <th>Name</th>
                    <th>Type</th>
                    <th>Available</th>
                    <th></th>
                    </thead>
                    <tbody>
                    <c:forEach var="item" items="${items}">
                        <tr>
                            <td>${item.id }</td>
                            <td>${item.name }</td>
                            <td>${item.type }</td>
                            <td>${item.available }</td>
                            <td>
                                <a class="btn btn-primary"
                                   href="<%=contextPath%>/staff/inventory/edit/${item.id}">Edit</a>
                                <a class="btn btn-warning"
                                   href="<%=contextPath%>/staff/inventory/delete/${item.id}">Delete</a>
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
