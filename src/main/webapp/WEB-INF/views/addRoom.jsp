<%@ include file="header.jsp" %>
<div class="col-md-6">
    <div class="panel panel-primary">
        <div class="panel-heading">Add Room</div>
        <div class="panel-body">
            <form action="<%=request.getContextPath()%>/admin/rooms/addNew" method="post" role="form">
                <div class="form-group">
                    <label for="roomNo">Room No:</label>
                    <input type="text" class="form-control" id="roomNo" name="roomNo" required>
                </div>
                <div class="form-group">
                    <label for="patientId">Occupied By patient:</label>
                    <input type="text" class="form-control" id="patientId" name="patientId">
                </div>
                <div class="form-group">
                    <label for="status">Status:</label>
                    <input type="text" class="form-control" id="status" name="status" required>
                </div>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <button type="submit" class="btn btn-default">Add</button>
            </form>
        </div>
    </div>
</div>
<%@ include file="footer.jsp" %>
