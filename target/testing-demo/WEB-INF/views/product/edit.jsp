<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
		<title>
			Edit
		</title>
	</head>
	<body>
            <h1>Edit</h1>

        <form:form commandName="product" action="${pageContext.request.contextPath}/product/save.htm">
            <form:hidden path="id" />
              <table>
                  <tr>
                      <td>Name:</td>
                      <td><form:input path="name" /></td>
                  </tr>
                  <tr>
                      <td>Manufacturer:</td>
                      <td><form:input path="manufacturer" /></td>
                  </tr>
                   <tr>
                      <td>Price:</td>
                      <td><form:input path="price" /></td>
                  </tr>
                  <tr>
                      <td colspan="2">
                          <input type="submit" value="Save Changes" />
                          <a href="${pageContext.request.contextPath}/product/view.htm?id=${product.id}">Cancel</a>
                      </td>
                  </tr>
              </table>
          </form:form>
	</body>
</html>
