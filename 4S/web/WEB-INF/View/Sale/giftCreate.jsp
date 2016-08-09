<%--
  Created by IntelliJ IDEA.
  User: googo
  Date: 16/8/9
  Time: 下午4:41
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>

<jsp:include page="../Site/header.jsp"/>
<jsp:include page="../Site/seperator.jsp"/>

<script>
    //  $(function(){
    //    $("#formAddCustomer").validate({
    //      rules:{
    //        Username:{
    //          required:true,
    //          minlength:5,
    //          maxlength:32
    //        },
    //        Password:{
    //          required:true,
    //          maxlength:32
    //        },
    //        PasswordValidate:{
    //          required:true,
    //          maxlength:32,
    //          equalTo:"#Password"
    //        }
    //      },
    //      messages:{
    //        Password:{
    //          required:"Please enter password"
    //        },
    //        PasswordValidate:{
    //          required:"Please enter password",
    //          equalTo:"Two Passwords don't match"
    //        }
    //      }
    //    });
    //  });
</script>

<body>
<form:form cssClass="mywrapper form-horizontal" id="formAddGift" method="post" commandName="gift" action="${pageContext.request.contextPath}/Sale/createGift">


    <div class="form-group">
        <label class="col-sm-2 control-label">精品名称 :</label>
        <div class="col-sm-7">
            <form:input cssClass="form-control" ID="Name" path="Name"/>
        </div>
    </div>

    <div class="form-group">
        <label class="col-sm-2 control-label">精品类别 :</label>
        <div class="col-sm-7">
            <form:input cssClass="form-control" ID="Type" path="Type"/>
        </div>
    </div>

    <div class="form-group">
        <label class="col-sm-2 control-label">精品成本 :</label>
        <div class="col-sm-7">
            <form:input cssClass="form-control" ID="Cost" path="Cost"/>
        </div>
    </div>

    <div class="form-group">
        <label class="col-sm-2 control-label">精品售价 :</label>
        <div class="col-sm-7">
            <form:input cssClass="form-control" ID="default_price" path="default_price"/>
        </div>
    </div>

    <div class="form-group">
        <div class="col-sm-2"></div>
        <div class="col-sm-7">
            <button type="submit" class="btn btn-primary">提交</button>
        </div>
    </div>
</form:form>

<jsp:include page="../Site/footer.jsp"/>

</body>
</html>
