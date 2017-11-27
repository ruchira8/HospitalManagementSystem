<%@ include file="header.jsp" %>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-12">
            <div class="table-responsive">
                <table id="mytable" class="table table-bordered" style="margin:10px;width:60%;">
                    <thead>
                    <th>Date</th>
                    <th>Diagnosis</th>
                    <th>Prescription</th>
                    </thead>
                    <tbody>
                    <c:forEach var="report" items="${reports}">
                        <tr>
                            <td>${report.patientDate.date}</td>
                            <td>${report.diagnosis }</td>
                            <td>${report.prescription }</td>
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
