<%--
  Created by IntelliJ IDEA.
  User: HFQ
  Date: 2016/8/13
  Time: 12:44
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>添加订单</title>
</head>

<jsp:include page="../Site/header.jsp"/>
<jsp:include page="../Site/seperator.jsp"/>


<body>
<form class="mywrapper form-horizontal" id="formAddGarage" method="post" action="${pageContext.request.contextPath}/Order/addCarToOrder">

  <div class="form-group">
    <label class="col-sm-2 control-label">车架号：</label>
    <div class="col-sm-7">
      <label class="control-label">${car.carID}</label>
      <%--<form:input cssClass="form-control" ID="Brand" path="Brand"/>--%>
    </div>
  </div>

  <div class="form-group">
    <label class="col-sm-2 control-label">厂家：</label>
    <div class="col-sm-7">
      <label class="control-label">${car.garage}</label>
      <%--<form:input cssClass="form-control" ID="Brand" path="Brand"/>--%>
    </div>
  </div>
  <div class="form-group">
    <label class="col-sm-2 control-label">型号：</label>
    <div class="col-sm-7">
      <label class="control-label">${car.brand}</label>
      <%--<form:input cssClass="form-control" ID="Brand" path="Brand"/>--%>
    </div>
  </div>
  <div class="form-group">
    <label class="col-sm-2 control-label">SFX：</label>
    <div class="col-sm-7">
      <label class="control-label">${car.sfx}</label>
      <%--<form:input cssClass="form-control" ID="Brand" path="Brand"/>--%>
    </div>
  </div>
  <div class="form-group">
    <label class="col-sm-2 control-label">颜色：</label>
    <div class="col-sm-7">
      <label class="control-label">${car.color}</label>
      <%--<form:input cssClass="form-control" ID="Brand" path="Brand"/>--%>
    </div>
  </div>

  <div class="form-group">
    <div class="col-sm-2"></div>
    <div class="col-sm-7">
      <button type="submit" class="btn btn-primary">提交</button>
    </div>
  </div>
</form>
To be implemented 检查重复
<jsp:include page="../Site/footer.jsp"/>

</body>
</html>
