<%--
  Created by IntelliJ IDEA.
  User: HFQ
  Date: 2016/8/8
  Time: 19:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
  <title>添加新颜色</title>
</head>

<jsp:include page="../Site/header.jsp"/>
<jsp:include page="../Site/seperator.jsp"/>


<body>
<form:form cssClass="mywrapper form-horizontal" id="formAddColor" method="post" commandName="color" action="${pageContext.request.contextPath}/Car/createColor">

  <div class="form-group">
    <label class="col-sm-2 control-label">颜色：</label>
    <div class="col-sm-7">
      <form:input cssClass="form-control" ID="Color" path="Color"/>
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