package com.demo.bci.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Repository;

import com.demo.bci.dao.CustomerRepository;
import com.demo.bci.entity.*;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

	@Autowired
	JdbcTemplate jdbctemplate;

	InsertEntity insertEntity = new InsertEntity();
	boolean update;

	static final String SELECT_WHERE_ID = "select * from USER_TBL where id=?";
	static final String INSERT_USER_TBL = "insert into USER_TBL ( CUSTOMER_NAME , EMAIL , USER_PASSWORD ) values(?, ?, ?)";
	static final String INSERT_PHONE_TBL = "insert into PHONE_TBL ( ID_USER , PHONE_NUMBER , CONTRY_CODE , CITY_CODE ) values(?, ?, ?, ?)";
	static final String VALIDATE_USER_EMAIL = "SELECT COUNT(*) FROM USER_TBL where email = ?";
	static final String VALIDATE_USER_ID = "SELECT COUNT(*) FROM USER_TBL where ID = ?";
	static final String UPDATE_USER = "update USER_TBL set CUSTOMER_NAME = ?, USER_PASSWORD = ?, ISACTIVE  = ?, DATEMODIF  = CURRENT_DATE where ID = ?";

// SELECT BY ID
	@SuppressWarnings("deprecation")
	public InsertEntity findById(long id) {

		insertEntity = jdbctemplate.queryForObject(SELECT_WHERE_ID, new Object[] { id },
				new BeanPropertyRowMapper<InsertEntity>(InsertEntity.class));
		return insertEntity;
	}

// INSERT
	@Override
	public InsertEntity insert(EntityUser table) {

		if (validateUserMail(table.getEmail()) != 0) {
			insertEntity.setEmail("USER_EXIST");
			return insertEntity;
		}

		PreparedStatement stmt = null;
		PreparedStatement stmtPhone = null;
		Connection conn = DataSourceUtils.getConnection(this.jdbctemplate.getDataSource());
		Integer key = 0;
		try {
			stmt = conn.prepareStatement(INSERT_USER_TBL, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, table.getName());
			stmt.setString(2, table.getEmail());
			stmt.setString(3, table.getPassword());
			stmt.executeUpdate();

			ResultSet rs2 = stmt.getGeneratedKeys();
			rs2.next();
			key = rs2.getInt(1);
			insertEntity.setId(key.toString());
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

		for (int i = 0; i < table.getPhones().size(); i++) {
			try {
				stmtPhone = conn.prepareStatement(INSERT_PHONE_TBL);
				stmtPhone.setLong(1, key);
				stmtPhone.setLong(2, table.getPhones().get(i).getNumber());
				stmtPhone.setInt(3, table.getPhones().get(i).getContrycode());
				stmtPhone.setInt(4, table.getPhones().get(i).getCitycode());
				stmtPhone.executeUpdate();
			} catch (Exception f) {
				f.printStackTrace();
			}
		}
		insertEntity = findById(key);

		return insertEntity;
	}

// UPDATE
	public boolean updateRecord(EntityUpdate table) {

		if (validateUserID(table.getId()) <= 0) {
			update = false;
			return update;
		}

		PreparedStatement stmt = null;
		PreparedStatement stmtPhone = null;
		Connection conn = DataSourceUtils.getConnection(this.jdbctemplate.getDataSource());
		Integer key = 0;
		try {
			stmt = conn.prepareStatement(UPDATE_USER);
			stmt.setString(1, table.getName());
			stmt.setString(2, table.getPassword());
			stmt.setInt(3, table.getIsActive());
			stmt.setLong(4, table.getId());
			stmt.executeUpdate();

			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		update = true;
		return update;
	}

// VALIDATE USER BY EMAIL
	public int validateUserMail(String email) {
		int records = 0;

		Connection conn = DataSourceUtils.getConnection(this.jdbctemplate.getDataSource());
		try {
			PreparedStatement prest = conn.prepareStatement(VALIDATE_USER_EMAIL);
			prest.setString(1, email);
			ResultSet rs = prest.executeQuery();
			while (rs.next()) {
				records = rs.getInt(1);
			}
			System.out.println("Number of records: " + records);
			if (records > 0) {
				System.out.println("Ya existe el usuario con mail  " + email);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return records;
	}

	// VALIDATE BY USER ID
	public int validateUserID(long id) {
		int records = 0;

		Connection conn = DataSourceUtils.getConnection(this.jdbctemplate.getDataSource());
		try {
			PreparedStatement prest = conn.prepareStatement(VALIDATE_USER_ID);
			prest.setLong(1, id);
			ResultSet rs = prest.executeQuery();
			while (rs.next()) {
				records = rs.getInt(1);
			}
			System.out.println("Number of records: " + records);
			if (records > 0) {
				System.out.println("Ya existe el usuario con id  " + id);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return records;
	}

}
