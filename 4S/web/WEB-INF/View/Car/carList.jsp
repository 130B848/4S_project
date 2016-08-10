<%--
  Created by IntelliJ IDEA.
  User: HFQ
  Date: 2016/8/7
  Time: 17:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>车辆列表</title>
</head>
<body>
<jsp:include page="../Site/header.jsp"/>
<jsp:include page="../Site/seperator.jsp"/>
<div class="mywrapper form-group">
  <div class="col-sm-2"></div>
  <div class="col-sm-8">
    <table class="table table-bordered table-responsive">
      <thead>
      <tr>
        <th>车架号</th>
        <th>厂家</th>
        <th>品牌</th>
        <th>SFX</th>
        <th>颜色</th>
        <th>入库时间</th>
        <th>库存状态</th>
        <th>成本</th>
        <th>指导价</th>
        <th>折扣</th>
        <th colspan=3>操作</th>
      </tr>
      </thead>
      <tbody>
      <c:forEach items="${cars}" var="car">
        <tr>
          <td>${car.carID}</td>
          <td>${car.garage.brand}</td>
          <td>${car.carBrand.brand}</td>
          <td>${car.sfx}</td>
          <td>${car.color}</td>
          <td>${car.purchasedTime}</td>
          <td>${car.status}</td>
          <td>${car.cost}</td>
          <td>${car.price}</td>
          <td>${car.discount}</td>
          <td><button type="button" class="btn btn-primary" onclick="window.location='#'">购买</button></td>
          <td><button type="button" class="btn btn-primary" onclick="window.location='${pageContext.request.contextPath}/Car/setCost/${car.carID}'">设置成本</button></td>
          <td><button type="button" class="btn btn-primary" onclick="window.location='#'">更改库存状态</button></td>
        </tr>
      </c:forEach>
      </tbody>
    </table>
  </div>
</div>
<jsp:include page="../Site/footer.jsp"/>
</body>
</html>
