package com.example.demo.Repository;

import com.example.demo.Entity.Board;
import org.springframework.data.repository.CrudRepository;

public interface BoardRepository  extends CrudRepository<Board, Long> {

}
