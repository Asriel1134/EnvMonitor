package com.envmonitor.Service;

import com.envmonitor.Dao.CityDao;
import com.envmonitor.Dao.ProvinceAndCityDao;
import com.envmonitor.Dao.ProvinceDao;
import com.envmonitor.Entity.City;
import com.envmonitor.Entity.Province;
import org.springframework.beans.factory.annotation.Autowired;

import javax.crypto.spec.PSource;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CityService {

    private CityDao curCity = new CityDao();

    private ProvinceDao curProvince = new ProvinceDao();
    private ProvinceAndCityDao curDao = new ProvinceAndCityDao();

    private ProvinceService affectedProvince = new ProvinceService();

    private String AQI2AQL(long AQI) {

        if (AQI >= 0 && AQI <= 50) {
            return "优";
        } else if (AQI >= 51 && AQI <= 100) {
            return "良";
        } else if (AQI >= 101 && AQI <= 150) {
            return "轻度污染";
        } else if (AQI >= 151 && AQI <= 200) {
            return "中度污染";
        } else if (AQI >= 201 && AQI <= 300) {
            return "重度污染";
        } else {
            return "严重污染";
        }
    }

    private String AQI2AQC(long AQI) {

        if (AQI >= 0 && AQI <= 50) {
            return "#00FF00";
        } else if (AQI >= 51 && AQI <= 100) {
            return "#FFFF00";
        } else if (AQI >= 101 && AQI <= 150) {
            return "#FFA500";
        } else if (AQI >= 151 && AQI <= 200) {
            return "#FF0000";
        } else if (AQI >= 201 && AQI <= 300) {
            return "#CD1076";
        } else {
            return "#8B0000";
        }
    }

    public int addCity(City city) {

        city.setAql(AQI2AQL(city.getAqi()));
        city.setAqc(AQI2AQC(city.getAqi()));

        int updateRow = curCity.addCity(city);

        if (updateRow == 0) {
            return 0;
        }

        int result = curDao.updateProvinceByCity(city);

        Province province = curProvince.selectProvince(city.getProvinceId());
        affectedProvince.updateProvince(province);

        return result;
    }

    public int deleteCity(String name) {

        int id = curCity.getIdByName(name);

        City city = curCity.selectCity(id);

        int updateRow = curCity.deleteCity(id);

        if (updateRow == 0) {
            return 0;
        }


        int result = curDao.updateProvinceByCity(city);

        Province province = curProvince.selectProvince(city.getProvinceId());
        affectedProvince.updateProvince(province);

        return result;
    }

    public int updateCity(City city) {

        city.setAql(AQI2AQL(city.getAqi()));
        city.setAqc(AQI2AQC(city.getAqi()));

        int updateRow = curCity.updateCity(city);

        if (updateRow == 0) {
            return 0;
        }

        int result = curDao.updateProvinceByCity(city);

        Province province = curProvince.selectProvince(city.getProvinceId());
        affectedProvince.updateProvince(province);

        return result;
    }

    public City selectCity(String name) {

        int id = curCity.getIdByName(name);

        return curCity.selectCity(id);
    }

    public List<City> selectAllCity() {

        return curCity.selectAllCity();
    }

    public List<City> selectAllCityDesc() {

        return curCity.selectAllCityDesc();
    }

//    public static void main(String[] args) {
//
//        CityService testCity = new CityService();
//        List<City> list = testCity.selectAllCity();
//        System.out.println(list.toString());
//    }
}
