package tw.ELS.model;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.ELS.member.model.Member;
import tw.ELS.member.model.MemberService;

@Service
@Transactional
public class AuthUserDetailsService implements UserDetailsService {

	@Autowired
	private MemberService mService;
	
	@Override
	public UserDetails loadUserByUsername(String account) throws UsernameNotFoundException {
		Member mem = mService.findByAccount(account);
		return new User(mem.getAccount(),mem.getmPassword(),Collections.emptyList());
	}

}
