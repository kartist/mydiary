package cn.kartist.mydiary.core.service;

import cn.kartist.mydiary.MydiaryApplicationTests;
import cn.kartist.mydiary.common.entity.User;
import cn.kartist.mydiary.core.entity.DiaryPage;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class PageServiceImplTest extends MydiaryApplicationTests {
    @Autowired
    private PageService diaryService;

    @Transactional
    @Rollback
    @Test
    public void save() throws Exception {
        DiaryPage diaryPage = new DiaryPage();
        diaryPage.setWeatherId(1);
        diaryPage.setBookId(1);
        diaryPage.setTitle("名字");
        diaryPage.setContent("日记内容");
        Exception result = null;
        try {
            diaryService.save(diaryPage, new User("testUser", ""));
        } catch (Exception e) {
            e.printStackTrace();
            result = e;
        }
        assertNull(result);

    }

    @Test
    public void getAllDiary() throws Exception {
        Map result = diaryService.getAllDiary(1);
        assertNotNull(result);
        logger.info(result.toString());
    }

}