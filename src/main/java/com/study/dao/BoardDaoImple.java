package com.study.dao;

import com.study.dto.PageOper;
import com.study.dto.PageVo;
import com.study.entity.Board;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.*;
import java.util.Date;

public class BoardDaoImple implements BoardDao {

    static final String DB_URL = "jdbc:mysql://localhost:3308/ebrainsoft_study";
    static final String USER = "ebsoft";
    static final String PASS = "ebsoft";

    Connection conn;

    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public BoardDaoImple()  {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }





    @Override
    public void create(Board board) {
        String sql = "INSERT INTO board(writer,pw,title,content,view,created_date,modified_date,category) " +
                "VALUE (?,?,?,?,?,?,?,?)";
        try{
            ps = conn.prepareStatement(sql);

            ps.setString(1, board.getWriter());
            ps.setString(2, board.getPw());
            ps.setString(3, board.getTitle());
            ps.setString(4, board.getContent());
            ps.setInt(5, board.getView());
            ps.setTimestamp(6, Timestamp.valueOf(board.getCreated_date()));
            ps.setTimestamp(7,null);
            ps.setInt(8, board.getCategory());

            ps.executeUpdate();

            ps.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Map<String,Object> findBy(int id) {

        Map<String, Object> map;

        String sql = " SELECT *FROM board " +
                "left join category on board.category=category.id " +
                "where board.id=?";
        try{
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            rs = ps.executeQuery();
            rs.next();

            map = new HashMap<>();
            map.put("category", rs.getString("name"));
            map.put("pw",rs.getString("pw"));
            map.put("title", rs.getString("title"));
            map.put("writer", rs.getString("writer"));
            map.put("view", rs.getInt("view"));
            map.put("created_date", rs.getString("created_date"));
            map.put("modified_date", rs.getString("modified_date"));
            map.put("id", rs.getInt("id"));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return map;

    }

    @Override
    public void update(Board board) {

        String sql = "UPDATE board SET writer=?,pw=?,title=?,content=?,view=?,created_date=?,modified_date=?,category=?";

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, board.getWriter());
            ps.setString(2, board.getPw());
            ps.setString(3, board.getTitle());
            ps.setString(4, board.getContent());
            ps.setInt(5, board.getView());
            ps.setTimestamp(6, Timestamp.valueOf(board.getCreated_date()));
            ps.setTimestamp(7, Timestamp.valueOf(LocalDateTime.now()));
            ps.setInt(8, board.getCategory());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public List<Map<String,Object>> getList(PageVo page) {

        PageVo vo = new PageVo();

        List<Map<String,Object>> list = new ArrayList<>();

        String sql = "SELECT *FROM board " +
                "left join category on board.category=category.id " +
                "where created_date>=date_add(now(),interval -1 year) " +
                "order by created_date desc "+
                "limit ?,?";

        try {
            ps = conn.prepareStatement(sql);
            vo.setPage(page.getskip());
            vo.setAmount(page.getAmount());

            ps.setInt(1, page.getskip());
            ps.setInt(2, page.getAmount());

            rs = ps.executeQuery();
            while (rs.next()) {
                Map<String, Object> map = new HashMap<>();
                map.put("category", rs.getString("name"));
                map.put("title", rs.getString("title"));
                map.put("writer", rs.getString("writer"));
                map.put("view", rs.getInt("view"));
                map.put("created_date", rs.getString("created_date"));
                map.put("modified_date", rs.getString("modified_date"));
                map.put("id", rs.getInt("id"));

                list.add(map);
            }

            System.out.println("page info:" + new PageOper(vo, 11));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {

        }
        return list;


    }

    public int getTotal() {

        String sql = "SELECT COUNT(*)as total from board";
        try{
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            rs.next();

            return rs.getInt("total");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
