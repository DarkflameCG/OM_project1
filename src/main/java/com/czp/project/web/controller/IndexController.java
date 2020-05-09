package com.czp.project.web.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.czp.project.common.bean.Account;
import com.czp.project.common.bean.BasePower;
import com.czp.project.common.bean.BaseUser;
import com.czp.project.common.bean.Charges;
import com.czp.project.common.bean.Cost;
import com.czp.project.common.bean.OldMan;
import com.czp.project.common.bean.extend.AccountEX;
import com.czp.project.common.bean.extend.CostEX;
import com.czp.project.common.bean.extend.OldManExtend;
import com.czp.project.common.bean.extend.UserLeaveEX;
import com.czp.project.service.impl.IndexImpl;
import com.czp.project.service.impl.OldManMsgImpl;
import com.czp.project.service.interfaces.AccountService;
import com.czp.project.service.interfaces.CostService;
import com.czp.project.service.interfaces.IndexService;
import com.czp.project.utils.DateAndStringUtil;
import com.github.pagehelper.PageInfo;
/**
 * 收费设置
 * @author mastercgx
 *
 */
@Controller
@RequestMapping("/index")
public class IndexController {
	@Autowired
	private IndexService indexImpl;
	@Autowired
	private CostService costService;
	@Autowired
	private OldManMsgImpl oldimpl;
	@Autowired
	private AccountService accountService;
	 @RequestMapping("/finance/{page}")
		public String getIndex(HttpSession session,
								  @PathVariable String page) throws NumberFormatException, Exception {
		   
		 //分页收费信息
		 PageInfo<Charges> info = indexImpl.findAllForPage(Integer.parseInt(page), 6);
		  session.setAttribute("indexs", info); 
		 
			return "pages/moneySetting";
		}
	//批量或单个删除
	   @RequestMapping("/deleteIndex")
	   @ResponseBody
     public String deleteIndex(@RequestParam String id) {
		  
		   try {
			   String[] d=null;
			   if(id.contains(",")) {
				  
					//批量删除
				   d=id.split(",");//把数组里的值逗号隔开
				   indexImpl.removeIndexByIds(d);
				}else {		
					indexImpl.removeIndexById(Integer.parseInt(id));
				}
				   return "ok";
			  
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "ok";
		}
					
     }
	 //添加收费项
	   @RequestMapping("/addIndex")
	   @ResponseBody
       public String addIndex(HttpServletRequest req,HttpSession session,Charges charges) {
		   try {
			indexImpl.addIndex(charges);
			 return "ok";
		} catch (Exception e) {
			return "error";
		}
		  
	   }
	   //搜索
	   @RequestMapping("/search/{page}")
		public String search(HttpSession session,String source,@PathVariable String page) throws NumberFormatException, Exception {
		   //分页搜索信息
		   PageInfo<Charges> info =indexImpl.findAllByName(Integer.parseInt(page), 6, source);
			  session.setAttribute("indexs", info); 
			return "pages/moneySetting";
		}
	 //获取缴费记录
		@RequestMapping("/cost/{page}")
	    public String selectCost(HttpSession session,
				  @PathVariable String page) {
			List<Charges> list = indexImpl.findAll();
			session.setAttribute("list", list);
			//分页员工信息
			  try {
				PageInfo<CostEX> info =
						costService.findAllForPage(Integer.parseInt(page), 6);
				  session.setAttribute("costs", info);
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	  	  return "pages/moneyLog";
	    }

//批量或单个删除
   @RequestMapping("/removeCost")
   @ResponseBody
public String removeAttendance(@RequestParam String id) {
	  
	   try {
		   String[] d=null;
		   if(id.contains(",")) {
			  
				//批量删除
			   d=id.split(",");//把数组里的值逗号隔开
			   costService.removeCostByIds(d);
			}else {		
				costService.removeCostById(Integer.parseInt(id));
			}
			   return "ok";
		  
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return "ok";
	}
	  
}	
   //添加缴费
   @RequestMapping("/addCost")
   @ResponseBody
   public String addCost(HttpServletRequest req,HttpSession session,String oldManName,int indexId,String payType) {
	   //如果选择的是充值卡则从account中扣掉对应老人的钱
	  List<OldMan> list = oldimpl.selectMsgByString(oldManName);
	  Cost cost=new Cost();
	  cost.setPayType(payType);
	  cost.setIndexId(indexId);
	  cost.setOldmanId(list.get(0).getId());
	  cost.setPayTime(new Date());
	  BaseUser baseUser=(BaseUser) session.getAttribute("login");
	  cost.setUserId(baseUser.getId());
	  costService.addCost(cost);
	  if (payType.equals("充值卡")) {
		Charges charges = indexImpl.findIndexById(indexId);
		Account account = accountService.findByOldIdAccount(list.get(0).getId());
		 account.setBalance(account.getBalance()-charges.getAmountOfMoney());
		 accountService.editAccount(account);
	}
	   return "ok";
   }
   //更新缴费
   @RequestMapping("/updateCost")
   @ResponseBody
   public String updateCost(HttpServletRequest req,HttpSession session,int userid,String oldManName,int indexId,String payType) {
	   try {
		   List<OldMan> list = oldimpl.selectMsgByString(oldManName);
			  Cost cost=new Cost();
			  cost.setId(userid);
			  cost.setPayType(payType);
			  cost.setIndexId(indexId);
			  cost.setOldmanId(list.get(0).getId());
			  cost.setPayTime(new Date());
			  BaseUser baseUser=(BaseUser) session.getAttribute("login");
			  cost.setUserId(baseUser.getId());
			  costService.editCost(cost);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
			
 	  return "ok";
   } 
 //搜索缴费
   @RequestMapping("/searchCost/{page}")
	public String searchCost(HttpSession session,String source,@PathVariable String page) throws NumberFormatException, Exception {
	   //分页搜索信息
	   PageInfo<CostEX> info =costService.findAllByName(Integer.parseInt(page), 6, source);
	   session.setAttribute("costs", info);
	   return "pages/moneyLog";
	}
   //充值卡
	@RequestMapping("/account/{page}")
   public String selectAccount(HttpSession session,
			  @PathVariable String page) {
		 List<OldManExtend> list = oldimpl.selectAll();
		 session.setAttribute("oldManList", list);
		 
		//分页充值信息
		  try {
			  PageInfo<AccountEX> info = accountService.findAllAccountForPages(Integer.parseInt(page), 6);
			  session.setAttribute("accounts", info);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		  return "pages/money";
   }
	//批量或单个删除
	   @RequestMapping("/removeAccount")
	   @ResponseBody
	public String removeAccount(@RequestParam String id) {
		  
		   try {
			   String[] d=null;
			   if(id.contains(",")) {
				  
					//批量删除
				   d=id.split(",");//把数组里的值逗号隔开
				   accountService.removeAccountByIds(d);
				}else {		
					accountService.removeAccountById(Integer.parseInt(id));
				}
				   return "ok";
			  
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "ok";
		}
		  
	}	
	   //增加充值
	   @RequestMapping("/addAccount")
	   @ResponseBody
	   public String addAccount(HttpServletRequest req,HttpSession session,Account account) {
		   BaseUser baseUser=(BaseUser) session.getAttribute("login");
		   account.setUserId(baseUser.getId());
		   account.setAccountDate(new Date());
		accountService.addAccount(account);
		   return "ok";
	   }
	 //更新缴费
	   @RequestMapping("/updateAccount")
	   @ResponseBody
	   public String updateAccount(HttpServletRequest req,HttpSession session,Account account) {
		   try {
			        Account account2 = accountService.findByIdAccount(account.getId());
				  BaseUser baseUser=(BaseUser) session.getAttribute("login");
				  //取出原有的加上新充值的
				  account.setBalance(account2.getBalance()+account.getBalance());
				  account.setUserId(baseUser.getId());
				   account.setAccountDate(new Date());
				   accountService.editAccount(account);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	 	  return "ok";
	   } 
	 //搜索充值卡
	   @RequestMapping("/searchAccount/{page}")
		public String searchAccount(HttpSession session,String source,@PathVariable String page) throws NumberFormatException, Exception {
		   //分页搜索信息
		   PageInfo<AccountEX> info = accountService.findAllByName(Integer.parseInt(page), 6, source);
		   session.setAttribute("accounts", info);
		   return "pages/money";
		}
}
