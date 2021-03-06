package com.session.cookie.handler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.session.cookie.sessions.HttpSessions;

@WebServlet("/login")
public class RequestHandler extends HttpServlet
{
    private String name1 = "kim";
    private String password1 = "eogur123";
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String paramName = request.getParameter("name");
        String paramPass = request.getParameter("passwd");
        
        if (paramName.equals(name1) && paramPass.equals(password1))
        {
            System.out.println("GET HEADER : " + request.getHeader("Cookie"));
             
            HttpSessions.inputCookie(request.getHeader("Cookie"), request.getSession());
            response.addHeader("Set-Cookie",request.getHeader("Cookie"));

            HttpSession session = request.getSession();
            session.setAttribute("sessionName", paramName + "is name of session");
            
            System.out.println("Set Attribute Name : " + session.getAttribute("sessionName"));
            
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/jsp/success.jsp");
            requestDispatcher.forward(request, response);
        }
    }
}
