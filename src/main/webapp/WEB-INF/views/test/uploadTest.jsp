<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Welcome!</title>
</head>
<body>
        <hr>

        <div style="padding: 100px;">

            <form id="frm" name="frm" method="post" action="<c:url value="/register/action"/>" enctype="multipart/form-data" >
                <input type="file" name="file"/>
                <Button type="submit">전송</Button>
            </form>

        </div>

</body>
</html>
