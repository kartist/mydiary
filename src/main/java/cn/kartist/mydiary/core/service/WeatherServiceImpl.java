package cn.kartist.mydiary.core.service;

import cn.kartist.mydiary.core.dao.WeatherDao;
import cn.kartist.mydiary.core.entity.Weather;
import cn.kartist.mydiary.core.entity.WeatherExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 天气
 */
@Service
public class WeatherServiceImpl implements WeatherService {
    @Autowired
    private WeatherDao weatherDao;
    @Override
    public List<Weather> getAllWeather() {

        return weatherDao.selectByExample(new WeatherExample());
    }
}
