package com.its.board.repository;

import com.its.board.dto.BoardDTO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BoardRepository {
    @Autowired
    private SqlSessionTemplate sql;

    public int save(BoardDTO boardDTO) {
        return sql.insert("Board.save",boardDTO);
    }

    public List<BoardDTO> findAll() {
        return sql.selectList("Board.findAll");
    }

    public BoardDTO findById(int id) {
        sql.update("Board.hits",id);
        return sql.selectOne("Board.findById",id);
    }


    public BoardDTO login(BoardDTO boardDTO) {
        return sql.selectOne("Board.login",boardDTO);
    }

    public void delete(BoardDTO boardDTO) {
        sql.delete("Board.delete",boardDTO);
    }

    public void update(BoardDTO boardDTO) {
        sql.update("Board.update",boardDTO);
    }

    public void saveFile(BoardDTO boardDTO) {
        sql.insert("Board.saveFile",boardDTO);
    }
}
