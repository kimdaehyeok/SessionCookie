package com.session.cookie.handler;

import java.net.Socket;

public class RequestHandler extends Thread
{
    private Socket connection;
    
    public RequestHandler(Socket connection)
    {
        this.connection = connection;
    }
    
    public void run()
    {
        
    }
}
