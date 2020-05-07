package com.czp.project.common.bean.extend;

import com.czp.project.common.bean.OmQingjia;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 老人请假扩展
 * @author mastercgx
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class QingjiaExtend extends OmQingjia {
	private OldManExtend oldman;
}
