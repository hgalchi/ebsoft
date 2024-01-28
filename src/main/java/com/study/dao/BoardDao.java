package com.study.dao;

import com.study.dto.PageVo;
import com.study.entity.Board;

import java.util.List;
import java.util.Map;

public interface BoardDao {

    List<Map<String,Object>>getList(PageVo page);
    int getTotal();

    void create(Board board);

    Map<String,Object> findBy(int id);

    void update(Board board);
}
