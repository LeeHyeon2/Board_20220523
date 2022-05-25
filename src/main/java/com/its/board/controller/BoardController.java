package com.its.board.controller;

import com.its.board.dto.BoardDTO;
import com.its.board.dto.CommentDTO;
import com.its.board.dto.PageDTO;
import com.its.board.service.BoardService;
import com.its.board.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.List;

@Controller
public class BoardController {
    @Autowired
    public BoardService boardService;
    @Autowired
    private CommentService commentService;

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
            return "redirect:/board/paging";
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
    public String findById(@RequestParam("id") int id , Model model, @RequestParam(value = "page",required = false,defaultValue = "1") int page){
        BoardDTO boardDTO = boardService.findById(id);
        model.addAttribute("boardList",boardDTO);
        model.addAttribute("page",page);
        // 댓글 목록도 가져가야 함.
        List<CommentDTO> commentDTOList = commentService.findAll(id);
        model.addAttribute("commentList",commentDTOList);
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
            model.addAttribute("boardDTO",login);
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
        return "redirect:/detail?id=" + boardDTO.getId();
    }

    @GetMapping("/board/saveFile")
    public String saveFileForm(){
        return "board/saveFile";
    }

    @PostMapping("/board/saveFile")
    public String saveFile(@ModelAttribute BoardDTO boardDTO) throws IOException {
        boardService.saveFile(boardDTO);
        return "redirect:/findAll";
    }

    @GetMapping("/board/paging")
//      /board/paging?page=1
//      required=false로 하면 /board/paging 로 요청도가능
//      별도의 페이지 값을 요청하지 않으면 첫페이지(pgae=1_를 보여주자
    public String paging(@RequestParam(value="page", required=false, defaultValue="1") int page, Model model) {
        List<BoardDTO> boardList = boardService.pagingList(page);
        PageDTO paging = boardService.paging(page);
        model.addAttribute("boardList", boardList);
        model.addAttribute("paging", paging);
        return "board/pagingList";
    }

    @GetMapping("/board/search")
    public String search(@RequestParam("searchType") String searchType,
                         @RequestParam("q") String q , Model model){
        List<BoardDTO> searchList = boardService.search(searchType,q);
        model.addAttribute("boardList",searchList);
        return "findAll";
    }


}
