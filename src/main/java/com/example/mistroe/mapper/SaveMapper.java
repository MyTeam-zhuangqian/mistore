package com.example.mistroe.mapper;

import com.example.mistroe.pojo.Save;
import java.util.List;

public interface SaveMapper {
    int deleteByPrimaryKey(String idSave);

    int insert(Save record);

    Save selectByPrimaryKey(String idSave);

    List<Save> selectAll();

    int updateByPrimaryKey(Save record);

    int SaveCar(Save save);
}