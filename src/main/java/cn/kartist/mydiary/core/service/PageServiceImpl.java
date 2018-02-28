package cn.kartist.mydiary.core.service;

import cn.kartist.mydiary.common.Exception.ServiceException;
import cn.kartist.mydiary.common.entity.User;
import cn.kartist.mydiary.core.dao.DiaryPageDao;
import cn.kartist.mydiary.core.entity.DiaryPage;
import cn.kartist.mydiary.core.entity.DiarypageExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PageServiceImpl implements PageService {

    @Autowired
    private DiaryPageDao diaryPageDao;

    private void checkId(Integer id) {
        if (id == null) {
            throw new ServiceException("id bad");
        }
    }

    @Override
    public void save(DiaryPage diaryPage, User user) {
        diaryPage.setCreateUser(user.getUserName());
        diaryPage.setUpdateUser(user.getUserName());
        int row = diaryPageDao.insertSelective(diaryPage);
        if (row != 1) {
            throw new ServiceException("保存失败");
        }

    }

    @Override
    public Map<String, Object> getAllDiary(Integer page) {
        if (page == null) {
            page = 1;
        }
        int offSet = (page - 1) * 10;

        Map<String, Object> map = new HashMap<>();

        final DiarypageExample example = new DiarypageExample();
        example.setLimit(10);
        example.setOffset(offSet);
        List list = diaryPageDao.selectByExample(example);
        map.put("diaryPage", list);
        return map;
    }

    @Override
    public DiaryPage getDiaryPageById(Integer id) {
        checkId(id);
        DiaryPage diaryPage = diaryPageDao.selectByPrimaryKey(id);
        return diaryPage;
    }

    @Override
    public void update(DiaryPage diaryPage, User user) {
        diaryPage.setUpdateUser(user.getUserName());
        diaryPage.setUpdateTime(new Date());
        diaryPageDao.updateByPrimaryKeySelective(diaryPage);

    }

    @Override
    public void deleteById(Integer id) {
        checkId(id);
        DiaryPage page = new DiaryPage();
        page.setDelete(true);
        page.setId(id);
        doUpdate(page);
    }

    @Override
    public void refreshById(Integer id) {
        checkId(id);
        DiaryPage page = new DiaryPage();
        page.setId(id);
        page.setDelete(false);
        doUpdate(page);
    }

    /**
     * 更新
     * @param page
     */
    private void doUpdate(DiaryPage page) {
        int row = diaryPageDao.updateByPrimaryKeySelective(page);
        if(row !=1){
            throw new ServiceException("操作失败");
        }
    }

    @Override
    public void relDeleteById(Integer id) {
        checkId(id);
        int row = diaryPageDao.deleteByPrimaryKey(id);
        if (row !=1 ){
            throw new ServiceException("删除失败");
        }
    }

    @Override
    public List<DiaryPage> delHistory() {
        List<DiaryPage> list = diaryPageDao.selectHistory();
        return list;
    }
}
