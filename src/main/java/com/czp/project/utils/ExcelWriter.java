package com.czp.project.utils;

import com.czp.project.common.bean.OldMan;
import com.czp.project.common.bean.extend.OldManExtend;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Description: 生成Excel并写入数据
 * @Author: GX Cui
 * @Date 10:35 上午 2020/5/11
 * @Param 
 * @Return 
 */
public class ExcelWriter {
    private static List<String> CELL_HEADS; //列头

    static{
        // 类装载时就载入指定好的列头信息，如有需要，可以考虑做成动态生成的列头
        CELL_HEADS = new ArrayList<>();
        CELL_HEADS.add("序号");
        CELL_HEADS.add("姓名");
        CELL_HEADS.add("年龄");
        CELL_HEADS.add("性别");
        CELL_HEADS.add("入住时间");
        CELL_HEADS.add("健康状况");
        CELL_HEADS.add("老人家属 ");
        CELL_HEADS.add("电话");
        CELL_HEADS.add("房间号");
        CELL_HEADS.add("护工姓名");
    }

    /**
     * 生成Excel并写入数据信息
     * @param dataList 数据列表
     * @return 写入数据后的工作簿对象
     */
    public static Workbook exportData(List<OldManExtend> dataList){
        // 生成xlsx的Excel
        Workbook workbook = new SXSSFWorkbook();

        // 如需生成xls的Excel，请使用下面的工作簿对象，注意后续输出时文件后缀名也需更改为xls
        //Workbook workbook = new HSSFWorkbook();

        // 生成Sheet表，写入第一行的列头
        Sheet sheet = buildDataSheet(workbook);
        //构建每行的数据内容
        int rowNum = 1;
        for (Iterator<OldManExtend> it = dataList.iterator(); it.hasNext(); ) {
            OldManExtend data = it.next();
            if (data == null) {
                continue;
            }
            //输出行数据
            Row row = sheet.createRow(rowNum++);
            convertDataToRow(data, row);
        }
        return workbook;
    }

    /**
     * 生成sheet表，并写入第一行数据（列头）
     * @param workbook 工作簿对象
     * @return 已经写入列头的Sheet
     */
    private static Sheet buildDataSheet(Workbook workbook) {
        Sheet sheet = workbook.createSheet();
        // 设置列头宽度
        for (int i=0; i<CELL_HEADS.size(); i++) {
            sheet.setColumnWidth(i, 4000);
        }
        // 设置默认行高
        sheet.setDefaultRowHeight((short) 400);
        // 构建头单元格样式
        CellStyle cellStyle = buildHeadCellStyle(sheet.getWorkbook());
        // 写入第一行各列的数据
        Row head = sheet.createRow(0);
        for (int i = 0; i < CELL_HEADS.size(); i++) {
            Cell cell = head.createCell(i);
            cell.setCellValue(CELL_HEADS.get(i));
            cell.setCellStyle(cellStyle);
        }
        return sheet;
    }

    /**
     * 设置第一行列头的样式
     * @param workbook 工作簿对象
     * @return 单元格样式对象
     */
    private static CellStyle buildHeadCellStyle(Workbook workbook) {
        CellStyle style = workbook.createCellStyle();
        //对齐方式设置
        style.setAlignment(HorizontalAlignment.CENTER);
        //边框颜色和宽度设置
        style.setBorderBottom(BorderStyle.THIN);
        style.setBottomBorderColor(IndexedColors.BLACK.getIndex()); // 下边框
        style.setBorderLeft(BorderStyle.THIN);
        style.setLeftBorderColor(IndexedColors.BLACK.getIndex()); // 左边框
        style.setBorderRight(BorderStyle.THIN);
        style.setRightBorderColor(IndexedColors.BLACK.getIndex()); // 右边框
        style.setBorderTop(BorderStyle.THIN);
        style.setTopBorderColor(IndexedColors.BLACK.getIndex()); // 上边框
        //设置背景颜色
        style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        //粗体字设置
        Font font = workbook.createFont();
        font.setBold(true);
        style.setFont(font);
        return style;
    }

    /**
     * 将数据转换成行
     * 重写该方法用于展示
     * @param data 源数据
     * @param row 行对象
     * @return
     */
    private static void convertDataToRow(OldManExtend data, Row row){
        int cellNum = 0;
        Cell cell;

        //序号
        cell = row.createCell(cellNum++);
        cell.setCellValue(null == data.getId() ? "" : String.valueOf(data.getId()));
        //姓名
        cell = row.createCell(cellNum++);
        cell.setCellValue(null == data.getOldmanName() ? "" : data.getOldmanName());
        //年龄
        cell = row.createCell(cellNum++);
        if (null != data.getAge()) {
            cell.setCellValue(data.getAge());
        } else {
            cell.setCellValue("");
        }
        //性别
        cell = row.createCell(cellNum++);
        cell.setCellValue(null == data.getGender() ? "" : data.getGender());
        //入住时间
        cell = row.createCell(cellNum++);
        cell.setCellValue(null == data.getCheckintime() ? "" : new SimpleDateFormat("yyyy-MM-dd").format(data.getCheckintime()));
        //健康状况
        cell = row.createCell(cellNum++);
        cell.setCellValue(null == data.getHealth() ? "" : data.getHealth());
        //老人家属
        cell = row.createCell(cellNum++);
        cell.setCellValue(null == data.getSon() ? "" : data.getSon().getFamilyName());
        //电话
        cell = row.createCell(cellNum++);
        cell.setCellValue(null == data.getSon() ? "" : data.getSon().getTelphone());
        //房间号
        cell = row.createCell(cellNum++);
        cell.setCellValue(null == data.getRoom() ? "" : data.getRoom().getRoomNumb());
        //护工姓名
        cell = row.createCell(cellNum++);
        cell.setCellValue(null == data.getHugong()? "" : data.getHugong().getUserName());


    }
    public static void main(String[] args) {
        // 创建需要写入的数据列表
        List<OldManExtend> dataVOList = new ArrayList<>();
        OldManExtend dataVO = new OldManExtend();
        dataVO.setOldmanName("小明");
        dataVO.setAge(18);
        dataVO.setGender("男");
        OldManExtend dataVO2 = new OldManExtend();
        dataVO2.setOldmanName("小花");
        dataVO2.setAge(19);
        dataVO2.setGender("男");
        dataVOList.add(dataVO);
        dataVOList.add(dataVO2);

        // 写入数据到工作簿对象内
        Workbook workbook = ExcelWriter.exportData(dataVOList);

        // 以文件的形式输出工作簿对象
        FileOutputStream fileOut = null;
        try {
            String exportFilePath = "/Users/mastercgx/Desktop/writeExample.xlsx";
            File exportFile = new File(exportFilePath);
            if (!exportFile.exists()) {
                boolean flag = exportFile.createNewFile();
            }

            fileOut = new FileOutputStream(exportFilePath);
            workbook.write(fileOut);
            fileOut.flush();
        } catch (Exception e) {
            System.err.println(("输出Excel时发生错误，错误原因：" + e.getMessage()));
        } finally {
            try {
                if (null != fileOut) {
                    fileOut.close();
                    workbook.close();
                }
            } catch (IOException e) {
                System.err.println(("关闭输出流时发生错误，错误原因：" + e.getMessage()));
            }
        }

    }
}
