/**
 *
 */
package com.spring.security.security;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Secures the database by updating user passwords.
 *
 */
public class DatabasePasswordSecurerBean extends JdbcDaoSupport {
	private final static Logger logger = LoggerFactory.getLogger(DatabasePasswordSecurerBean.class);

	public void secureDatabase() {
		getJdbcTemplate().query("SELECT username, password FROM users", new RowCallbackHandler(){
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				String username = rs.getString(1);
				String password = rs.getString(2);
				String encodedPassword = new BCryptPasswordEncoder(10).encode(password);
				getJdbcTemplate().update("update users set password = ? where username = ?", encodedPassword, username);
				logger.debug("Updating password for username: "+username+" to: "+encodedPassword);
			}
		});
	}
}
