<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
    <title>Welcome!</title>
</head>
<body>
        <hr>

        <div style="padding: 100px;">

            <form id="frm" name="frm" method="post" action="/ArchivesBasic/register/action2" enctype="multipart/form-data" >
                <input type="file" name="file1"/>
                <input type="file" name="file2"/>
                <input type="file" name="file3"/>
                <Button type="submit">전송</Button>
            </form>

        </div>

</body>
</html>