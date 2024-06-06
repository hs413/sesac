package org.zerock.jdbcex.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;
import org.zerock.jdbcex.dto.TodoDTO;
import org.zerock.jdbcex.service.TodoService;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@WebServlet(name = "todoModifyController", urlPatterns = "/todo/modify")
@Log4j2
public class TodoModifyController extends HttpServlet {
    private TodoService todoService = TodoService.INSTANCE;
    private final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Long tno = Long.parseLong(req.getParameter("tno"));
            TodoDTO dto = todoService.get(tno);

            req.setAttribute("dto", dto);
            req.getRequestDispatcher("/WEB-INF/todo/modify.jsp").forward(req, resp);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new ServletException("modify get... error");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String finishedStr = req.getParameter("finished");

        TodoDTO dto = TodoDTO.builder()
                .tno(Long.parseLong(req.getParameter("tno")))
                .title(req.getParameter("title"))
                .dueDate(LocalDate.parse(req.getParameter("dueDate"), DATE_FORMATTER))
                .finished(finishedStr != null && finishedStr.equals("on"))
                .build();

        log.info("/todo/modify POST ...");
        log.info(dto);
        try {
            todoService.modify(dto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        resp.sendRedirect("/todo/list");
    }
}
