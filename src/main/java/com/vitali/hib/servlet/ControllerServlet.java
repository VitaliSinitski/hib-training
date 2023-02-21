package com.vitali.hib.servlet;

import com.vitali.hib.command.CrudCommand;
import com.vitali.hib.command.CrudFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@WebServlet("/controller")
public class ControllerServlet extends HttpServlet {
    private final CrudFactory crudFactory = CrudFactory.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CrudCommand crudCommand = crudFactory.defineCommand(request);
        String page = Objects.requireNonNull(crudCommand.execute(request));
        getServletContext().getRequestDispatcher(page).forward(request, response);
    }

}
