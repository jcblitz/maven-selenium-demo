<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
		<title>
			Index
		</title>
	</head>
	<body>
            <h1>Index</h1>

        <table>
            <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Manufacturer</th>
            <th>Price</th>
            <th>Action</th>
            </tr>
        <c:forEach var="product" items="${products}">
            <tr>
                <td><c:out value="${product.id}" /></td>
                <td><c:out value="${product.name}" /></td>
                <td><c:out value="${product.manufacturer}" /></td>
                <td><fmt:formatNumber value="${product.price}" type="currency"/></td>
                <td>
                    <a href="${pageContext.request.contextPath}/product/view.htm?id=${product.id}">View</a>
                    <a href="${pageContext.request.contextPath}/product/edit.htm?id=${product.id}">Edit</a>
                    <a href="${pageContext.request.contextPath}/product/delete.htm?id=${product.id}">Delete</a>
                </td>


        
            </tr>
        </c:forEach>
        </table>


        <a title="Create a new product" href="${pageContext.request.contextPath}/product/create.htm">Create</a>
	</body>
</html>
