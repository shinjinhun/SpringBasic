<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<p>test cImportHeaderjsp</p>

<P>전달받음2 :  ${serverTime} </P>
<P>전달받음2 :  ${name} </P>
<P>home_detail.jsp 나이 :  <c:out value="${param.age}"/> </P>

<%--아래와 같이 scope="application" 자식이 선언하는건 잘 사용하지 않는다--%>
<c:set var="detail_age" value="60" scope="application"></c:set>



<c:set var="hobby" value="<font color='red'>영화보기</font>"></c:set>
<div>
    <p>취미는(태크가 반영됨) : ${hobby}</p>
    <p>취미는(태그가 출력됨) : <c:out value="${hobby}"/></p>
</div>
