package com.envmonitor.Dao;

import com.envmonitor.Entity.City;
import com.envmonitor.Entity.Province;
import com.envmonitor.Utils.DBCPUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProvinceAndCityDao {

    private DataSource dataSource = DBCPUtils.getDatasource();

    private QueryRunner qr = new QueryRunner(dataSource);

    public int updateProvinceByCity(City city) {

        int affected_rows = 0;

        long provinceId = city.getProvinceId();

        String sql = "select * from City where provinceid=?";

        Object[] params = {provinceId};

        try {
            ArrayList<City> result = (ArrayList<City>) qr.query(sql, new BeanListHandler<City>(City.class), params);

            long aqiSum = 0;

            for (City c : result) {
                aqiSum += c.getAqi();
            }

            long updateAqi = result.size() == 0 ? 0 : aqiSum / result.size();

            String sql2 = "update Province set AQI=? where id=?";

            Object[] params2 = {updateAqi, provinceId};

            try {
                affected_rows = qr.update(sql2, params2);
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return affected_rows;
    }

}
