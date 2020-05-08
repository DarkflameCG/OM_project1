package com.czp.project.dao.ex;

import java.util.List;

import com.czp.project.common.bean.extend.CostEX;

public interface CostEXMapper {
	List<CostEX> findAllCostEX();
	List<CostEX> findAllCostByOldManId(int id);
}
