<%@ include file="header.jsp" %>
<div style="padding-top: 20px; padding-bottom: 10px" align="center">
    <h1> Welcome ${staff.firstName}!</h1>
</div>
<div class="row" align="center">
    <div class="col-md-2">
        <div>
            <a class="btn btn-primary" href="<%=request.getContextPath()%>/patients/list"
               style="margin-left:50%;">View All Patients</a>
        </div>
    </div>
    <div class="col-md-2">
        <div>
            <a class="btn btn-primary" href="<%=request.getContextPath()%>/patients/add"
               style="margin-left:50%;">Add Patient</a>
        </div>
    </div>
    <div class="col-md-2">
        <div>
            <a class="btn btn-primary" href="<%=request.getContextPath()%>/staff/inventory/list"
               style="margin-left:50%;">View Rooms</a>
        </div>
    </div>
    <div class="col-md-2">
        <div>
            <a class="btn btn-primary" href="<%=request.getContextPath()%>/staff/inventory/add"
               style="margin-left:50%;">Add Room</a>
        </div>
    </div>
    <div class="col-md-2">
        <div>
            <a class="btn btn-primary" href="<%=request.getContextPath()%>/staff/edit/${staff.id}"
               style="margin-left:50%;">Edit your Details</a>
        </div>
    </div>
    <c:if test="${staff.designation == 'InventoryManager'}">
        <div class="col-md-2">
            <div>
                <a class="btn btn-primary" href="<%=request.getContextPath()%>/staff/inventory/"
                   style="margin-left:50%;">Manage Inventory</a>
            </div>
        </div>
    </c:if>
</div>
<%@ include file="footer.jsp" %>