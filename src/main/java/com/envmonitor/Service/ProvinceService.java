package com.envmonitor.Service;

import com.envmonitor.Dao.ProvinceDao;
import com.envmonitor.Entity.Province;

import java.util.ArrayList;
import java.util.List;

public class ProvinceService {

    private ProvinceDao curProvince = new ProvinceDao();

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

    public int addProvince(Province province) {

        province.setAql(AQI2AQL(province.getAqi()));
        province.setAqc(AQI2AQC(province.getAqi()));

        return curProvince.addProvince(province);
    }

    public int deleteProvince(String name) {

        int id = curProvince.getIdByName(name);

        return curProvince.deleteProvince(id);
    }

    public int updateProvince(Province province) {

        province.setAql(AQI2AQL(province.getAqi()));
        province.setAqc(AQI2AQC(province.getAqi()));

        return curProvince.updateProvince(province);
    }

    public Province selectProvince(String name) {

        int id = curProvince.getIdByName(name);

        return curProvince.selectProvince(id);
    }

    public List<Province> selectAllProvince() {

        return curProvince.selectAllProvince();
    }


//    public static void main(String[] args) {
//
//        ProvinceService testProvince = new ProvinceService();
//
//        ArrayList<Province> list = testProvince.selectAllProvince();
//
//        for (Province p : list) {
//            System.out.println(p);
//        }
// //        System.out.println(testProvince.selectProvince("山东"));
//    }
}
