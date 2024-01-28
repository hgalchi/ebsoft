package com.study.service;

import com.study.dao.BoardDao;
import com.study.dao.BoardDaoImple;
import com.study.dto.PageVo;
import com.study.entity.Board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class BoardServiceImpl implements BoardSerivce {

    BoardDao dao = new BoardDaoImple();

    //전체 게시글 조회
    public  List<Map<String,Object>> getList(PageVo page) {

        List<Map<String,Object>>list=dao.getList(page);

        return list;
    }

    //전체 개시글 개수
    public int getTotal() {
        return dao.getTotal();
    }

    //게시글 등록
    @Override
    public void create(Board board) {
        dao.create(board);
    }

    //특정 게시글 조회
    @Override
    public Map<String,Object> findBy(int id) {
        return dao.findBy(id);
    }

    //게시글 업데이트
    @Override
    public void update(Board board) {
        dao.update(board);
    }

}
