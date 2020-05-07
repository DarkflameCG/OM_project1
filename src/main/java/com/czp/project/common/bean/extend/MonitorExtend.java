package com.czp.project.common.bean.extend;

import com.czp.project.common.bean.BaseUser;
import com.czp.project.common.bean.Monitor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description: 体检记录拓展类
 * @Author: GX Cui
 * @Date 10:02 下午 2020/5/6
 * @Param
 * @Return
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MonitorExtend extends Monitor {
    private OldManExtend oldman;
    private BaseUser user;
}
