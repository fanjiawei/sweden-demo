<%@ page import="javax.persistence.Query" %>
<%@ page import="com.whereareyou.model.User" %>
<%@ page import="javax.persistence.NoResultException" %>
<%@ page import="javax.persistence.Persistence" %>
<%@ page import="javax.persistence.EntityManager" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="com.whereareyou.model.InputValue" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.SimpleDateFormat" %>
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
<p>Some instructions well be put here</p>
<form action="${context}/page2.jsp">Date:<input type="text" name="date">&nbsp;&nbsp;<input type="submit" value="search"/> </form>
<div id="canvas-holder">
    <canvas id="chart-area" width="300" height="300"/>
</div>
<script type="text/javascript" src="${context}/js/chart.min.js"></script>
<script src="${context}/js/jquery-1.11.1.min.js" type="text/javascript"></script>
<script src="${context}/js/jquery-ui.min.js" type="text/javascript"></script>
<script type="text/javascript">
    <%
    String[] colors = {"#FE3AFE","#7B0BA4","#E60F45","#DD17F9","#0559D2","#800C4D","#1D4E39","#BA6A92","#8A961C","#0B3CF4","#7EC8A1","#827C14","#CC0971","#F9F0E1","#7198C6","#05E9D3","#65E517","#AB21B3","#49461D","#F38AF1","#7FA140","#37AF85","#483BF1","#464258","#39A66D"};
    String queryString = "SELECT u FROM InputValue u WHERE u.date = :date order by u.name asc";
    EntityManager em = Persistence.createEntityManagerFactory("database").createEntityManager();
    Query query = em.createQuery(queryString);
    Date searchDate = new Date();
    if(request.getParameter("date")!=null){
       SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
       searchDate = dateFormat.parse(request.getParameter("date"));
    }
    query.setParameter("date", searchDate);
    List<InputValue> result;
    try {
        result = query.getResultList();
    }catch (NoResultException e){
        result = null;
    }
    %>
    <%if(result.size()>0){%>
    var pieData = [

            <%for(int i =0;i<result.size();i++){
            InputValue it=result.get(i);
            %>

        {value:<%=it.getValue()%>,label:"<%=it.getName()%>",color:"<%=colors[i]%>"}<%if(i!=result.size()-1){%>,<%}%>
            <%}%>

    ];
    <%}else{%>
    var pieData = [];
    <%}%>

    window.onload = function(){
        var ctx = document.getElementById("chart-area").getContext("2d");
        window.pie = new Chart(ctx).Pie(pieData,{
            segmentShowStroke : true,
            legendTemplate : "<ul class=\"${"<%="}name.toLowerCase()${"%>"}-legend\">${"<%"} for (var i=0; i<segments.length; i++){${"%>"}<li><span style=\"background-color:${"<%="}segments[i].fillColor${"%>"}\"></span>${"<%"}if(segments[i].label){${"%><%="}segments[i].label${"%><%}%>"}</li>${"<%}%>"}</ul>"
        });
    };
    $( "input[name=date]" ).datepicker();
</script>

</body>
</html>