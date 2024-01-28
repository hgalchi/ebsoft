package com.study.controller;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontController", urlPatterns = "/board/*")
public class FrontController extends HttpServlet {

    private Map<String, Controller> controllerMap = new HashMap<>();

    public FrontController() {
        //목록
        controllerMap.put("/board/free/list", new BoardListController());
        //등록
        controllerMap.put("/board/free/write", new BoardRegisterController());
        //수정
        //todo : board/free/modify/글번호
        controllerMap.put("/board/free/modify", new BoardModifyController());

    }
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //1. 요청에 매핑되는 controller 위임
        String requestURI = req.getRequestURI();
        Controller controller = controllerMap.get(requestURI);

        if (controller == null) {
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            System.out.println("controller를 찾을 수 없음");
            return;
        }

        //2. 비즈니스 로직 처리
        //todo : viewPath 위치가 web-inf하위파일이 아닌경우 (webapp-hello.jsp)
        String view=controller.process(req, resp);
        String viewPath = "/WEB-INF/views"+view;

        //3. 결과 반환
        RequestDispatcher rd = req.getRequestDispatcher(viewPath);

        rd.forward(req, resp);

    }
}
