package com.session.cookie.sessions;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

public class HttpSessions
{
    private static Map<String,HttpSession> cookies = new HashMap<String,HttpSession>();
    
    public static void inputCookie(String cookie, HttpSession session)
    {
        cookies.put(cookie, session);
    }
    
    public static HttpSession getHttpSessionByCookie(String cookie)
    {
        return cookies.get(cookie);
    }
}
