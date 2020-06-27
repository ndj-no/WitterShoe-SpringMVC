<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="dec" uri="http://www.opensymphony.com/sitemesh/decorator" %>

<html>
<head>
    <title><dec:title default="Default title"/></title>
    <meta charset="utf-8">
    <title>Witter - Shop giày cho giới trẻ</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <!-- Bootstrap styles -->
    <link href="/static/css/bootstrap.css" rel="stylesheet"/>
    <!-- Customize styles -->
    <link href="/static/css/style.css" rel="stylesheet"/>
    <!-- font awesome styles -->
    <link href="/static/font-awesome/css/font-awesome.css" rel="stylesheet">
    <!--[if IE 7]>
    <link href="/static/font-awesome/css/font-awesome-ie7.min.css" rel="stylesheet">
    <![endif]-->

    <!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

    <!-- Favicons -->
    <link rel="shortcut icon" href="/static/ico/pngguru.com.png">
    <style>
        /*body {*/
        /*    background-image: url('/img/background/white_leather.png');*/
        /*}*/

        /*.button_messenger {*/
        /*    position: fixed;*/
        /*    width: 60px;*/
        /*    height: 60px;*/
        /*    background: #fff;*/
        /*    background-image: url('/img/messenger.jpg');*/
        /*    background-repeat: no-repeat;*/
        /*    background-size: 80% auto;*/
        /*    background-position: center;*/
        /*    box-shadow: 1px 1px 5px 0 #333;*/
        /*    bottom: 20px;*/
        /*    right: 20px;*/
        /*    border-radius: 100%;*/
        /*    z-index: 10000;*/
        /*}*/
    </style>
    <dec:head/>
</head>
<body>

<jsp:include page="header.jsp"/>

<dec:body/>

<jsp:include page="footer.jsp"/>

</body>
</html>
