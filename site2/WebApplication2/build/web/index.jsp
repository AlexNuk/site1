
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form name="myform" action="MyServlet" method="POST">
            x1 =  <input type="text" name="x1" value="1" size="10" /><br/>
            x2 = <input type="text" name="x2" value="5" size="10" /><br/>
            delta =  <input type="text" name="delta" value="0.01" size="10" /><br/>
            a = <input type="text" name="a1" value="2.4" size="10" /><br/>
            <input type="submit" value="Отправить" />
        </form>
    </body>
</html>
