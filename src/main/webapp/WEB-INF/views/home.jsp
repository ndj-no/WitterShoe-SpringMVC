<%--
  Created by IntelliJ IDEA.
  User: ndj-No
  Date: 6/12/2020
  Time: 10:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="my_var.jsp"/>
<html>
<head>
    <title>Home Page</title>
</head>
<body>
<div class="row">
    <jsp:include page="../decorators/client/sidebar.jsp"/>
    <div class="span9">
        <div class="well np">
            <div id="myCarousel" class="carousel slide homCar">
                <div class="carousel-inner">
                    <div class="item active">
                        <a href="">
                            <img style="width:100%" src="${url_image}/${expensiveProducts[0].thumb}"
                                 alt="bootstrap ecommerce templates">
                            <!-- <div class="carousel-caption">
                                  <h4>Bootstrap shopping cart</h4>
                                  <p><span>Very clean simple to use</span></p>
                            </div> -->
                        </a>
                    </div>
                    <c:forEach var="product" items="${expensiveProducts}" begin="1">
                        <div class="item">
                            <a href="">
                                <img style="width:100%" src="${url_image}/${product.thumb}"
                                     alt="bootstrap ecommerce templates">
                            </a>
                        </div>
                    </c:forEach>
                </div>
                <a class="left carousel-control" href="#myCarousel" data-slide="prev">&lsaquo;</a>
                <a class="right carousel-control" href="#myCarousel" data-slide="next">&rsaquo;</a>
            </div>
        </div>
        <!--
        New Products
        -->
        <div class="well well-small">
            <h3>New products </h3>
            <hr class="soften"/>
            <div class="row-fluid">
                <div id="newProductCar" class="carousel slide">
                    <div class="carousel-inner">
                        <div class="item active">
                            <ul class="thumbnails">
                                <c:forEach var="product" items="${newProducts1}" begin="0" end="3">
                                    <li class="span3">
                                        <div class="thumbnail">
                                            <a class="zoomTool" href="${url_detail_product}/${product.id}"
                                               title="add to cart">
                                                <span class="icon-search"></span> QUICK VIEW
                                            </a>
                                            <a href="${url_detail_product}/${product.id}">
                                                <img src="${url_image}/${product.thumb}" alt="bootstrap-ring">
                                            </a>
                                        </div>
                                    </li>
                                </c:forEach>
                            </ul>
                        </div>
                        <div class="item">
                            <ul class="thumbnails">
                                <c:forEach var="product" items="${newProducts1}" begin="4">
                                    <li class="span3">
                                        <div class="thumbnail">
                                            <a class="zoomTool" href="${url_detail_product}/${product.id}"
                                               title="add to cart">
                                                <span class="icon-search"></span> QUICK VIEW
                                            </a>
                                            <a href="${url_detail_product}/${product.id}">
                                                <img src="${url_image}/${product.thumb}" alt="bootstrap-ring">
                                            </a>
                                        </div>
                                    </li>
                                </c:forEach>
                            </ul>
                        </div>
                    </div>
                    <a class="left carousel-control" href="#newProductCar" data-slide="prev">&lsaquo;</a>
                    <a class="right carousel-control" href="#newProductCar" data-slide="next">&rsaquo;</a>
                </div>
            </div>
            <div class="row-fluid">
                <ul class="thumbnails">
                    <c:forEach var="product" items="${newProducts2}">
                        <li class="span4">
                            <div class="thumbnail">
                                <a href="${url_detail_product}/${product.id}">
                                    <img src="${url_image}/${product.thumb}" alt="">
                                </a>
                                <div class="caption">
                                    <h5 style="height: 50px">${product.name}</h5>
                                    <div class="actionList" style="margin-top: 5px">
                                        <span class="pull-left"> <span class="icon-shopping-cart"></span>
                                            ${ product.quantitySold }
                                        </span>
                                        <span class="pull-right"> <span class="icon-eye-open"></span>
                                            ${ product.viewCount }
                                        </span>
                                    </div>
                                    <br/>
                                    <h4>
                                        <a class="defaultBtn"
                                           href="${url_detail_product}/${product.id}"
                                           title="Click to view">
                                            <span class="icon-zoom-in"></span>
                                        </a>
                                        <a class="shopBtn"
                                           href="${url_detail_product}/${product.id}"
                                           title="add to cart">
                                            <span class="">VIEW</span>
                                        </a>
                                        <span class="pull-right"
                                              style="color: red">${product.lstDetailShoeModels[0].newPrice} ₫</span>
                                    </h4>
                                </div>
                            </div>
                        </li>
                    </c:forEach>
                </ul>
            </div>
        </div>
        <!--
            Featured Products
        -->
        <div class="well well-small">
            <h3><a class="btn btn-mini pull-right" href="products.html" title="View more">View More<span
                    class="icon-plus"></span></a> Featured Products </h3>
            <hr class="soften"/>
            <div class="row-fluid">
                <ul class="thumbnails">
                    <c:forEach items="${bestSoldProducts}" var="product">
                        <li class="span4">
                            <div class="thumbnail">
                                <a href="${url_detail_product}/${product.id}"><img
                                        src="${url_image}/${product.thumb}"
                                        alt=""></a>
                                <div class="caption">
                                    <h5 style="height: 50px">${product.name}</h5>
                                    <div class="actionList" style="margin-top: 5px">
                                                <span class="pull-left"><span
                                                        class="icon-shopping-cart"></span> ${ product.quantitySold }</span>
                                        <span class="pull-right"><span
                                                class="icon-eye-open"></span> ${ product.viewCount }</span>
                                    </div>
                                    <br/>
                                    <h4>
                                        <a class="defaultBtn"
                                           href="${url_detail_product}/${product.id}"
                                           title="Click to view"><span class="icon-zoom-in"></span></a>
                                        <a class="shopBtn"
                                           href="${url_detail_product}/${product.id}"
                                           title="add to cart"><span class="">VIEW</span></a>
                                        <span class="pull-right"
                                              style="color: red">${product.lstDetailShoeModels[0].newPrice} ₫</span>
                                    </h4>
                                </div>
                            </div>
                        </li>
                    </c:forEach>
                </ul>
            </div>
        </div>

        <div class="well well-small">
            <a class="btn btn-mini pull-right" href="#">View more <span class="icon-plus"></span></a>
            Popular Products
        </div>
        <hr>
        <div class="well well-small">
            <a class="btn btn-mini pull-right" href="#">View more <span class="icon-plus"></span></a>
            Best selling Products
        </div>
    </div>
</div>
</body>
</html>
