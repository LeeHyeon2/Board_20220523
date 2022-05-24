package com.its.board.service;

import com.its.board.dto.BoardDTO;
import com.its.board.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
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

    public void saveFile(BoardDTO boardDTO) throws IOException {
        /**
            1. DTO 객체에 담길 파일을 꺼냄.
            2. 파일의 이름을 가져옴.
            2.1. 파일 이름 중복을 피하기 위한 조치
            3. 파일 이름을 DTO 객체의 boardFileName에 저장
            4. 파일의 저장위치 지정.
            5. 파일 저장처리
            6. DTO 객체 repository로 전달
        */
        MultipartFile boardFile = boardDTO.getBoardFile(); // 1.
        String boardFileName = boardFile.getOriginalFilename(); // 2.
        boardFileName = System.currentTimeMillis() + "-" + boardFileName; // 2.1.
        boardDTO.setBoardFileName(boardFileName); // 3.
        String savePath = "C:\\spring_img\\" + boardFileName; // 4.
        //5.
        if(!boardFile.isEmpty()){
            boardFile.transferTo(new File(savePath));
        }
        boardRepository.saveFile(boardDTO); // 6.
    }
}
