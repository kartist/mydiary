package cn.kartist.mydiary.core.dao;

import cn.kartist.mydiary.core.entity.ColorRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Kartist 2018/4/1 19:35
 */
public interface ColorRecordDao {
    /**
     * 选出前topnumber个的记录
     *
     * @param topNumber
     * @return
     */
    List<ColorRecord> selectTopRecord(int topNumber);

    /**
     * 保存一条记录
     *
     * @param score    记录
     * @param userName 用户名
     * @return 返回
     */
    int saveRecord(@Param("score") int score, @Param("userName") String userName);
}
