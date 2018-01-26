package cn.kartist.mydiary.core.service;

import cn.kartist.mydiary.MydiaryApplicationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

public class WeatherServiceImplTest extends MydiaryApplicationTests {
    @Autowired
    private WeatherService weatherService;
    @Test
    public void getAllWeather() throws Exception {
        List result = weatherService.getAllWeather();
        assertNotNull(result);
        logger.info(result.toString());
    }

}