package com.interview.projects.daoClasses;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.interview.projects.modelClasses.Contact;

public class ContactDAOImpl implements ContactDAOInterface {

	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public int save(Contact contact) {
		String query = "insert into contact(name, email, address, phone) values(?, ?, ?, ?)";
		int result = template.update(query, contact.getName(), contact.getEmail(), contact.getAddress(),
				contact.getPhone());
		return result;
	}

	public boolean update(final Contact contact) {
		String query = "update contact set name = ?, email = ?, address = ?, phone = ? where contact_id = ?";
		return template.execute(query, new PreparedStatementCallback<Boolean>() {

			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setString(1, contact.getName());
				ps.setString(2, contact.getEmail());
				ps.setString(3, contact.getAddress());
				ps.setString(4, contact.getPhone());
				ps.setInt(5, contact.getContact_id());
				return ps.execute();
			}

		});
	}

	public boolean delete(final int contact_id) {
		String query = "delete from contact where contact_id = ?";
		return template.execute(query, new PreparedStatementCallback<Boolean>() {

			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setInt(1, contact_id);
				return ps.execute();
			}

		});
	}

	public Contact get(final int id) {
		String query = "select * from contact where contact_id = " + id;
		ResultSetExtractor<Contact> extractor = new ResultSetExtractor<Contact>() {

			public Contact extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
					String name = rs.getString("name");
					String email = rs.getString("email");
					String address = rs.getString("address");
					String phone = rs.getString("phone");
					return new Contact(id, name, email, address, phone);
				}
				return null;
			};
		};

		return template.query(query, extractor);
	}

	public List<Contact> list() {
		String query = "select * from contact";
		RowMapper<Contact> rowMapper = new RowMapper<Contact>() {

			public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
				Integer id = rs.getInt("contact_id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String address = rs.getString("address");
				String phone = rs.getString("phone");
				return new Contact(id, name, email, address, phone);
			}
		};
		return template.query(query, rowMapper);
	}

}
