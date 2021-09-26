/**
 * tao ra cac ham nhap cho CountryTable, LanguageTable
 * java 12
 * @version 1.0
 * 25/9/2021
 * * @author Tran Duy Khanh
 */
package Application;

import java.util.Scanner;

public class Input extends ExceptionInput{
    static Scanner keyboard = new Scanner(System.in);
    //languages
    public int languageId(){
        System.out.println("Nhap ID: ");
        int language_id = inputScannerInt();
        return language_id;
    }
    public String language(){
        System.out.println("Nhap language: ");
        String language = inputScannerString();
        return language;
    }
    //contries
    public int countryId(){
        System.out.println("Nhap ID: ");
        int country_id = inputScannerInt();
        return country_id;
    }
    public String countryName(){
        System.out.println("Nhap ten nuoc : ");
        String country_name = inputScannerString();
        return country_name;
    }
    public int countryArea(){
        System.out.println("Nhap area: ");
        int country_area = inputScannerInt();
        return country_area;
    }
    public String countryDate(){
        System.out.println("Nhap country date(y-m-d): ");
        String country_date = inputScannerString();
        return country_date;
    }
    public String countryCode2(){
        System.out.println("Nhap country code 2: ");
        String country_code2 = inputScannerString();
        return country_code2;
    }
    public String countryCode3(){
        System.out.println("Nhap country code 3: ");
        String country_code3 = inputScannerString();
        return country_code3;
    }
    public int regionId(){
        System.out.println("Nhap region ID: ");
        int region_id = inputScannerInt();
        return region_id;
    }

}

