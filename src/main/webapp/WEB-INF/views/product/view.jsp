<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
		<title>
			View
		</title>
                <link rel="stylesheet" type="text/css" media="screen" href="${pageContext.request.contextPath}/stylesheets/styles.css" />
	</head>
	<body>
            <h1>View</h1>

        <div id="message" class="success">
            ${sessionScope.message}
            <c:remove var="message" scope="session"/>
        </div>

        <div>
            <span>id: </span> ${product.id}
        </div>
        <div>
            <span>name: </span> ${product.name}
        </div>
        <div>
            <span>manufactuerer: </span> ${product.manufacturer}
        </div>
        <div>
            <span>price: </span> ${product.price}
        </div>

        <div>
            <a href="${pageContext.request.contextPath}/product/index.htm">Index</a>
            <a href="${pageContext.request.contextPath}/product/edit.htm?id=${product.id}">Edit</a>
            <a href="${pageContext.request.contextPath}/product/delete.htm?id=${product.id}">Delete</a>
        </div>
	</body>
</html>
