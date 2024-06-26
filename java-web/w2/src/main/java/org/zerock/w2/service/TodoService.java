package org.zerock.w2.service;

import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.zerock.w2.dao.TodoDAO;
import org.zerock.w2.domain.TodoVO;
import org.zerock.w2.dto.TodoDTO;
import org.zerock.w2.util.MapperUtil;

import java.util.List;
import java.util.stream.Collectors;

@Log4j2
public enum TodoService {
    INSTANCE;

    private TodoDAO dao;
    private ModelMapper modelMapper;

    TodoService() {
        dao = new TodoDAO();
        modelMapper = MapperUtil.INSTANCE.get();
    }

    public void register(TodoDTO dto) throws Exception {
        TodoVO todoVO = modelMapper.map(dto, TodoVO.class);

        log.info(todoVO);
        dao.insert(todoVO);
    }

    public List<TodoDTO> listAll() throws Exception {
        List<TodoVO> voList = dao.selectAll();

        log.info("voList...");

        log.info(voList);

        List<TodoDTO> dtoList = voList.stream()
                .map(vo -> modelMapper.map(vo, TodoDTO.class))
                .collect(Collectors.toList());

        return dtoList;
    }

    public TodoDTO get(Long tno) throws Exception {
        log.info("tno: " + tno);
        TodoVO vo = dao.selectOne(tno);
        TodoDTO dto = modelMapper.map(vo, TodoDTO.class);
        return dto;
    }

    public void remove(Long tno) throws Exception {
        log.info("tno: " + tno);
        dao.deleteOne(tno);
    }

    public void modify(TodoDTO dto) throws Exception {
        log.info("todoDto: " + dto);
        TodoVO vo = modelMapper.map(dto, TodoVO.class);
        dao.updateOne(vo);
    }
}
