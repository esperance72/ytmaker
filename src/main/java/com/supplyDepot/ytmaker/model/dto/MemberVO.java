package com.supplyDepot.ytmaker.model.dto;

import java.sql.Date;

public class MemberVO {
	private String userId;
	private String userPw;
	private String userName;
	private Date lastLogin;
	
	// GET 함수
	public String getUserId() 		{	return userId;			}
	public String getUserPw() 		{	return userPw;			}
	public String getUserName() 	{	return userName;		}
	public Date getLastLogin()	 	{	return lastLogin;		}

	// SET 함수
	public void setUserId(String userId) 			{	this.userId = userId;					}
	public void setUserPw(String userPw) 			{	this.userPw = userPw;					}
	public void setUserName(String userName) 		{	this.userName = userName;				}
	public void setLastLogin(Date lastLogin)	 	{	this.lastLogin = lastLogin;			}
	
	@Override
	public String toString() {
		return "MemberVO [userId=" + userId + "userPw=" + userPw + "userName=" + userName + "lastLogin=" + lastLogin + "]";
	}
}
