package com.czp.project.service.interfaces;

import java.util.List;

import com.czp.project.common.bean.Account;
import com.czp.project.common.bean.extend.AccountEX;
import com.czp.project.common.bean.extend.CostEX;
import com.github.pagehelper.PageInfo;

/**
 * 账户操作的接口
 * @author mastercgx
 *
 */
public interface AccountService {
	/**
	 * 添加账户
	 * @param account
	 */
	public void addAccount(Account account);
	/**
	 * 查询账户
	 * @param account
	 */
	public Account findByIdAccount(int id);
	/**
	 * 查询账户
	 * @param account
	 */
	public Account findByOldIdAccount(int oldId);
	/**
	 * 通过id删除账户
	 * @param id
	 */
	public void removeAccountById(int id);
	/**
	 * 批量删除账户
	 * @param ids
	 */
	public void removeAccountByIds(String[] ids);
	/**
	 * 修改账户信息
	 * @param account
	 */
	public void editAccount(Account account);

	/**
	 * 查询全部，不带分页
	 * @return
	 */
	public List<Account> findAllAccount();
	/**
	 * 分页查询账户信息
	 * @param currpage
	 * @param row
	 * @return 
	 */
	public PageInfo<AccountEX> findAllAccountForPages(int currpage , int row);
	public PageInfo<AccountEX> findAllByName(int currpage, int row, String source);
	
}
