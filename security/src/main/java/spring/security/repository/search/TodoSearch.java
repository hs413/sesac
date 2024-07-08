package spring.security.repository.search;

import org.springframework.data.domain.Page;
import spring.security.dto.PageRequestDTO;
import spring.security.dto.TodoDTO;

public interface TodoSearch {
    Page<TodoDTO> list(PageRequestDTO pageRequestDTO);
}
