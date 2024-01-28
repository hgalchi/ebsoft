package com.study.service;

import com.study.dto.PageVo;
import com.study.entity.Board;

import java.util.List;
import java.util.Map;

public interface BoardSerivce {

    public  List<Map<String,Object>> getList(PageVo page);
    public int getTotal();

    public void create(Board board);

    public Map<String,Object> findBy(int id);

    public void update(Board board);
}
