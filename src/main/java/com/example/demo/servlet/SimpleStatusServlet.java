package com.example.demo.servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.*;
import jakarta.io.IOException;

@WebServlet(urlPatterns = ("/status"))
public class SimpleStstusServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req , HttpServletResponse res)throws IOException{
        res.setStatus(HttpServletResponse.SC_Ok);
        res.getWriter().writer("Servlet Running");
    }
}
