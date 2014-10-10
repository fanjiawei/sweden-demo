<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %><!DOCTYPE html>
<c:set var="context" value="${pageContext.request.contextPath}" />
<html lang="en">
<head>
    <title>page1</title>
    <link rel="stylesheet" type="text/css" href="${context}/css/style.css">
    <link rel="stylesheet" type="text/css" href="${context}/css/jquery-ui.min.css"/>
</head>
<body>
<jsp:include page="topTemplate.jsp"/>

<!-- This div will contain all the main content -->
<div id="main">

    <h2>Same name as the menu option will appear here</h2>
    <p id="p-instruktion">Some instructions will be put here.</p>
    <form action="${context}/save" method="post">
        Date:
        <input type="text" name="date"><br>

        <c:forEach begin="1" end="25" var="it">
            Input ${it}:&nbsp;<input type="text" name="input_${it}"/><br>
        </c:forEach>
        <input type="submit" value="submit"/>
    </form>
</div>
<script src="${context}/js/jquery-1.11.1.min.js" type="text/javascript"></script>
<script src="${context}/js/jquery-ui.min.js" type="text/javascript"></script>
<script>
    $(function() {
        $( "input[name=date]" ).datepicker();
    });
</script>
</body>
</html>
