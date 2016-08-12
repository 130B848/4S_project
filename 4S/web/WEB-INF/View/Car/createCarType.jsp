<%--
  Created by IntelliJ IDEA.
  User: googo
  Date: 16/8/11
  Time: 下午9:37
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>创建车型</title>
</head>

<jsp:include page="../Site/header.jsp"/>
<jsp:include page="../Site/seperator.jsp"/>

<body>
<form:form cssClass="mywrapper form-horizontal" id="formCreateCarType" method="post" commandName="car" action="${pageContext.request.contextPath}/Car/createCarType">


    <div class="form-group">
        <label class="col-sm-2 control-label">厂家:</label>
        <div class="col-sm-7" id = "garage">
            <select class="form-control" name="garageBrand" id="GarageBrand">
                <%--<option value="posche" onclick="brandSelect">保时捷</option>--%>
                <%--<option value="BMW" onclick="brandSelect">宝马</option>--%>
                <c:forEach items="${garages}" var="garage">
                    <option value="${garage.brand}">${garage.brand}</option>
                </c:forEach>
            </select>
        </div>

    </div>

    <div class="form-group">
        <label class="col-sm-2 control-label">车型品牌:</label>
        <div class="col-sm-7">
            <select class="form-control" name="Brand" id="Brand">
              
                <c:forEach items="${carBrands}" var="carBrand">
                    <option value="${carBrand.brand}">${carBrand.brand}</option>
                </c:forEach>
            </select>
        </div>
    </div>

    <div class="form-group">
        <label class="col-sm-2 control-label">SFX:</label>
        <div class="col-sm-7">
            <select class="form-control" name="sfx" id="sfx">
                <c:forEach items="${sfxes}" var="sfx">
                    <option value="${sfx.sfx}">${sfx.sfx}</option>
                </c:forEach>
            </select>
        </div>
    </div>

    <div class="form-group">
        <label class="col-sm-2 control-label">颜色:</label>
        <div class="col-sm-7">
            <select class="form-control" name="color" id="Color">
                <c:forEach items="${colors}" var="color">
                    <option value="${color.color}">${color.color}</option>
                </c:forEach>
            </select>

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

<script>
    function brandSelect() {

    }
</script>
</body>
</html>