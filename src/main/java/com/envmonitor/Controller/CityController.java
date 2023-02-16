package com.envmonitor.Controller;

import com.envmonitor.Entity.City;
import com.envmonitor.Entity.Init;
import com.envmonitor.Entity.Province;
import com.envmonitor.Service.CityService;
import com.envmonitor.Service.ProvinceService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Asriel
 * @date 2023 02 16 18 29
 */
@RestController
@CrossOrigin
public class CityController {
    CityService cityService = new CityService();
    ProvinceService provinceService = new ProvinceService();

    @GetMapping("/Init")
    public Init init(){
        Init init = new Init();
        init.setProvince(provinceService.selectAllProvince());
        init.setCity(cityService.selectAllCity());
        return init;
    }

    @GetMapping("/City")
    public List<City> getCityList() {
        return cityService.selectAllCity();
    }

    @GetMapping("/CityDesc")
    public List<City> getCityListDesc() {
        return cityService.selectAllCityDesc();
    }

    @PostMapping("/Delete")
    public boolean delete(String province, String city) {
        return !Objects.equals(province, "") && !Objects.equals(city, "");
    }

    @PostMapping("/Edit")
    public boolean edit(String province, String city, long AQI) {
        return !Objects.equals(province, "") && !Objects.equals(city, "") && AQI != 0;
    }

    @PostMapping("/Add")
    public boolean add(String province, String city, long AQI) {
        return !Objects.equals(province, "") && !Objects.equals(city, "") && AQI != 0;
    }
}