package com.study.controller;

import com.study.dto.PageVo;
import com.study.service.BoardSerivce;
import com.study.service.BoardServiceImpl;

import javax.servlet.DispatcherType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BoardListController implements Controller {
    @Override
    public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        //todo : bean으로 등록 싱글톤 구현
        BoardSerivce service = new BoardServiceImpl();

       //화면으로부터 페이지 데이터를 받아 Pagevo를 초기화
        int pageNum = req.getParameter("Page") != null ? Integer.parseInt(req.getParameter("page")) : 1;

        int PageAmount = req.getParameter("amount") != null ? Integer.parseInt(req.getParameter("amount")) : 10;

       //검색조건이 있는 경우, 없는 경우

        PageVo page = new PageVo(pageNum, PageAmount);

       req.setAttribute("boardList",service.getList(page));

        return "/board/hello.jsp";
    }

    //handlePostReqeust,handleGetReqeust 요청에 대한 서비스 로직 처리
}
