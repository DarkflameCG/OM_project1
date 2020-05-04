package com.czp.project.common.bean.extend;

import com.czp.project.common.bean.OmWaichu;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 外出扩展类
 * @author mastercgx
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WaichuExtend extends OmWaichu{
	private OldManExtend oldman; //外键老人
	
}
