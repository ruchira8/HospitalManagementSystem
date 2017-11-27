<%@ include file="header.jsp" %>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-12">
            <div class="table-responsive">
                <table id="mytable" class="table table-bordered" style="margin:10px;width:60%;">
                    <thead>
                    <th>#</th>
                    <th>Occupied By</th>
                    <th>Status</th>
                    <th></th>
                    </thead>
                    <tbody>
                    <c:forEach var="room" items="${rooms}">
                        <tr>
                            <td>${room.id }</td>
                            <td>${room.patientId }</td>
                            <td>${room.status }</td>
                            <td>
                                <a class="btn btn-primary"
                                   href="<%=contextPath%>/admin/rooms/edit/${room.id}">Edit</a>
                                <a class="btn btn-warning"
                                   href="<%=contextPath%>/admin/rooms/delete/${room.id}">Delete</a>
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
