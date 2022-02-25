package com.supplyDepot.ytmaker.dao;

import javax.inject.Inject;
import java.sql.Connection;
import java.sql.DriverManager;
import 
import org.springframework.stereotype.Repository;
//import com.example.spring02.model.member.dto.MemberDTO;
import com.supplyDepot.ytmaker.dto.MemberDTO;

@Repository // ���� Ŭ������ dao bean���� ���
public class MemberDAOImpl {
	@Inject
	SqlSession sqlSession; // SqlSession �������� ����

	@Override
	public String loginCheck(MemberDTO dto) {
		return sqlSession.selectOne("member.login_check", dto);
	}
}
