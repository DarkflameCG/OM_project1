package com.czp.project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.czp.project.common.bean.Account;
import com.czp.project.common.bean.extend.AccountEX;
import com.czp.project.common.bean.extend.CostEX;
import com.czp.project.dao.ex.AccountEXMapper;
import com.czp.project.service.interfaces.AccountService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Service
public class AccountServiceImpl implements AccountService{
@Autowired
private AccountEXMapper accountEXMapper;
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
	public PageInfo<AccountEX> findAllAccountForPages(int currpage, int row) {
		PageHelper.startPage(currpage, row);
		List<AccountEX> list = accountEXMapper.findAllAccountEX();
		PageInfo<AccountEX> pi = new PageInfo<AccountEX>(list);
		return pi;
	}

}
