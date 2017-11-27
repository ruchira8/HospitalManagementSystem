<%@ include file="header.jsp" %>
<div class="row" align="center">
    <form action="<%=request.getContextPath()%>/staff/inventory/search" method="post"
          role="form">
        <div class="form-group input-group col-md-4">
            <input type="text" class="form-control" id="searchTerm" name="searchTerm" placeholder="Search Items">
            <span class="input-group-btn">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <button class="btn btn-default" type="submit">
                <span class="glyphicon glyphicon-search"></span>
            </button>
            </span>
        </div>
    </form>
</div>
<div class="row" align="center">
    <div class="col-md-2">
        <div>
            <a class="btn btn-primary" href="<%=request.getContextPath()%>/staff/inventory/list"
               style="margin-left:50%;">View Items</a>
        </div>
    </div>
    <div class="col-md-2">
        <div>
            <a class="btn btn-primary" href="<%=request.getContextPath()%>/staff/inventory/add"
               style="margin-left:50%;">Add Item</a>
        </div>
    </div>
    <div class="col-md-2">
        <div>
            <a class="btn btn-primary" href="<%=request.getContextPath()%>/staff/inventory/orderList"
               style="margin-left:50%;">View Items to order</a>
        </div>
    </div>
</div>
<%@ include file="footer.jsp" %>