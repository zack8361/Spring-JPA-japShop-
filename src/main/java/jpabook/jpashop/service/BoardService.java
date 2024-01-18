package jpabook.jpashop.service;


import jpabook.jpashop.entity.Board;
import jpabook.jpashop.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public List<Board> showAll(){
        return boardRepository.showAll();
    }
}
