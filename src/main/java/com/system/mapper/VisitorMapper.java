package com.system.mapper;

import com.system.po.Visitor;
import com.system.po.VisitorExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VisitorMapper {
    int countByExample(VisitorExample example);

    int deleteByExample(VisitorExample example);

    int deleteByPrimaryKey(String vname);

    int insert(Visitor record);

    int insertSelective(Visitor record);

    List<Visitor> selectByExample(VisitorExample example);
    /**
     * 根据name模糊查询
     * @param name
     * @return
     */
    List<Visitor> findByFuzzyName(String name);
    
    Visitor selectByPrimaryKey(String vname);

    int updateByExampleSelective(@Param("record") Visitor record, @Param("example") VisitorExample example);

    int updateByExample(@Param("record") Visitor record, @Param("example") VisitorExample example);

    int updateByPrimaryKeySelective(Visitor record);

    int updateByPrimaryKey(Visitor record);
}