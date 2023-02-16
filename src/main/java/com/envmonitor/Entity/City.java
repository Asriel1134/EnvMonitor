package com.envmonitor.Entity;


public class City {

    private long id;
    private long provinceId;
    private String name;
    private long aqi;
    private String aql;
    private String aqc;

    public City() {

    }

    public City(long id, long provinceId, String name, long aqi, String aql, String aqc) {
        this.id = id;
        this.provinceId = provinceId;
        this.name = name;
        this.aqi = aqi;
        this.aql = aql;
        this.aqc = aqc;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public long getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(long provinceId) {
        this.provinceId = provinceId;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public long getAqi() {
        return aqi;
    }

    public void setAqi(long aqi) {
        this.aqi = aqi;
    }


    public String getAql() {
        return aql;
    }

    public void setAql(String aql) {
        this.aql = aql;
    }


    public String getAqc() {
        return aqc;
    }

    public void setAqc(String aqc) {
        this.aqc = aqc;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", provinceId=" + provinceId +
                ", name='" + name + '\'' +
                ", aqi=" + aqi +
                ", aql='" + aql + '\'' +
                ", aqc='" + aqc + '\'' +
                '}';
    }
}