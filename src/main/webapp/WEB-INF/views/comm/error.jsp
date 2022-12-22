<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <c:set var="statusCode" value="${requestScope['javax.servlet.error.status_code']}"/>

    <c:choose>
        <c:when test="${statusCode eq '400'}">
            <div class="errorName">Bad Request - 400 Error</div>
            <h3 class="title">잘못된 요청</h3>
            <p class="text">잘못된 문법으로 인하여 서버가 요청을 이해할 수 없습니다.</p>
        </c:when>
        <c:when test="${statusCode eq '404'}">
            <div class="errorName">Not found - 404 Error</div>
            <h3 class="title">페이지를 찾을 수 없습니다.</h3>
            <p class="text">방문하시려는 페이지의 주소가 잘못 입력되었거나,<br />
                페이지의 주소가 변경 또는 삭제되어, 요청하신 페이지로 이동할 수 없습니다.<br />
                입력하신 주소가 정확한 지 다시 한 번 확인해 주시기 바랍니다.
            </p>
        </c:when>
        <c:otherwise>
            <div class="errorName">Internal Server Error - 500 Error</div>
            <h3 class="title">요청내용 수행 불가</h3>
            <p class="text">서비스 이용에 불편을 드려 죄송합니다.<br />
                서버 내부 오류로 인하여 요청하신 사항을 수행할 수 없습니다.
            </p>
        </c:otherwise>
    </c:choose>

</body>
</html>
