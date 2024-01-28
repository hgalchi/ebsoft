package com.study.service;


import com.study.dto.PageVo;
import com.study.entity.Board;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

class BoardServiceImplTest {
    private BoardSerivce service = new BoardServiceImpl();


    @Test
    public void getList() {

        List<Map<String,Object>> list = service.getList(new PageVo(1,10));

        for (Map<String,Object> map: list) {
            System.out.println(map);
        }
    }

    @Test
    public void create() {
        Board board = new Board(1, "윤선미", "1234", "28일 정모", "스터디원 모집");
        service.create(board);
    }

    @Test
    public void findBy() {
        service.findBy(3);
    }



}