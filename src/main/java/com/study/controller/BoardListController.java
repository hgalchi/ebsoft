package com.study.controller;

import javax.servlet.DispatcherType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BoardListController implements Controller {
    @Override
    public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        String username = req.getParameter("username");

        System.out.println("username" + "ming servlet");

        req.setAttribute("username", username);

        return "/board/hello.jsp";
    }
}
