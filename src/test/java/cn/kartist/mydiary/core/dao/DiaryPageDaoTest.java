package cn.kartist.mydiary.core.dao;

import cn.kartist.mydiary.MydiaryApplicationTests;
import cn.kartist.mydiary.core.entity.DiaryPage;
import cn.kartist.mydiary.core.service.BookServiceImplTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Kartist 2018/1/10 22:10
 */
public class DiaryPageDaoTest extends BookServiceImplTest {
    @Autowired
    private DiaryPageDao pageDao;
    @Test
    public void selectHistory() throws Exception {
        List<DiaryPage> diaryPages = pageDao.selectHistory();
        logger.info(diaryPages.toString());
    }

}