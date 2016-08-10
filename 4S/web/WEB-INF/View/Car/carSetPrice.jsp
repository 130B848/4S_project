<%--
  Created by IntelliJ IDEA.
  User: HFQ
  Date: 2016/8/7
  Time: 17:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>车辆设置成本与指导售价</title>
</head>

<body>
<jsp:include page="../Site/header.jsp"/>
<jsp:include page="../Site/seperator.jsp"/>


<form:form cssClass="mywrapper form-horizontal" id="formCarStockRegister" method="post" commandName="car" action="${pageContext.request.contextPath}/Car/setCost/${car.carID}">

  <div class="form-group">
    <label class="col-sm-2 control-label">车架号: ${car.carID}</label>
  </div>

  <div class="form-group">
    <label class="col-sm-2 control-label">品牌: ${car.brand}</label>
  </div>

  <div class="form-group">
    <label class="col-sm-2 control-label">SFX: ${car.sfx}</label>
  </div>

  <div class="form-group">
    <label class="col-sm-2 control-label">颜色: ${car.color}</label>
  </div>

  <div class="form-group">
    <label class="col-sm-2 control-label">库存状态: ${car.status}</label>
  </div>

  <div class="form-group">
    <label class="col-sm-2 control-label">车辆状态: ${car.normal}</label>
  </div>

  <div class="form-group">
    <label class="col-sm-2 control-label">成本 :</label>
    <div class="col-sm-7">
      <form:input cssClass="form-control" ID="Cost" path="Cost"/>
    </div>
  </div>

  <div class="form-group">
    <label class="col-sm-2 control-label">售价 :</label>
    <div class="col-sm-7">
      <form:input cssClass="form-control" ID="Price" path="Price"/>
    </div>
  </div>

  <div class="form-group">
    <div class="col-sm-2"></div>
    <div class="col-sm-7">
      <button type="submit" class="btn btn-primary">登记</button>
    </div>
  </div>
</form:form>
<jsp:include page="../Site/footer.jsp"/>
</body>
</html>