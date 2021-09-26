/**
 * cac ham chuc nang menu, insert, update, delete, select, show countries table
 và show languages table
 * java 12
 * @version 1.0
 * 25/9/2021
 * * @author Tran Duy Khanh
 */
package Application;

import jdbc_config.JDBCConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class ControllerJDBC {
    static Input input = new Input();
    static JDBCConnection jdbc_cnt = new JDBCConnection();
    static boolean isNotExit = true;
    static List<LanguageTable> langguage_table = new ArrayList<>();
    static List<CountryTable> country_table = new ArrayList<>();

    public void menu() throws SQLException, ClassNotFoundException {
        System.out.println("1. Insert");
        System.out.println("2. Update");
        System.out.println("3. Delete");
        System.out.println("4. Select");
        System.out.println("5. Exit");

        System.out.println("Nhap so");
        int seleted = input.inputScannerInt();
        switch (seleted) {
            case 1:
                insert();
                break;
            case 2:
                update();
                break;
            case 3:
                delete();
                break;
            case 4:
                select();
                break;
            case 5:
                isNotExit = false;
                break;
        }
    }

    private void insert() {
        try {
            Connection connection = jdbc_cnt.getConnect();
            Statement statement = connection.createStatement();
            System.out.println("Chon bang(1:language/2country)");
            int select = input.inputScannerInt();
            if (select == 1) {
                System.out.println("Bang language");
                showLanguageTable();
                //Nhap thong tin
                int id = input.languageId();
                String language = input.language();
                //Truy van SQL
                String sql = "Insert into languages (language_id, language) values ('" + id + "','" + language + "')";
                int rs = statement.executeUpdate(sql);
                System.out.println(rs);
                connection.close();
                //Ket qua
                System.out.println("Bang language sau update");
                showLanguageTable();
            } else {
                System.out.println("Bang countries");
                showCountryTable();
                //Nhap thong tin
                int country_id = input.countryId();
                String country_name = input.countryName();
                int country_area = input.countryArea();
                String country_date = input.countryDate();
                String country_code2 = input.countryCode2();
                String country_code3 = input.countryCode3();
                int region_id = input.regionId();
                //Truy van SQL
                String sql = "Insert into countries (country_id, name, area, national_day, country_code2, country_code3," +
                        " region_id) values " +
                        "('" + country_id + "','" + country_name + "','" + country_area + "','" + country_date + "','" +
                        country_code2 + "','" + "" + country_code3 + "','" + region_id + "')";
                int rs = statement.executeUpdate(sql);
                System.out.println(rs);
                connection.close();
                //Ket qua
                System.out.println("Bang countries sau update");
                showCountryTable();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void update() {
        try {
            Connection connection = jdbc_cnt.getConnect();
            Statement statement = connection.createStatement();

            System.out.println("Chon bang(1:language/2:country)");
            int select = input.inputScannerInt();
            if (select == 1) {
                System.out.println("Bang language");
                showLanguageTable();
                //Nhap thong tin
                System.out.println("Nhap ID can update:");
                int id = input.inputScannerInt();
                String language = input.language();
                //Truy van SQL
                String sql = "Update languages set language = '" + language + "' where language_id = '" + id + "'";
                int rs = statement.executeUpdate(sql);
                System.out.println(rs);
                connection.close();
                //Ket qua
                System.out.println("Bang language sau update");
                showLanguageTable();
            } else {
                System.out.println("Bang countries");
                showCountryTable();
                //Nhap thong tin
                System.out.println("Nhap ID can update:");
                int id = input.inputScannerInt();
                String country_name = input.countryName();
                int country_area = input.countryArea();
                String country_date = input.countryDate();
                String country_code2 = input.countryCode2();
                String country_code3 = input.countryCode3();
                int region_id = input.regionId();
                //Truy van SQL
                String sql = "Update countries set name = '" + country_name + "', area ='" + country_area + "', national_day = '" +
                        "" + country_date + "', country_code2 = '" + country_code2 + "', country_code3 = '" + country_code3 + "" +
                        "', region_id = '" + region_id + "' where country_id = '" + id + "'";
                int rs = statement.executeUpdate(sql);
                System.out.println(rs);
                connection.close();
                //Ket qua
                System.out.println("Bang countries sau update");
                showCountryTable();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void delete() {
        try {
            Connection connection = jdbc_cnt.getConnect();
            Statement statement = connection.createStatement();

            System.out.println("Chon bang(1:language/2:country)");
            int select = input.inputScannerInt();
            if (select == 1) {
                System.out.println("Bang language");
                showLanguageTable();
                //Nhap thong tin
                System.out.println("Nhap ID muon xoa: ");
                int id = input.inputScannerInt();
                //Truy van SQL
                String sql = "DELETE FROM languages WHERE language_id = '" + id + "'";
                int rs = statement.executeUpdate(sql);
                System.out.println(rs);
                connection.close();
                //Ket qua
                System.out.println("Bang language sau delete");
                showLanguageTable();
            } else {
                System.out.println("Bang countries");
                showCountryTable();
                //Nhap thong tin
                System.out.println("Nhap ID muon xoa: ");
                int id = input.inputScannerInt();
                //Truy van SQL
                String sql = "DELETE FROM countries WHERE country_id = '" + id + "'";
                int rs = statement.executeUpdate(sql);
                System.out.println(rs);
                connection.close();
                //Ket qua
                System.out.println("Bang countries sau delete");
                showCountryTable();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void select() {
        try {
            Connection connection = jdbc_cnt.getConnect();
            Statement statement = connection.createStatement();

            System.out.println("Chon bang(1:language/2:country)");
            int select = input.inputScannerInt();
            if (select == 1) {
                System.out.println("Bang language");
                showLanguageTable();
                //Nhap thong tin
                System.out.println("Nhap ID muon tra ra: ");
                int id = input.inputScannerInt();
                //Truy van SQL
                String sql = "SELECT * FROM languages where language_id = " + id + "";
                ResultSet resultSet = statement.executeQuery(sql);
                while (resultSet.next()) {
                    // Lấy dữ liệu từ ResultSet
                    LanguageTable langtable = new LanguageTable();
                    langtable.setLanguage_id(resultSet.getString(1));
                    langtable.setLanguage(resultSet.getString(2));
                    //Ket qua
                    System.out.println("-------------------------------------");
                    System.out.printf("%10s %20s", "LANGUAGE ID", "LANGUAGE");
                    System.out.println();
                    System.out.println("-------------------------------------");

                    System.out.format("%10s %20s", langtable.getLanguage_id(), langtable.getLanguage());
                    System.out.println();
                    System.out.println("-------------------------------------");
                    connection.close();
                }
            } else {
                System.out.println("Bang countries");
                showCountryTable();
                //Nhap thong tin
                System.out.println("Nhap ID muon lay : ");
                int id = input.inputScannerInt();
                //Truy van SQL
                String sql = "SELECT * FROM countries where country_id = " + id + "";
                ResultSet resultSet = statement.executeQuery(sql);
                while (resultSet.next()) {
                    // Lấy dữ liệu từ ResultSet
                    CountryTable counTable = new CountryTable();
                    counTable.setCountry_id(resultSet.getString(1));
                    counTable.setName(resultSet.getString(2));
                    counTable.setArea(resultSet.getString(3));
                    counTable.setNational_day(resultSet.getString(4));
                    counTable.setCountry_code2(resultSet.getString(5));
                    counTable.setCountry_code3(resultSet.getString(6));
                    counTable.setRegion_id(resultSet.getString(7));
                    //Ket qua
                    System.out.println("----------------------------------------------------------------------------------------" +
                            "----------");
                    System.out.printf("%5s %10s %10s %15s %15s %15s %15s", "COUNTRY ID", "NAME", "AREA", "DATE", "CODE_2",
                            "CODE_3", "REGION ID");
                    System.out.println();
                    System.out.println("----------------------------------------------------------------------------------------" +
                            "----------");
                    System.out.format("%5s %12s %12s %20s %12s %12s %12s ", counTable.getCountry_id(), counTable.getName(),
                            counTable.getArea(), counTable.getNational_day(), counTable.getCountry_code2(),
                            counTable.getCountry_code3(), counTable.getRegion_id());
                    System.out.println();
                    System.out.println("----------------------------------------------------------------------------------------" +
                            "----------");
                    connection.close();
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void showLanguageTable() {
        try {
            Connection connection = jdbc_cnt.getConnect();
            Statement statement = connection.createStatement();
            //Truy van SQL
            String sql = "Select * from languages";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                // Lấy dữ liệu từ ResultSet
                LanguageTable langtable = new LanguageTable();
                langtable.setLanguage_id(resultSet.getString(1));
                langtable.setLanguage(resultSet.getString(2));
                langguage_table.add(langtable);
            }
            System.out.println("-------------------------------------");
            System.out.printf("%10s %20s", "LANGUAGE ID", "LANGUAGE");
            System.out.println();
            System.out.println("-------------------------------------");

//            for (LanguageTable languagetable : langguage_table) {
//                System.out.format("%10s %20s", languagetable.getLanguage_id(), languagetable.getLanguage());
//                System.out.println();
//            }
            for(int i = 0; i<langguage_table.size(); i++){
                System.out.format("%10s %20s", langguage_table.get(i).getLanguage_id(), langguage_table.get(i).getLanguage());
                System.out.println();
            }
            System.out.println("-------------------------------------");
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void showCountryTable() {
        try {
            Connection connection = jdbc_cnt.getConnect();
            Statement statement = connection.createStatement();
            //Truy van SQL
            String sql = "Select * from countries";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                // Lấy dữ liệu từ ResultSet
                CountryTable counTable = new CountryTable();
                counTable.setCountry_id(resultSet.getString(1));
                counTable.setName(resultSet.getString(2));
                counTable.setArea(resultSet.getString(3));
                counTable.setNational_day(resultSet.getString(4));
                counTable.setCountry_code2(resultSet.getString(5));
                counTable.setCountry_code3(resultSet.getString(6));
                counTable.setRegion_id(resultSet.getString(7));
                country_table.add(counTable);
            }
            System.out.println("----------------------------------------------------------------------------------------" +
                    "----------");
            System.out.printf("%5s %10s %10s %15s %15s %15s %15s", "COUNTRY ID", "NAME", "AREA", "DATE", "CODE_2",
                    "CODE_3", "REGION ID");
            System.out.println();
            System.out.println("----------------------------------------------------------------------------------------" +
                    "----------");
            for (CountryTable countable : country_table) {
                System.out.format("%5s %12s %12s %20s %12s %12s %12s ", countable.getCountry_id(), countable.getName(),
                        countable.getArea(), countable.getNational_day(), countable.getCountry_code2(),
                        countable.getCountry_code3(), countable.getRegion_id());
                System.out.println();
            }
            System.out.println("----------------------------------------------------------------------------------------" +
                    "----------");
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
