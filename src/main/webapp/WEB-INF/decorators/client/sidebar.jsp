<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="sidebar" class="span3">
    <div class="well well-small">
        <ul class="nav nav-list">
            <c:forEach var="category" items="${sidebar_categories}">
                <li><a href="/categories/${category.id}"><span class="icon-chevron-right"></span>${category.name}</a>
                </li>
            </c:forEach>
            <li style="border:0"> &nbsp;</li>
            <li><a href="/categories/"><span class="icon-chevron-right"></span>View all</a></li>
        </ul>
    </div>

    <div class="well well-small alert alert-warning cntr">
        <h2>50% Discount</h2>
        <p>
            only valid for online order. <br><br><a class="defaultBtn" href="#">Click here </a>
        </p>
    </div>
    <div class="well well-small"><a href="#"><img src="/static/img/paypal.jpg" alt="payment method paypal"></a></div>

    <a class="shopBtn btn-block" href="#">Upcoming products <br><small>Click to view</small></a>
    <br>
    <br>
    <ul class="nav nav-list promowrapper">
        <c:forEach var="product" items="${sidebar_shoes}">
            <li>
                <div class="thumbnail">
                    <a class="zoomTool" href="${url_detail_product}/${product.id}" title="add to cart"><span
                            class="icon-search"></span>
                        QUICK VIEW</a>
                    <img src="/img/${product.thumb}" alt="bootstrap ecommerce templates">
                    <div class="caption">
                        <h4><a class="defaultBtn" href=""${url_detail_product}/${product.id}">VIEW</a> <span
                                class="pull-right">${product.lstDetailShoeModels[0].newPrice} ₫</span></h4>
                    </div>
                </div>
            </li>
            <li style="border:0"> &nbsp;</li>
        </c:forEach>
    </ul>
</div>