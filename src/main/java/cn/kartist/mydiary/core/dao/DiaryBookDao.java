package cn.kartist.mydiary.core.dao;

import cn.kartist.mydiary.core.entity.DiaryBook;
import cn.kartist.mydiary.core.entity.DiaryBookExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DiaryBookDao {
    long countByExample(DiaryBookExample example);

    int deleteByExample(DiaryBookExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DiaryBook record);

    int insertSelective(DiaryBook record);

    List<DiaryBook> selectByExample(DiaryBookExample example);

    DiaryBook selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DiaryBook record, @Param("example") DiaryBookExample example);

    int updateByExample(@Param("record") DiaryBook record, @Param("example") DiaryBookExample example);

    int updateByPrimaryKeySelective(DiaryBook record);

    int updateByPrimaryKey(DiaryBook record);
}