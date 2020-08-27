import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelHashmap {
	
	public FileInputStream fis = null;
	public FileOutputStream fos = null;
	public XSSFWorkbook workbook = null;
	public XSSFSheet sheet = null;
	public XSSFRow row = null;
	public XSSFCell cell = null;
	String xlFilePath;
	
	public ReadExcelHashmap(String xlFilePath) throws Exception{
		this.xlFilePath = xlFilePath;
		fis = new FileInputStream(xlFilePath);
		workbook = new XSSFWorkbook(fis);
		fis.close();
	}
	
	
	
	public void getCellData(String sheetName, String colName, int rowNum)
	{
		try
		{
			int colNum = -1;
			sheet = workbook.getSheet(sheetName);
			row = sheet.getRow(0);
			
			for(int i=0;i<row.getLastCellNum();i++)
			{
				if(row.getCell(i).getStringCellValue().trim().equals(colName))
					colNum = i;
			}
			row = sheet.getRow(rowNum - 1);
			cell = row.getCell(colNum);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	
	}

	public static void main(String[] args) throws Exception{
		ReadExcelHashmap rehm = new ReadExcelHashmap("C://Users//Kaleem Khan//Desktop//TestData.xlsx");
		rehm.getCellData("Credentials", "Password", 2);
		
	}

}
