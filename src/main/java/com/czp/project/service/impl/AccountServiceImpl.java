package com.czp.project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.czp.project.common.bean.Account;
import com.czp.project.common.bean.OldMan;
import com.czp.project.common.bean.OldManExample;
import com.czp.project.common.bean.extend.AccountEX;
import com.czp.project.common.bean.extend.CostEX;
import com.czp.project.dao.AccountMapper;
import com.czp.project.dao.OldManMapper;
import com.czp.project.dao.ex.AccountEXMapper;
import com.czp.project.service.interfaces.AccountService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Service
public class AccountServiceImpl implements AccountService{
@Autowired
private AccountEXMapper accountEXMapper;
@Autowired
private AccountMapper accountMapper;
@Autowired
private OldManMapper oldamanmapper;
	@Override
	public void addAccount(Account account) {
		accountMapper.insert(account);
		
	}

	@Override
	public void removeAccountById(int id) {
		accountMapper.deleteByPrimaryKey(id);
		
	}



	@Override
	public void removeAccountByIds(String[] ids) {
		for (String str : ids) {
			accountMapper.deleteByPrimaryKey(Integer.parseInt(str));
		}
		
	}


	@Override
	public void editAccount(Account account) {
		accountMapper.updateByPrimaryKey(account);
		
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

	@Override
	public Account findByIdAccount(int id) {
		
		return accountMapper.selectByPrimaryKey(id);
	}

	@Override
	public PageInfo<AccountEX> findAllByName(int currpage, int row, String source) {
		PageHelper.startPage(currpage, row);
		OldManExample example = new OldManExample();
		example.createCriteria().andOldmanNameEqualTo(source);
		List<OldMan> list2 = oldamanmapper.selectByExample(example);
		   List<AccountEX> list = accountEXMapper.findAllAccountByOldManId(list2.get(0).getId());
		PageInfo<AccountEX> pi = new PageInfo<AccountEX>(list);
		return pi;
	}


}
