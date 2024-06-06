package org.zerock.jdbcex.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
}
