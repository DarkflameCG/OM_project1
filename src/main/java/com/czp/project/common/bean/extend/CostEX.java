package com.czp.project.common.bean.extend;

import com.czp.project.common.bean.BaseUser;
import com.czp.project.common.bean.Charges;
import com.czp.project.common.bean.Cost;
import com.czp.project.common.bean.OldMan;

public class CostEX extends Cost{
private Charges charges;
private OldMan oldMan;
private BaseUser baseUser;
public Charges getCharges() {
	return charges;
}
public void setCharges(Charges charges) {
	this.charges = charges;
}
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
	return "CostEX [charges=" + charges + ", oldMan=" + oldMan + ", baseUser=" + baseUser + "]";
}

}
