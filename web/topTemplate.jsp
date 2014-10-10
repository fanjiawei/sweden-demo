<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="context" value="${pageContext.request.contextPath}" />
<!-- This is the upper part of the homepage containing the name and logo of the homepage-->
<div id="logocontainer">
    <h1>Name of homepage</h1>
    <img id="sitelogo" src="logo.jpg" alt="company logo">
</div>

<!-- Main Menu will be contained inside this div-->
<div id="menubar">
    <ul>
        <li><a href="${context}/page1.jsp">Menu option 1</a></li>
        <li><a href="${context}/page2.jsp">Menu Option 2</a></li>
        <li id="login"><a href="#login">Log In</a></li>
    </ul>
</div>