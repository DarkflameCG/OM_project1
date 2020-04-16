package com.czp.project.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.czp.project.common.bean.Account;
import com.czp.project.service.interfaces.AccountService;
import com.github.pagehelper.PageInfo;
@Service
public class AccountImpl implements AccountService{

	@Override
	public void addAccount(Account account) {
		
		
	}

	@Override
	public void removeAccountById(int id) {
		
		
	}

	@Override
	public void editAccount(Account account) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Account> findAllAccount() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageInfo<Account> findAllAccountForPages(int currpage, int row) {
		// TODO Auto-generated method stub
		return null;
	}

}
