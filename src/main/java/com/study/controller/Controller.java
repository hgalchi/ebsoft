package com.study.controller;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface Controller {

    public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException;


}
