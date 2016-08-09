<%--
  Created by IntelliJ IDEA.
  User: HFQ
  Date: 2016/4/8
  Time: 10:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Home</title>
  <link href="/web_resources/css/index.css" rel="stylesheet">
</head>
<body>

<jsp:include page="header.jsp"/>
<div class="section umblue splash" style="height: 504px;">
  <div class="container">
    <div class="splash-text  parrallaxized">
      <h2 id="slidertext" class="text-white title build-it-text" style="text-align:center;">
        A book is like a garden, <br> carried in the pocket.
      </h2>
      <a href="${pageContext.request.contextPath}/Book/list" class="text-white btn btn-lg btn-large btn-primary">Get Books Now</a>
    </div>
    <!-- <img src="" height="200" alt="Umbreo cover" > -->
  </div>
</div>
<div class="section white">
  <div class="container">
    <div class="p-t-40 p-b-40">
      <h2 class="text-center">Welcome to <span class="semi-bold">Ticholas's Bookstore</span>, to <span class="semi-bold">explore</span> for knowledge!</h2>
      <!-- <a href="/signup" class="btn btn-primary btn-lg btn-large m-r-10">SIGN UP</a> -->
    </div>
  </div>
</div>

<div class="section grey" data-animate-down="ha-header-carColor" data-animate-up="ha-header-hide">
  <div class="container">
    <div class="p-t-60">
      <div class="row">
        <div class="col-md-12 feature-list ">
          <div class="col-md-4 fadeIn animated" data-ride="animated" data-animation="fadeIn" data-delay="200">
            <h4 class="title">Cultural Treasure</h4>
            <p>
              Books are treasure banks storing wisdom passed down from generation to generation.
            </p>
          </div>
          <div class="col-md-4 fadeIn animated" data-ride="animated" data-animation="fadeIn" data-delay="400">
            <h4 class="title">Inner Depth</h4>
            <p>
              Reading make a full man, conference a ready man, and writing an exact man.
            </p>
          </div>
          <div class="col-md-4 fadeIn animated" data-ride="animated" data-animation="fadeIn" data-delay="600">
            <h4 class="title">Spirit Powers</h4>
            <p>
              The more you read,the more healthy and brave your spirit will be.
            </p>
          </div>
        </div>
      </div>
      <br>
      <div class="row">
        <div class="col-md-12 feature-list">
          <div class="col-md-4 fadeIn animated" data-ride="animated" data-animation="fadeIn" data-delay="800">
            <h4 class="title">Insights</h4>
            <p>
              How many a man has dated a new era in his life from the reading of a book!
            </p>
          </div>
          <div class="col-md-4 fadeIn animated" data-ride="animated" data-animation="fadeIn" data-delay="1000">
            <h4 class="title">Reflection</h4>
            <p>
              A book is a mirror ,if an ass peers into it,you cant expect an apostle to look out.
            </p>
          </div>
          <div class="m-b-60 col-md-4 fadeIn animated" data-ride="animated" data-animation="fadeIn" data-delay="1200">
            <h4 class="title">Visions</h4>
            <p>
              A house without books is like a room without windows.
            </p>
          </div>
          <div class="clearfix"></div>
        </div>
      </div>

      <div class="clearfix"></div>
    </div>
  </div>
</div>

<jsp:include page="footer.jsp"/>



</body>
</html>
