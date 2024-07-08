package spring.security.service;

import jakarta.transaction.Transactional;
import spring.security.dto.PageRequestDTO;
import spring.security.dto.PageResponseDTO;
import spring.security.dto.TodoDTO;

@Transactional
public interface TodoService {
    Long register(TodoDTO todoDTO);

    TodoDTO read(Long tno);

    PageResponseDTO<TodoDTO> list(PageRequestDTO pageRequestDTO);

    void remove(Long tno);

    void modify(TodoDTO todoDTO);
}
