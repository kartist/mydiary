package cn.kartist.mydiary.core.service;

import cn.kartist.mydiary.core.dao.DiaryBookDao;
import cn.kartist.mydiary.core.entity.DiaryBook;
import cn.kartist.mydiary.core.entity.DiaryBookExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private DiaryBookDao bookDao;

    @Override
    public List<DiaryBook> getAllBook() {
        List<DiaryBook> books=bookDao.selectByExample(new DiaryBookExample());

        return books;

    }
}
