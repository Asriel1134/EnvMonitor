package com.envmonitor.Entity;


public class Province {

    private long id;
    private String name;
    private long aqi;
    private String aql;
    private String aqc;

    public Province() {

    }

    public Province(long id, String name, long aqi, String aql, String aqc) {
        this.id = id;
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
        return "Province{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", aqi=" + aqi +
                ", aql='" + aql + '\'' +
                ", aqc='" + aqc + '\'' +
                '}';
    }
}