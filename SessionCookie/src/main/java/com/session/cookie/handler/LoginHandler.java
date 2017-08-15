package com.session.cookie.handler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.session.cookie.sessions.HttpSessions;

@WebServlet("/cookie_test")
public class LoginHandler extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String getCookie = null;
        
        getCookie = request.getHeader("Cookie");
        
        System.out.println("GET COOKIE : " + getCookie);
        
        if(HttpSessions.getHttpSessionByCookie(getCookie) == null)
        {
            response.sendRedirect("/jsp/index.jsp");
        }
        else
        {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/jsp/testSuccess.jsp");
            requestDispatcher.forward(request, response);
        }
    }
}
