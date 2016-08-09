<%--
  Created by IntelliJ IDEA.
  User: HFQ
  Date: 2016/8/8
  Time: 7:59
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>添加新品牌</title>
</head>

<jsp:include page="../Site/header.jsp"/>
<jsp:include page="../Site/seperator.jsp"/>


<body>
<form:form cssClass="mywrapper form-horizontal" id="formAddGarage" method="post" commandName="garage" action="${pageContext.request.contextPath}/Car/createGarage">

  <div class="form-group">
    <label class="col-sm-2 control-label">品牌：</label>
    <div class="col-sm-7">
      <form:input cssClass="form-control" ID="Brand" path="Brand"/>
    </div>
  </div>

  <div class="form-group">
    <div class="col-sm-2"></div>
    <div class="col-sm-7">
      <button type="submit" class="btn btn-primary">提交</button>
    </div>
  </div>
</form:form>
  To be implemented 检查重复
<jsp:include page="../Site/footer.jsp"/>

</body>
</html>
