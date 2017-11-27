<%@ include file="header.jsp" %>
<div class="col-md-6">
    <div class="panel panel-primary">
        <div class="panel-heading">Edit Room</div>
        <div class="panel-body">
            <form action="<%=request.getContextPath()%>/admin/rooms/update/${room.id}" method="post" role="form">
                <div class="form-group">
                    <label for="patientId">Occupied By patient:</label>
                    <input type="text" class="form-control" id="patientId" name="patientId"
                           value="${room.patientId }">
                </div>
                <div class="form-group">
                    <label for="status">Status:</label>
                    <input type="text" class="form-control" id="status" name="status"
                           value="${room.status }" required>
                </div>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <button type="submit" class="btn btn-default">Save</button>
            </form>
        </div>
    </div>
</div>
<%@ include file="footer.jsp" %>
