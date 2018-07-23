package com.spring.security.security;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


/**
 * Extends the baseline Spring Security JdbcDaoImpl and implements change password functionality.
 *
 * Used in Chapter 4 example of customizing JdbcDaoImpl.
 *
 * @author Mularien
 */
public class CustomJdbcDaoImpl extends JdbcDaoImpl implements ChangePassword {
	private static final Logger logger = LoggerFactory.getLogger(CustomJdbcDaoImpl.class);
	
	@Override
	public void changePassword(String username, String password) {
		logger.debug("username: " + username + " password:" + password); 
		String encodedPassword = new BCryptPasswordEncoder(10).encode(password);
		getJdbcTemplate().update("UPDATE USERS SET PASSWORD = ? WHERE USERNAME = ?", encodedPassword, username);
	}

	@Override
	protected UserDetails createUserDetails(String username, UserDetails userFromUserQuery, List<GrantedAuthority> combinedAuthorities) {
        logger.debug("username: " + username + ", userFromUserQuery: " + userFromUserQuery.getPassword() + ", combinedAuthorities: " + combinedAuthorities.toString());
		String returnUsername = userFromUserQuery.getUsername();

        if (!isUsernameBasedPrimaryKey()) {
            returnUsername = username;
        }

        return new User(returnUsername, userFromUserQuery.getPassword(), userFromUserQuery.isEnabled(), true, true, true, combinedAuthorities);
	}

	@Override
	protected List<UserDetails> loadUsersByUsername(String username) {
        return getJdbcTemplate().query(getUsersByUsernameQuery(), new String[] {username}, new RowMapper<UserDetails>() {
            public UserDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
                String username = rs.getString(1);
                String password = rs.getString(2);
                boolean enabled = rs.getBoolean(3);
                logger.debug("username: " + username + ", password: " + password + ", enabled: " + enabled + "AuthorityUtils.NO_AUTHORITIES: " + AuthorityUtils.NO_AUTHORITIES);
                return new User(username, password, enabled, true, true, true, AuthorityUtils.NO_AUTHORITIES);
            }
        });
	}
}
