package cn.kartist.mydiary.core.dao;

import cn.kartist.mydiary.core.entity.DiaryPage;
import cn.kartist.mydiary.core.entity.DiarypageExample;
import java.util.List;

import groovyjarjarantlr.collections.impl.LList;
import org.apache.ibatis.annotations.Param;

public interface DiaryPageDao {
    long countByExample(DiarypageExample example);

    int deleteByExample(DiarypageExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DiaryPage record);

    int insertSelective(DiaryPage record);

    List<DiaryPage> selectByExampleWithBLOBs(DiarypageExample example);

    List<DiaryPage> selectByExample(DiarypageExample example);

    List<DiaryPage> selectHistory();

    DiaryPage selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DiaryPage record, @Param("example") DiarypageExample example);

    int updateByExampleWithBLOBs(@Param("record") DiaryPage record, @Param("example") DiarypageExample example);

    int updateByExample(@Param("record") DiaryPage record, @Param("example") DiarypageExample example);

    int updateByPrimaryKeySelective(DiaryPage record);

    int updateByPrimaryKeyWithBLOBs(DiaryPage record);

    int updateByPrimaryKey(DiaryPage record);

}