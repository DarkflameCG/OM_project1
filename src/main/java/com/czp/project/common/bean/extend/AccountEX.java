package com.czp.project.common.bean.extend;

import com.czp.project.common.bean.Account;
import com.czp.project.common.bean.BaseUser;
import com.czp.project.common.bean.OldMan;

public class AccountEX extends Account{
private OldMan oldMan;
private BaseUser baseUser;
public OldMan getOldMan() {
	return oldMan;
}
public void setOldMan(OldMan oldMan) {
	this.oldMan = oldMan;
}
public BaseUser getBaseUser() {
	return baseUser;
}
public void setBaseUser(BaseUser baseUser) {
	this.baseUser = baseUser;
}
@Override
public String toString() {
	return "AccountEX [oldMan=" + oldMan + ", baseUser=" + baseUser + "]";
}

}
