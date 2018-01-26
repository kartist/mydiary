package cn.kartist.mydiary.core.dao;

import cn.kartist.mydiary.core.entity.Weather;
import cn.kartist.mydiary.core.entity.WeatherExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WeatherDao {
    long countByExample(WeatherExample example);

    int deleteByExample(WeatherExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Weather record);

    int insertSelective(Weather record);

    List<Weather> selectByExample(WeatherExample example);

    Weather selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Weather record, @Param("example") WeatherExample example);

    int updateByExample(@Param("record") Weather record, @Param("example") WeatherExample example);

    int updateByPrimaryKeySelective(Weather record);

    int updateByPrimaryKey(Weather record);
}