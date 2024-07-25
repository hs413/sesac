package org.zerock.springex.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper2 {
    @Select("select now()")
    String getTime();
}
