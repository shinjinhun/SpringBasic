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

            <form id="frm" name="frm" method="post" action="<c:url value="/register/action2"/>" enctype="multipart/form-data" >
                <input type="file" name="file1"/>
                <input type="file" name="file2"/>
                <input type="file" name="file3"/>
                <Button type="submit">전송</Button>
            </form>

        </div>

</body>
</html>