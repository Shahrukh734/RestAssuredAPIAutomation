package com.wipro.sfdc.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;

public class ExcelUtility {
	
	
	/**
	* provides functionality for reading a particular excel sheet and returns a list of maps,
	* each map having data corresponding to one row. 
	  * @return "list"
	 */
	public static Object[] readExcel(String sheetName,String filepath,int i){
		
		XSSFWorkbook workbook=null;
		Map<Object, Object> map=new LinkedHashMap<Object,Object>();;
		
		 Object value=null;
		try {
			
			workbook = new XSSFWorkbook(new FileInputStream(new File(filepath)));
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		XSSFSheet sheet=workbook.getSheet(sheetName);
		
		int colCount=sheet.getRow(0).getPhysicalNumberOfCells();
	
		
			for(int j=0;j<colCount;j++){
				

				if(sheet.getRow(i+1).getCell(j)==null){
					value=null;
				}
				else {

					if (sheet.getRow(i + 1).getCell(j).getCellType() == 0) {
						long temp = (long)sheet.getRow(i + 1).getCell(j).getNumericCellValue();
						value=String.valueOf(temp);
					} else if (sheet.getRow(i + 1).getCell(j).getCellType() == 1) {
						value = sheet.getRow(i + 1).getCell(j).getStringCellValue();
					} else if (sheet.getRow(i + 1).getCell(j).getCellType() == 2) {
						value = sheet.getRow(i + 1).getCell(j).getCellFormula();
					}

					else if (sheet.getRow(i + 1).getCell(j).getCellType() == 3) {
						value = null;

					} else if (sheet.getRow(i + 1).getCell(j).getCellType() == 4) {
						value = sheet.getRow(i + 1).getCell(j).getBooleanCellValue();
					} else if (sheet.getRow(i + 1).getCell(j).getCellType() == 5) {
						value = sheet.getRow(i + 1).getCell(j).getErrorCellString();
					}
				}
			
					map.put(sheet.getRow(0).getCell(j).getStringCellValue(),value);
					
					//System.out.println(i+""+value);
				
				
			}
		
		
		
		return map.values().toArray();
	
	}
	/**
	* provides functionality for fetching the values from the list and adding it to a 2D array.
	  * @return "Object[][]"
	 */

	public static Object[] generateTestData(Map<Object,Object> map){
	
		return map.values().toArray();
		
	}
	
	
	/**
	* provides functionality for writing data of either text within a webelement or the attribute value of that element and 
	* it takes a list of webelements as input
	 * @return "void"
	 */
	public static void writeExcel(List<WebElement> weList,String file,String att){
		try {
			XSSFWorkbook workbook = new XSSFWorkbook(); 
			XSSFSheet sheet = workbook.createSheet("data");
			int row = 1;
			int k = 0;
			
			for(int i=0;i<weList.size();i++){
				Row rown = sheet.createRow(row++);

				Cell cell = rown.createCell(k);

				if(att.equals("text")){
					cell.setCellValue(weList.get(i).getText());
				}else{
					
					cell.setCellValue(weList.get(i).getAttribute(att));
				}
			}
			FileOutputStream out;
			File filed=new File(file+".xlsx");

			out = new FileOutputStream(filed);
			workbook.write(out);
			out.close();
			workbook.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}

	/**
	* provides functionality for writing data of either text within a webelement or the attribute value of that element
	  * @return "void"
	 */
	static int rowe = 1;
	public static void writeExcel(WebElement we,String file,String att){
		try {
			XSSFWorkbook workbook = new XSSFWorkbook(); 
			XSSFSheet sheet = workbook.createSheet("data");
			
			int k = 0;
			
			
				Row rown = sheet.createRow(rowe++);

				Cell cell = rown.createCell(k);

				if(att.equals("text")){
					//System.out.println("row "+rowe);
					cell.setCellValue(we.getText());
				}else{
					
					cell.setCellValue(we.getAttribute(att));
				}
			
			FileOutputStream out;
			File filed=new File(file+".xlsx");

			out = new FileOutputStream(filed);
			workbook.write(out);
			out.close();
			workbook.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
	

}
