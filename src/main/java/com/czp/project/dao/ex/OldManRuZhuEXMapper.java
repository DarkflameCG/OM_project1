package com.czp.project.dao.ex;

import java.util.List;

import com.czp.project.common.bean.extend.OldManRuZhuEX;
import com.czp.project.common.bean.extend.ZhuanFangExtend;

public interface OldManRuZhuEXMapper {
	List<OldManRuZhuEX> findAllOldManRuZhuEX();
	public List<OldManRuZhuEX> selectByParameter(String text);
}