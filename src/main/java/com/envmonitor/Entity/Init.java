package com.envmonitor.Entity;

import java.util.List;

/**
 * @author Asriel
 * @date 2023 02 17 00 12
 */

public class Init {
    private List<City> city;
    private List<Province> province;

    @Override
    public String toString() {
        return "Init{" +
                "city=" + city +
                ", province=" + province +
                '}';
    }

    public List<Province> getProvince() {
        return province;
    }

    public void setProvince(List<Province> province) {
        this.province = province;
    }

    public List<City> getCity() {
        return city;
    }

    public void setCity(List<City> city) {
        this.city = city;
    }
}
