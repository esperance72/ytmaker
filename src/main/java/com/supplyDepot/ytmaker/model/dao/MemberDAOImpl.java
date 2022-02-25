package com.supplyDepot.ytmaker.model.dao;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import  com.supplyDepot.ytmaker.model.dto.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {
	// SqlSession 객체를 스프링에서 생성하여 주입
	// 의존관계 주입 (Dependency Injection), 느슨한 결합
	@Inject
	SqlSession sqlSession;
	
	// 1-1. 회원 로그인 체크
	@Override
	public boolean loginCheck(MemberVO vo) {
		String name = sqlSession.selectOne("member.loginCheck", vo);
		
		return (name == null) ? false : true;
	}
	
	// 1-2. 회원 로그인 정보
	@Override
	public MemberVO viewMember(MemberVO vo) {
		return sqlSession.selectOne("member.viewMember", vo);
	}
	
	// 2. 회원 로그아웃
	public void logout(HttpSession session) {
	}
}
