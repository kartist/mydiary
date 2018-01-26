package cn.kartist.mydiary.core.service;

import cn.kartist.mydiary.MydiaryApplicationTests;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import static  org.junit.Assert.*;
import java.util.List;

public class BookServiceImplTest extends MydiaryApplicationTests {

    protected final Logger logger = LoggerFactory.getLogger(MydiaryApplicationTests.class);

    @Autowired
    private BookService service;

    @Test
    public void getAllBook() throws Exception {
        List books = service.getAllBook();
        assertNotNull(books);
        logger.info(books.toString());
    }

}