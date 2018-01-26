package cn.kartist.mydiary.core.service;

import cn.kartist.mydiary.common.entity.User;
import cn.kartist.mydiary.core.entity.DiaryPage;

import java.util.List;
import java.util.Map;

/**
 * 管理日记页
 */
public interface PageService {

    /**
     * 保存
     * @param diaryPage
     */
    void save(DiaryPage diaryPage, User user);

    /**
     * 获取
     */
    Map<String, Object> getAllDiary();

    DiaryPage getDiaryPageById(Integer id);


    void update(DiaryPage diaryPage, User user);

    /**
     * 软删除
     * @param id
     */
    void deleteById(Integer id);

    /**
     * 恢复
     * @param id
     */
    void refreshById(Integer id);

    /**
     * 真正的删除
     * @param id
     */
    void relDeleteById(Integer id);

    /**
     * 删除的历史
     * @return
     */
    List<DiaryPage> delHistory();
}
