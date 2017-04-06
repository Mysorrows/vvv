<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="util.Main" %>
<%@ page import="util.HTML.HTML" %>
<%
  if(Main.loginUser()==null){
    response.sendRedirect("Login.jsp");
    return;
  }
  String rid=request.getParameter("rid");
%>
<html>
<head>
  <title>编译错误信息 - <%=Main.config.OJName%></title>
</head>
<body>
<div class="container-fluid">
    <jsp:include page="module/head.jsp"/>
    <%=HTML.ceInfo(rid,true)%>

</div><jsp:include page="module/foot.jsp"/>
</body>
</html>
