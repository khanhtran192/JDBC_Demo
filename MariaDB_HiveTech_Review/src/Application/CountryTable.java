/**
 * Dinh nghia khai bao doi tuong CountryTable
 * java 12
 * @version25/9/2021
 * * @author Tran Duy Khanh
 */
package Application;

public class CountryTable {
    String country_id;
    String name;
    String area;
    String national_day;
    String country_code2;
    String country_code3;
    String region_id;

    public String getRegion_id() {
        return region_id;
    }

    public void setRegion_id(String region_id) {
        this.region_id = region_id;
    }

    public String getCountry_code3() {
        return country_code3;
    }

    public void setCountry_code3(String country_code3) {
        this.country_code3 = country_code3;
    }

    public String getCountry_code2() {
        return country_code2;
    }

    public void setCountry_code2(String country_code2) {
        this.country_code2 = country_code2;
    }

    public String getNational_day() {
        return national_day;
    }

    public void setNational_day(String national_day) {
        this.national_day = national_day;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry_id() {
        return country_id;
    }

    public void setCountry_id(String country_id) {
        this.country_id = country_id;
    }
}
