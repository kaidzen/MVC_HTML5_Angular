package org.hardcrystal.mvcHtml5Angular.mvc.excelpdf;

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

public class ExcelDocument extends AbstractExcelView {

    protected void buildExcelDocument(
            Map<String, Object> model,
            HSSFWorkbook workbook,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception{

        //New excel sheet
        HSSFSheet excelSheet = workbook.createSheet("Simple excel example");
        //Excel filename change
        response.setHeader("Content-Disposition", "attachment; filename=excelDocument");

        Font font = workbook.createFont();
        font.setFontName("Arial");
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        font.setColor(HSSFColor.WHITE.index);

        //Style header
        CellStyle styleHeader = workbook.createCellStyle();
        styleHeader.setFillForegroundColor(HSSFColor.WHITE.index);
        styleHeader.setFillPattern(CellStyle.SOLID_FOREGROUND);
        styleHeader.setFont(font);

        //Set excel header
        setExcelHeader(excelSheet, styleHeader);

        //Get data from model
        List<Cat> cats = (List<Cat>) model.get("modelObject");
        int rowCount = 1;
        for (Cat cat: cats){
            HSSFRow row = excelSheet.createRow(rowCount++);
            row.createCell(0).setCellValue(cat.getName());
            row.createCell(1).setCellValue(cat.getWeight());
            row.createCell(2).setCellValue(cat.getColor());
        }
    }

        public void setExcelHeader(HSSFSheet excelsheet, CellStyle styleHeader){
            //Set excel Header names
            HSSFRow header = excelsheet.createRow(0);
            header.createCell(0).setCellValue("Name");
            header.getCell(0).setCellStyle(styleHeader);
            header.createCell(1).setCellValue("Weight");
            header.getCell(1).setCellStyle(styleHeader);
            header.createCell(2).setCellValue("Color");
            header.getCell(2).setCellStyle(styleHeader);
    }

}
