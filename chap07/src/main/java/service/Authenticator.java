package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import errors.AuthenticationException;
import net.madvirus.spring4.chap07.auth.Auth;
import net.madvirus.spring4.chap08.member.MemberInfo;
@Component
public class Authenticator {
	//bean으로 이미 설정이 되어 있다.
	@Autowired
	private MemberService memberService;
	public Authenticator(MemberService memberService){
		this.memberService = memberService;
	}
	//default생성자를 만들어 줘야 함
	public Authenticator(){
		
	}

	public Auth authenticate(String email, String password){
		MemberInfo mi = memberService.getMemberInfoByEmail(email);
		if(mi==null)
			throw new AuthenticationException();
		if(!mi.matchPassword(password))
			throw new AuthenticationException();
		return new Auth(mi.getId(), mi.getName());
	}

}
