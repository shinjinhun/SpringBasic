<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Welcome!</title>
    <script src="https://code.jquery.com/jquery-1.11.3.js"></script>
</head>
<body>
<h2>Hello HomePage</h2>
<P>The time on the server is ${serverTime}. </P>
<p>이름 : ${name}</p>
<div>
    <c:set var="age" value="40"></c:set>
    <c:import url="home_detail.jsp" charEncoding="UTF-8">
        <c:param name="age" value="${age}"></c:param>
    </c:import>
</div>

<div>
    home.jsp 나이 : <c:out value="${age}"/>
</div>

<div>
    home_detail.jsp 나이 : <c:out value="${detail_age}"/>
</div>


<div>
    get 파라미터 값 출력 <c:out value="${param.getName}" />
</div>

<script>
    $(document).ready(function(){
        var params = {};
        params.name = "test";
        params.age = 22;
        params.test = "ttt";
        $.get("./home", params);
    });
</script>
</body>
</html>
