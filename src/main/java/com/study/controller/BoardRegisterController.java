package com.study.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.study.entity.Board;
import com.study.service.BoardSerivce;
import com.study.service.BoardServiceImpl;
import com.study.service.BodyUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BoardRegisterController implements Controller {

    @Override
    public String process(HttpServletRequest req, HttpServletResponse res) throws  IOException {

        BoardSerivce service = new BoardServiceImpl();

//todo : form은 post인데 왜 body로 받지 않는거지
        Board board = new Board(
                Integer.parseInt(req.getParameter("category")),
                req.getParameter("writer"),
                req.getParameter("pw"),
                req.getParameter("title"),
                req.getParameter("content")
        );

        service.create(board);
        return null;

    }
}
