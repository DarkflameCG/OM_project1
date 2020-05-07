package com.czp.project.common.bean.extend;

import com.czp.project.common.bean.Medical;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description: 外出就医拓展类
 * @Author: GX Cui
 * @Date 10:01 下午 2020/5/6
 * @Param
 * @Return
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MedicalExtend extends Medical {
    private OldManExtend oldman;
}
