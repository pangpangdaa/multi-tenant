package com.mycat.mapper;

import com.mycat.pojo.Item;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ItemMapper {
    public Item getOne(@Param("id") int id);
    public Integer count();
    public void insert(Item item);
}
