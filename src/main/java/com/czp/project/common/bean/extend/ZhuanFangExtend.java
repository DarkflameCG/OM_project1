package com.czp.project.common.bean.extend;

import com.czp.project.common.bean.OldMan;
import com.czp.project.common.bean.OmZhuanfang;
import com.czp.project.common.bean.Room;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ZhuanFangExtend extends OmZhuanfang{
	public OldMan oldman; //老人对象
	public Room inRoom; //转入房间
	public Room outRoom; //转出放假
}
