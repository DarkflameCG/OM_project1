package com.czp.project.common.bean.extend;

import com.czp.project.common.bean.Cost;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Description: 家属登录
 * @Date 10:38 下午 2020/5/14
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MainData {
    private int qjNumb;
    private int wcNumb;
    private int tjNumb;
    private int jyNumb;
    //消费记录
    private List<Cost> costLogs;

}
