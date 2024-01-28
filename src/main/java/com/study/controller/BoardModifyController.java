package com.study.controller;

import com.study.service.BoardSerivce;
import com.study.service.BoardServiceImpl;
import com.study.service.BodyUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

public class BoardModifyController implements Controller {
    @Override
    public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        BoardSerivce service = new BoardServiceImpl();

        String method = req.getMethod();

        //수정 게시글 조회
        if ("GET".equals(method)) {

            Map<String,Object>map=service.findBy(Integer.parseInt(req.getParameter("seq")));

            req.setAttribute("boardList",map);

        }
        //수정 게시글 등록
        else if ("POST".equals(method)) {

        } else {
            res.setStatus(HttpServletResponse.SC_NOT_FOUND);
            System.out.println("잘못된 요청");
        }


        return null;
    }
}
