package edu.greem4.http.servlet;

import edu.greem4.http.dto.FlightDto;
import edu.greem4.http.service.FlightService;
import edu.greem4.http.util.JspHelper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

import static java.util.stream.Collectors.toMap;

@WebServlet("/content")
public class ContentServlet extends HttpServlet {

    private final FlightService flightService = FlightService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<FlightDto> flightDtos = flightService.findAll();
        req.setAttribute("flights", flightDtos);
        req.getSession().setAttribute("flights", flightDtos.stream()
                .collect(toMap(FlightDto::getId, FlightDto::getDescription)));


        req.getRequestDispatcher(JspHelper.getPath("content"))
                .forward(req, resp);
    }
}
