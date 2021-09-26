CREATE DATABASE mariaBD_Demo
USE mariaBD_Demo
CREATE TABLE languages (
                           language_id INT AUTO_INCREMENT,
                           LANGUAGE VARCHAR(50) NOT NULL,
                           PRIMARY KEY (language_id)
);
CREATE TABLE continents(
                           continent_id INT AUTO_INCREMENT,
                           name VARCHAR(255) NOT NULL, PRIMARY KEY(continent_id)
);
CREATE TABLE regions(
                        region_id INT AUTO_INCREMENT,
                        name VARCHAR(100) NOT NULL,
                        continent_id INT NOT NULL,
                        PRIMARY KEY(region_id),
                        FOREIGN KEY(continent_id) REFERENCES continents(continent_id)
);
CREATE TABLE countries (
                           country_id INT AUTO_INCREMENT,
                           name VARCHAR(50) NOT NULL,
                           area DECIMAL(10,2) NOT NULL,
                           national_day DATE,
                           country_code2 CHAR(2) NOT NULL UNIQUE,
                           country_code3 CHAR(3) NOT NULL UNIQUE,
                           region_id INT NOT NULL, FOREIGN KEY(region_id) REFERENCES regions(region_id),
                           PRIMARY KEY(country_id)
);
CREATE TABLE country_stats(
                              country_id INT, YEAR INT,
                              population INT,
                              gdp DECIMAL(15,0),
                              PRIMARY KEY (country_id, YEAR),
                              FOREIGN KEY(country_id) REFERENCES countries(country_id)
);
CREATE TABLE country_languages (
                                   country_id INT,
                                   language_id INT,
                                   official BOOLEAN NOT NULL,
                                   PRIMARY KEY (country_id, language_id),
                                   FOREIGN KEY(country_id) REFERENCES countries(country_id),
                                   FOREIGN KEY(language_id) REFERENCES languages(language_id)
);