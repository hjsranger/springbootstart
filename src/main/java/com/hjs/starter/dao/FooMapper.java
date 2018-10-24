package com.hjs.starter.dao;

import com.hjs.starter.model.Foo;
import java.util.List;

public interface FooMapper {
    int deleteByPrimaryKey(String id);

    int insert(Foo record);

    Foo selectByPrimaryKey(String id);

    List<Foo> selectAll();

    int updateByPrimaryKey(Foo record);
}