package com.example.demo.Controller;

import com.example.demo.Entity.Board;
import com.example.demo.Repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/board")
public class BoardController {
    private BoardRepository boardRep;

    @Autowired
    public BoardController(BoardRepository boardRep){
        this.boardRep=boardRep;
    }

    //POST로 유저 추가
    @PostMapping
    public Board put(@RequestParam String name, @RequestParam String age) {
        return boardRep.save(new Board(name, age));
    }

    //테이블 리스트 가져오기
    @GetMapping
    public Iterable<Board> list(){
        return boardRep.findAll();
    }

    //id로 테이블 값 가져오기
    @GetMapping(value = "/{id}")
    public Optional<Board> findOne(@PathVariable Long id) {
        return boardRep.findById(id);
    }

    //id로 테이블 값 수정
    @PutMapping(value = "/{id}")
    public Board update(@PathVariable Long id, @RequestParam String name, @RequestParam String age) {
        Optional<Board> board = boardRep.findById(id);
        board.get().setName(name);
        board.get().setAge(age);
        return boardRep.save(board.get());
    }

    //id로 테이블 값 삭제
    @DeleteMapping
    public void delete(@RequestParam Long id) {
        boardRep.deleteById(id);
    }
}
