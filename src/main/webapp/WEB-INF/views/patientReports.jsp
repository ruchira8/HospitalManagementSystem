<%@ include file="header.jsp" %>
<div class="container-fluid">
    <div class="row" align="center">
        <div class="col-md-2">
            <div>
                <a class="btn btn-primary" href="<%=request.getContextPath()%>/admin/patient/reports/add/${pId}"
                   style="margin-left:50%;">Add Report</a>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-12">
            <div class="table-responsive">
                <table id="mytable" class="table table-bordered" style="margin:10px;width:60%;">
                    <thead>
                    <th>Date</th>
                    <th>Diagnosis</th>
                    <th>Prescription</th>
                    <th></th>
                    </thead>
                    <tbody>
                    <c:forEach var="report" items="${reports}">
                        <tr>
                            <td>${report.patientDate.date}</td>
                            <td>${report.diagnosis }</td>
                            <td>${report.prescription }</td>
                            <td>
                                <a class="btn btn-primary"
                                   href="<%=contextPath%>/admin/patient/reports/edit/${report.patientDate.id}/${report.patientDate.date}">Edit</a>
                                <a class="btn btn-warning"
                                   href="<%=contextPath%>/admin/patient/reports/delete/${report.patientDate.id}/${report.patientDate.date}">Delete</a>
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
