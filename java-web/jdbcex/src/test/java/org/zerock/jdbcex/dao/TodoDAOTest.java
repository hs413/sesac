package org.zerock.jdbcex.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.zerock.jdbcex.domain.TodoVO;

import java.time.LocalDate;
import java.util.List;

class TodoDAOTest {
    private TodoDAO dao;

    @BeforeEach
    public void ready() {
        dao = new TodoDAO();
    }

    @Test
    public void testTime() throws Exception {
        System.out.println(dao.getTime());
    }

    @Test
    public void testTime2() throws Exception {
        System.out.println(dao.getTime2());
    }

    @Test
    public void testInsert() throws Exception {
        TodoVO vo = TodoVO.builder()
                .title("Sample Test...")
                .dueDate(LocalDate.of(2024, 1, 5))
                .build();

        dao.insert(vo);
    }

    @Test
    public void testSelectAll() throws Exception {
        List<TodoVO> list = dao.selectAll();
        list.forEach(System.out::println);
    }

    @Test
    public void testSelectOne() throws Exception {
        TodoVO vo = dao.selectOne(2L);
        System.out.println(vo);
    }

    @Test
    public void testUpdateOne() throws Exception {
        TodoVO vo = TodoVO.builder()
                .tno(1L)
                .title("Sample Test")
                .dueDate(LocalDate.of(2024, 3, 1))
                .finished(true)
                .build();

        dao.updateOne(vo);
    }
}
