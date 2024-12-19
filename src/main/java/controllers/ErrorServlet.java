package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "ErrorServlet", urlPatterns = {"/handle-error"})
public class ErrorServlet extends BaseController {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String errorType = req.getParameter("error");

        String errorMessage;
        switch (errorType) {
            case "NotFound":
                resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
                errorMessage = "The resource you are looking for was not found.";
                break;
            case "Forbident":
                resp.setStatus(HttpServletResponse.SC_FORBIDDEN);
                errorMessage = "Access to this resource is forbidden.";
                break;
            case "Unauthorize":
                resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                errorMessage = "You are not authorized to access this resource.";
                break;
            default:
                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                errorMessage = "An unknown error occurred.";
                break;
        }

        req.setAttribute("errorMessage", errorMessage);
        render(req, resp, "/error");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
