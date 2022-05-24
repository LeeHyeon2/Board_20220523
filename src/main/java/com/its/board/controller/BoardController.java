package com.its.board.controller;

import com.its.board.dto.BoardDTO;
import com.its.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BoardController {
    @Autowired
    public BoardService boardService;

    @GetMapping("/index")
    public String index(){
        return "index";
    }

    @GetMapping("/save")
    public String save(){
        return "board/save";
    }

    @PostMapping("/save")
    public String saveDTO(@ModelAttribute BoardDTO boardDTO, Model model){
        boolean saveResult = boardService.save(boardDTO);
        if(saveResult){
            System.out.println("저장 성공");
            return "redirect:/findAll";
        }else {
            return "index";
        }
    }
    @GetMapping("/findAll")
    public String findAll(Model model){
        List<BoardDTO> boardDTOList = boardService.findAll();
        model.addAttribute("boardList",boardDTOList);
        return "findAll";
    }

    @GetMapping("/detail")
    public String findById(@RequestParam("id") int id , Model model){
        BoardDTO boardDTO = boardService.findById(id);
        model.addAttribute("boardList",boardDTO);
        return "board/detail";
    }

    @GetMapping("/update")
    public String updatePasswordCheck(@RequestParam("id") int id, Model model){
        String updateLink = ("/update?id=" + id);
        BoardDTO boardDTO = boardService.findById(id);
        model.addAttribute("Link",updateLink);
        model.addAttribute("boardDTO",boardDTO);
        return "passwordCheck";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute BoardDTO  boardDTO,Model model){
        BoardDTO login = boardService.login(boardDTO);
        if(login != null){
            model.addAttribute("boardDTO",boardDTO);
            return "update";
        }else{
            return "redirect:/findAll";
        }
    }

    @GetMapping("/delete")
    public String deletePasswordCheck(@RequestParam("id") int id, Model model){
        String deleteLink = ("/delete?id=" + id);
        BoardDTO boardDTO = boardService.findById(id);
        model.addAttribute("Link",deleteLink);
        model.addAttribute("boardDTO",boardDTO);
        return "passwordCheck";
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute BoardDTO boardDTO){;
        BoardDTO login = boardService.login(boardDTO);
        if(login != null){
            boardService.delete(boardDTO);
            return "redirect:/findAll";
        }else{
            return "redirect:/findAll";
        }
    }

    @PostMapping("/update/request")
    public String updateRequest(@ModelAttribute BoardDTO boardDTO){
        boardService.update(boardDTO);
        return "redirect:/findAll";
    }
}
