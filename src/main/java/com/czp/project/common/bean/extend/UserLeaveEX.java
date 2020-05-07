package com.czp.project.common.bean.extend;

import com.czp.project.common.bean.BaseUser;
import com.czp.project.common.bean.UserLeave;

public class UserLeaveEX extends UserLeave{
private BaseUser baseUser;

public BaseUser getBaseUser() {
	return baseUser;
}

public void setBaseUser(BaseUser baseUser) {
	this.baseUser = baseUser;
}

@Override
public String toString() {
	return "UserLeaveEX [baseUser=" + baseUser + "]";
}


}
