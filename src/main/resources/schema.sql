DROP TABLE IF EXISTS user_tbl;

CREATE TABLE user_tbl (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  customer_name VARCHAR(100) NOT NULL,
  email VARCHAR(50) NOT NULL,
  user_password VARCHAR(50),
  dateCreate Date DEFAULT CURRENT_DATE,
  dateModif Date DEFAULT CURRENT_DATE,
  isActive INT DEFAULT 0 
);

DROP TABLE IF EXISTS phone_tbl;

CREATE TABLE phone_tbl (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  id_user INT  NOT NULL,
  phone_number INT NOT NULL,
  city_code INT NOT NULL,
  contry_code INT DEFAULT NULL,

  foreign key (id_user) references user_tbl(id)
  
);

