package com.session.cookie.main;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import com.session.cookie.handler.RequestHandler;

public class WebServer 
{
    private static int port = 8080;
    
    public static void main( String[] args )
    {
        try
        {
            ServerSocket serverSocket = new ServerSocket(port);
            Socket connection;
            
            while((connection = serverSocket.accept()) != null)
            {
                RequestHandler requestHandler = new RequestHandler(connection);
                requestHandler.start();
            }
            
        }
        catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
