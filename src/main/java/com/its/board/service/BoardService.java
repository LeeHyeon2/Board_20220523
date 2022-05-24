package com.its.board.service;

import com.its.board.dto.BoardDTO;
import com.its.board.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {
    @Autowired
    public BoardRepository boardRepository;

    public boolean save(BoardDTO boardDTO) {
        int saveResult = boardRepository.save(boardDTO);
        if(saveResult>0){
            return true;
        } else {
            return false;
        }

    }

    public List<BoardDTO> findAll() {
        return boardRepository.findAll();
    }

    public BoardDTO findById(int id) {
        return boardRepository.findById(id);
    }


    public BoardDTO login(BoardDTO boardDTO) {
        return boardRepository.login(boardDTO);
    }

    public void delete(BoardDTO boardDTO) {
        boardRepository.delete(boardDTO);
    }

    public void update(BoardDTO boardDTO) {
        boardRepository.update(boardDTO);
    }
}
