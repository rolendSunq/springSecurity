package com.spring.security.security;

import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

public class IPRoleAuthenticationFilter extends OncePerRequestFilter {
	private String targetRole;
	private List<String> allowedIPAddresses;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {
		// 요청이 계속 진행되도록 허용하기 전에 사용자의 역활을 먼저 가져온다.
		// 그런 다음 사용자가 관리자인지 확인한다.
		final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		if (authentication != null && targetRole != null) {
			boolean shouldCheck = false;
			
			// 사용자가 대상 역활에 해당하는지 확인한다.
			for (GrantedAuthority authority : authentication.getAuthorities()) {
				
				if (authority.getAuthority().equals(targetRole)) {
					shouldCheck = true;
					break;
				}
				
				// IP 주소를 체크해야 하는 경우 IP 주소를 체크한다.
				if (shouldCheck && allowedIPAddresses.size() > 0) {
					boolean shouldAllow = false;
					
					for (String ipAddress : allowedIPAddresses) {
						if (request.getRemoteAddr().equals(ipAddress)) {
							shouldAllow = true;
							break;
						}
					}
					
					if (!shouldAllow) {
						// 요청 실패시
						throw new AccessDeniedException("Access has been denied for your IP address: " + request.getRemoteAddr());
					}
				}
			}
		} else {
			logger.warn("The IPRoleAuthenticationFilter should be placed after the user has been authenticated in the filter chain.");
		}
		
		chain.doFilter(request, response);
	}

	public String getTargetRole() {
		return targetRole;
	}

	public void setTargetRole(String targetRole) {
		this.targetRole = targetRole;
	}

	public List<String> getAllowedIPAddresses() {
		return allowedIPAddresses;
	}

	public void setAllowedIPAddresses(List<String> allowedIPAddresses) {
		this.allowedIPAddresses = allowedIPAddresses;
	}
	
}
