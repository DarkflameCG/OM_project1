package com.czp.project.service.interfaces;


import com.czp.project.common.bean.extend.OldManRuZhuEX;
import com.github.pagehelper.PageInfo;

public interface OldManRuZhuService {
	PageInfo<OldManRuZhuEX> findAllOldManRuZhuEX(int currpage, int row) throws Exception;
}
