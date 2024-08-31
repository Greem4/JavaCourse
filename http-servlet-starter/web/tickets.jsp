<%@ page import="edu.greem4.http.service.TicketService" %>
<%@ page import="edu.greem4.http.dto.TicketDto" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Купленные билеты:</h1>
<ul>
    <%
        Long flightId = Long.valueOf(request.getParameter("flightId"));
        List<TicketDto> tickets = TicketService.getInstance().findAllByFlightId(flightId);
        for (TicketDto ticket : tickets) {
            out.write(String.format("<li>%s</li>", ticket.getSeaNo()));
        }
    %>
</ul>
</body>
</html>

<%!
    public void jspInit() {
        System.out.println("Hello world!");
    }
%>
