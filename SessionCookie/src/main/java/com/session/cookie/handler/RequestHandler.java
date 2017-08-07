package com.session.cookie.handler;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
            if ((request.getHeader("Cookie") == null))
            {
                String jSessionid = UUID.randomUUID().toString();
                response.addHeader("Set-Cookie","JSESSIONID="+ jSessionid);
                HttpSessions.inputCookie(jSessionid, request.getSession());
                System.out.println(jSessionid);
            }
            
            System.out.println((request.getHeader("Cookie")));
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/jsp/success.jsp");
            requestDispatcher.forward(request, response);
        }
    }
}
