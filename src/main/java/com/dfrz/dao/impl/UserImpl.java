package com.dfrz.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.dfrz.beans.User;
import com.dfrz.dao.UserDao;

public class UserImpl implements UserDao{
	public List<User> data;
	public UserImpl() {
		data = new ArrayList<User>();
		data.add(new User(1,"hua1","1234561"));
		data.add(new User(2,"hua2","1234562"));
		data.add(new User(3,"hua3","1234563"));
		data.add(new User(4,"hua4","1234564"));
		
		
	}
	public boolean login(User user) {
		boolean flag=false;
		for (User u : data) {
			if(user.getUname().equals(u.getUname())&&user.getUpass().equals(u.getUpass())){
			flag=true;
			break;
			}
		}
		return flag;
	}

}
