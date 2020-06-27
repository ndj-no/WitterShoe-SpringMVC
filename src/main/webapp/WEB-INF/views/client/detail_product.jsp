<%--
  Created by IntelliJ IDEA.
  User: ndj-No
  Date: 6/27/2020
  Time: 2:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../my_var.jsp"/>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="row">
    <jsp:include page="../../decorators/client/sidebar.jsp"/>
    <div class="span9">
        <ul class="breadcrumb">
            <li><a href="/">Home Page</a> <span class="divider">/</span></li>
            <li><a href="/">${ product.categoryModel.name }</a>
                <span class="divider">/</span></li>
            <li class="active">${ product.name }</li>
        </ul>
        <div class="well well-small">
            <div class="row-fluid">
                <div class="span5">
                    <div id="myCarousel" class="carousel slide cntr">
                        <div class="carousel-inner">
                            <div class="item active">
                                <img src="${url_image}/${product.lstImageModels[0].url}"
                                     alt="${product.lstImageModels[0].desc}"
                                     style="width:100%">
                            </div>
                            <c:forEach items="${product.lstImageModels}" var="image" begin="1">
                                <div class="item">
                                    <img src="${url_image}/${image.url}" alt="${image.desc}"
                                         style="width:100%">
                                </div>
                            </c:forEach>
                        </div>
                        <a class="left carousel-control" href="#myCarousel" data-slide="prev">‹</a>
                        <a class="right carousel-control" href="#myCarousel" data-slide="next">›</a>
                    </div>
                </div>
                <div class="span7">
                    <h3>${product.name}</h3>
                    <hr class="soft"/>
                    <div class="">
                        <p class="pull-left" style=" color: grey">
                            ${ product.viewCount } <span class="icon-eye-open"></span>
                        </p>
                        <p class="pull-right" style="font-style: italic; color: grey">
                            ${ product.quantitySold } <span class="icon-shopping-cart"></span>
                        </p>
                    </div>

                    <br/>
                    <br/>
                    <form class="form-horizontal qtyFrm"
                          action="{% url 'cart:add_to_cart_url' %}?next={{ request.path }}" method="post">
                        <input type="hidden" value="{{ shoe.id }}" name="shoe_id">
                        <div class="control-group">
                            <p class="control-label"
                               style=" font-style: italic;color: #4bb1cf; text-decoration: line-through; font-size: large">
                                ${ product.lstDetailShoeModels[0].oldPrice }
                                <sup>đ</sup></p>
                            <p class="controls"
                               style=" padding-top: 5px;color: red; font-weight: bold; font-size: large">
                                <span>${ product.lstDetailShoeModels[0].newPrice } <sup>đ</sup></span></p>
                        </div>
                        <div class="control-group">
                            <label class="control-label"><span>Số lượng</span></label>
                            <div class="controls">
                                <input type="number" class="span6" placeholder="Số lượng" value="1" name="quantity">
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label"><span>Size</span></label>
                            <div class="controls">
                                <select class="span11" name="size">
                                    <c:forEach items="${product.lstDetailShoeModels}" var="detail_product">
                                        <option>${detail_product.size}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label"><span>Màu sắc</span></label>
                            <div class="controls">
                                <select class="span11" name="color">
                                    <c:forEach items="${product.lstDetailShoeModels}" var="detail_product">
                                        <option>${detail_product.colorModel.name}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <h4>Còn trung bình n sản phẩm mỗi loại</h4>
                        <br/>
                        <div style="font-size: medium">
                            <a href="{% url 'favourite:like_unlike_url' shoe_id=shoe.id %}?next={{ request.path }}"
                               style="color: red">
                                <%--<span class="icon-heart" style="font-size: larger"></span>--%>
                                <span class="icon-heart-empty" style="font-size: larger"></span>
                            </a> <span> ${ product.favouriteCount } </span><span> người thích</span>
                        </div>
                        <br/>
                        <button type="submit" class="shopBtn" formmethod="post"><span
                                class=" icon-shopping-cart"></span> Thêm vào giỏ hàng
                        </button>
                    </form>
                </div>
            </div>
            <hr class="softn clr"/>


            <ul id="productDetail" class="nav nav-tabs">
                <li class="active"><a href="#home" data-toggle="tab">Chi tiết sản phẩm</a></li>
                <li class=""><a href="#profile" data-toggle="tab">Sản phẩm tương tự</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Phụ kiện <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><a href="#cat1" data-toggle="tab">Tất</a></li>
                        <li><a href="#cat2" data-toggle="tab">Dây giày</a></li>
                    </ul>
                </li>
            </ul>
            <div id="myTabContent" class="tab-content tabWrapper">
                <div class="tab-pane fade active in" id="home">
                    <h4>Product Information</h4>
                    <table class="table table-striped">
                        <tbody>
                        <tr class="techSpecRow">
                            <td class="techSpecTD1">Color:</td>
                            <td class="techSpecTD2">Black</td>
                        </tr>
                        <tr class="techSpecRow">
                            <td class="techSpecTD1">Style:</td>
                            <td class="techSpecTD2">Apparel,Sports</td>
                        </tr>
                        <tr class="techSpecRow">
                            <td class="techSpecTD1">Season:</td>
                            <td class="techSpecTD2">spring/summer</td>
                        </tr>
                        <tr class="techSpecRow">
                            <td class="techSpecTD1">Usage:</td>
                            <td class="techSpecTD2">fitness</td>
                        </tr>
                        <tr class="techSpecRow">
                            <td class="techSpecTD1">Sport:</td>
                            <td class="techSpecTD2">122855031</td>
                        </tr>
                        <tr class="techSpecRow">
                            <td class="techSpecTD1">Brand:</td>
                            <td class="techSpecTD2">Shock Absorber</td>
                        </tr>
                        </tbody>
                    </table>
                    <p>Raw denim you probably haven't heard of them jean shorts Austin. Nesciunt tofu stumptown
                        aliqua, retro synth master cleanse. Mustache cliche tempor, williamsburg carles vegan
                        helvetica. Reprehenderit butcher retro keffiyeh dreamcatcher synth. Cosby sweater eu banh
                        mi, qui irure terry richardson ex squid. Aliquip placeat salvia cillum iphone. Seitan
                        aliquip quis cardigan american apparel, butcher voluptate nisi qui.</p>
                    <p>Raw denim you probably haven't heard of them jean shorts Austin. Nesciunt tofu stumptown
                        aliqua, retro synth master cleanse. Mustache cliche tempor, williamsburg carles vegan
                        helvetica. Reprehenderit butcher retro keffiyeh dreamcatcher synth. Cosby sweater eu banh
                        mi, qui irure terry richardson ex squid. Aliquip placeat salvia cillum iphone. Seitan
                        aliquip quis cardigan american apparel, butcher voluptate nisi qui.</p>
                    <p>Raw denim you probably haven't heard of them jean shorts Austin. Nesciunt tofu stumptown
                        aliqua, retro synth master cleanse. Mustache cliche tempor, williamsburg carles vegan
                        helvetica. Reprehenderit butcher retro keffiyeh dreamcatcher synth. Cosby sweater eu banh
                        mi, qui irure terry richardson ex squid. Aliquip placeat salvia cillum iphone. Seitan
                        aliquip quis cardigan american apparel, butcher voluptate nisi qui.</p>
                    <p>Raw denim you probably haven't heard of them jean shorts Austin. Nesciunt tofu stumptown
                        aliqua, retro synth master cleanse. Mustache cliche tempor, williamsburg carles vegan
                        helvetica. Reprehenderit butcher retro keffiyeh dreamcatcher synth. Cosby sweater eu banh
                        mi, qui irure terry richardson ex squid. Aliquip placeat salvia cillum iphone. Seitan
                        aliquip quis cardigan american apparel, butcher voluptate nisi qui.</p>
                    <p>Raw denim you probably haven't heard of them jean shorts Austin. Nesciunt tofu stumptown
                        aliqua, retro synth master cleanse. Mustache cliche tempor, williamsburg carles vegan
                        helvetica. Reprehenderit butcher retro keffiyeh dreamcatcher synth. Cosby sweater eu banh
                        mi, qui irure terry richardson ex squid. Aliquip placeat salvia cillum iphone. Seitan
                        aliquip quis cardigan american apparel, butcher voluptate nisi qui.</p>
                    <p>Raw denim you probably haven't heard of them jean shorts Austin. Nesciunt tofu stumptown
                        aliqua, retro synth master cleanse. Mustache cliche tempor, williamsburg carles vegan
                        helvetica. Reprehenderit butcher retro keffiyeh dreamcatcher synth. Cosby sweater eu banh
                        mi, qui irure terry richardson ex squid. Aliquip placeat salvia cillum iphone. Seitan
                        aliquip quis cardigan american apparel, butcher voluptate nisi qui.</p>
                    <p>Raw denim you probably haven't heard of them jean shorts Austin. Nesciunt tofu stumptown
                        aliqua, retro synth master cleanse. Mustache cliche tempor, williamsburg carles vegan
                        helvetica. Reprehenderit butcher retro keffiyeh dreamcatcher synth. Cosby sweater eu banh
                        mi, qui irure terry richardson ex squid. Aliquip placeat salvia cillum iphone. Seitan
                        aliquip quis cardigan american apparel, butcher voluptate nisi qui.</p>
                    <p>Raw denim you probably haven't heard of them jean shorts Austin. Nesciunt tofu stumptown
                        aliqua, retro synth master cleanse. Mustache cliche tempor, williamsburg carles vegan
                        helvetica. Reprehenderit butcher retro keffiyeh dreamcatcher synth. Cosby sweater eu banh
                        mi, qui irure terry richardson ex squid. Aliquip placeat salvia cillum iphone. Seitan
                        aliquip quis cardigan american apparel, butcher voluptate nisi qui.</p>

                </div>
                <div class="tab-pane fade" id="profile">
                    <c:forEach items="${relatedProducts}" var="relatedProduct">
                        <div class="row-fluid">
                            <div class="span2">
                                <img src="${url_image}/${relatedProduct.thumb}" alt="">
                            </div>
                            <div class="span6">
                                <h5>
                                    <a href="${url_detail_product}/${relatedProduct.id}">
                                            ${relatedProduct.name}
                                    </a>
                                </h5>
                                <p>
                                        ${relatedProduct.desc}
                                </p>
                            </div>
                            <div class="span4 alignR">
                                <form class="form-horizontal qtyFrm">
                                    <h3><span>${relatedProduct.lstDetailShoeModels[0].newPrice}</span>
                                        <sup>đ</sup></h3>
                                    <div class="pull-right" style="width: 150px">
                                        <p class="pull-left" style="font-style: italic; color: grey">
                                                ${relatedProduct.viewCount } <span class="icon-eye-open"></span>
                                        </p>
                                        <p class="pull-right" style="font-style: italic; color: grey">
                                                ${ relatedProduct.quantitySold } <span
                                                class="icon-shopping-cart"></span>
                                        </p>
                                    </div>
                                    <br>
                                    <div class="btn-group">
                                            <%--                                    <a href="product_details.html" class="defaultBtn"><span--%>
                                            <%--                                    class=" icon-shopping-cart"></span> Add to cart</a>--%>
                                        <a href="${url_detail_product}/${relatedProduct.id}"
                                           class="shopBtn">VIEW</a>
                                    </div>
                                </form>
                            </div>
                        </div>
                        <hr class="soft">
                    </c:forEach>

                </div>
                <div class="tab-pane fade" id="cat1">
                    <p>Etsy mixtape wayfarers, ethical wes anderson tofu before they sold out mcsweeney's organic
                        lomo retro fanny pack lo-fi farm-to-table readymade. Messenger bag gentrify pitchfork
                        tattooed craft beer, iphone skateboard locavore carles etsy salvia banksy hoodie helvetica.
                        DIY synth PBR banksy irony. Leggings gentrify squid 8-bit cred pitchfork. Williamsburg banh
                        mi whatever gluten-free, carles pitchfork biodiesel fixie etsy retro mlkshk vice blog.
                        Scenester cred you probably haven't heard of them, vinyl craft beer blog stumptown.
                        Pitchfork sustainable tofu synth chambray yr.</p>
                    <br>
                    <br>
                    <div class="row-fluid">
                        <div class="span2">
                            <img src="assets/img/b.jpg" alt="">
                        </div>
                        <div class="span6">
                            <h5>Product Name </h5>
                            <p>
                                Nowadays the lingerie industry is one of the most successful business spheres.
                                We always stay in touch with the latest fashion tendencies -
                                that is why our goods are so popular..
                            </p>
                        </div>
                        <div class="span4 alignR">
                            <form class="form-horizontal qtyFrm">
                                <h3> $140.00</h3>
                                <label class="checkbox">
                                    <input type="checkbox"> Adds product to compair
                                </label><br>
                                <div class="btn-group">
                                    <a href="product_details.html" class="defaultBtn"><span
                                            class=" icon-shopping-cart"></span> Add to cart</a>
                                    <a href="product_details.html" class="shopBtn">VIEW</a>
                                </div>
                            </form>
                        </div>
                    </div>
                    <hr class="soften"/>
                    <div class="row-fluid">
                        <div class="span2">
                            <img src="assets/img/a.jpg" alt="">
                        </div>
                        <div class="span6">
                            <h5>Product Name </h5>
                            <p>
                                Nowadays the lingerie industry is one of the most successful business spheres.
                                We always stay in touch with the latest fashion tendencies -
                                that is why our goods are so popular..
                            </p>
                        </div>
                        <div class="span4 alignR">
                            <form class="form-horizontal qtyFrm">
                                <h3> $140.00</h3>
                                <label class="checkbox">
                                    <input type="checkbox"> Adds product to compair
                                </label><br>
                                <div class="btn-group">
                                    <a href="product_details.html" class="defaultBtn"><span
                                            class=" icon-shopping-cart"></span> Add to cart</a>
                                    <a href="product_details.html" class="shopBtn">VIEW</a>
                                </div>
                            </form>
                        </div>
                    </div>
                    <hr class="soften"/>
                </div>
                <div class="tab-pane fade" id="cat2">
                    <div class="row-fluid">
                        <div class="span2">
                            <img src="assets/img/d.jpg" alt="">
                        </div>
                        <div class="span6">
                            <h5>Product Name </h5>
                            <p>
                                Nowadays the lingerie industry is one of the most successful business spheres.
                                We always stay in touch with the latest fashion tendencies -
                                that is why our goods are so popular..
                            </p>
                        </div>
                        <div class="span4 alignR">
                            <form class="form-horizontal qtyFrm">
                                <h3> $140.00</h3>
                                <label class="checkbox">
                                    <input type="checkbox"> Adds product to compair
                                </label><br>
                                <div class="btn-group">
                                    <a href="product_details.html" class="defaultBtn"><span
                                            class=" icon-shopping-cart"></span> Add to cart</a>
                                    <a href="product_details.html" class="shopBtn">VIEW</a>
                                </div>
                            </form>
                        </div>
                    </div>
                    <hr class="soften"/>
                    <div class="row-fluid">
                        <div class="span2">
                            <img src="assets/img/d.jpg" alt="">
                        </div>
                        <div class="span6">
                            <h5>Product Name </h5>
                            <p>
                                Nowadays the lingerie industry is one of the most successful business spheres.
                                We always stay in touch with the latest fashion tendencies -
                                that is why our goods are so popular..
                            </p>
                        </div>
                        <div class="span4 alignR">
                            <form class="form-horizontal qtyFrm">
                                <h3> $140.00</h3>
                                <label class="checkbox">
                                    <input type="checkbox"> Adds product to compair
                                </label><br>
                                <div class="btn-group">
                                    <a href="product_details.html" class="defaultBtn"><span
                                            class=" icon-shopping-cart"></span> Add to cart</a>
                                    <a href="product_details.html" class="shopBtn">VIEW</a>
                                </div>
                            </form>
                        </div>
                    </div>
                    <hr class="soften"/>
                    <div class="row-fluid">
                        <div class="span2">
                            <img src="assets/img/d.jpg" alt="">
                        </div>
                        <div class="span6">
                            <h5>Product Name </h5>
                            <p>
                                Nowadays the lingerie industry is one of the most successful business spheres.
                                We always stay in touch with the latest fashion tendencies -
                                that is why our goods are so popular..
                            </p>
                        </div>
                        <div class="span4 alignR">
                            <form class="form-horizontal qtyFrm">
                                <h3> $140.00</h3>
                                <label class="checkbox">
                                    <input type="checkbox"> Adds product to compair
                                </label><br>
                                <div class="btn-group">
                                    <a href="product_details.html" class="defaultBtn"><span
                                            class=" icon-shopping-cart"></span> Add to cart</a>
                                    <a href="product_details.html" class="shopBtn">VIEW</a>
                                </div>
                            </form>
                        </div>
                    </div>
                    <hr class="soften"/>
                    <div class="row-fluid">
                        <div class="span2">
                            <img src="assets/img/d.jpg" alt="">
                        </div>
                        <div class="span6">
                            <h5>Product Name </h5>
                            <p>
                                Nowadays the lingerie industry is one of the most successful business spheres.
                                We always stay in touch with the latest fashion tendencies -
                                that is why our goods are so popular..
                            </p>
                        </div>
                        <div class="span4 alignR">
                            <form class="form-horizontal qtyFrm">
                                <h3> $140.00</h3>
                                <label class="checkbox">
                                    <input type="checkbox"> Adds product to compair
                                </label><br>
                                <div class="btn-group">
                                    <a href="product_details.html" class="defaultBtn"><span
                                            class=" icon-shopping-cart"></span> Add to cart</a>
                                    <a href="product_details.html" class="shopBtn">VIEW</a>
                                </div>
                            </form>
                        </div>
                    </div>
                    <hr class="soften"/>

                </div>
            </div>

        </div>
    </div>
</div>
</body>
</html>
