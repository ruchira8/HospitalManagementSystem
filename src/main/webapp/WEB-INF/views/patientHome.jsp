<%@ include file="header.jsp" %>
<div style="padding-top: 20px; padding-bottom: 10px" align="center">
    <h1> Welcome ${patient.firstName}!</h1>
</div>
<div class="col-md-12">
    <div class="" align="left">
        <a class="btn btn-primary" href="<%=contextPath%>/patients/edit/${patient.id}"
           style="margin-left:50%;">Edit your Details</a>
    </div>
    <div class="" align="left">
        <a class="btn btn-primary" href="<%=contextPath%>/patients/reports/${patient.id}"
           style="margin-left:50%;">View your reports</a>
    </div>
</div>
<%@ include file="footer.jsp" %>
