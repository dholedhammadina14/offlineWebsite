package com.jbk.utilites;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;




public class ExcelUtils {
	
	public static FileInputStream fis=null;
	public static FileOutputStream fos=null;
	public static Workbook wb=null;
	public void readExcel(String filepath, String sheetName) {
		DataFormatter df = new DataFormatter();
		try {
		 fis= new FileInputStream(filepath);
		 wb= WorkbookFactory.create(fis);
		}catch(Exception e) {
			e.printStackTrace();
		}
		Sheet sh = wb.getSheet(sheetName);
		int rows = sh.getPhysicalNumberOfRows();//3
		for(int i=0;i<rows;i++) {
			int col = sh.getRow(i).getLastCellNum();// i==0--2, i==1--3
			System.out.println("columns in rownum:"+ i+" are "+col);
			for(int j=0;j<col;j++) {
				Cell c= sh.getRow(i).getCell(j);
				String data = df.formatCellValue(c);
				System.out.print(data+"  ");
			}
			System.out.println();
		}
	}
	public  static void writeExcel(String filePath, String sheetName, String data,int row, int col) {
		try {
			 fis= new FileInputStream(filePath);
			 wb= WorkbookFactory.create(fis);
			}catch(Exception e) {
				e.printStackTrace();
			}
			Sheet sh = wb.getSheet(sheetName);
			if(sh.getRow(row)==null) {
				sh.createRow(row);			
			}
			if(sh.getRow(row).getCell(col)==null) {
				sh.getRow(row).createCell(col);
			}
			
		sh.getRow(row).getCell(col).setCellValue(data);	
		try {
		fos = new FileOutputStream(filePath);
		wb.write(fos);
		fos.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static  String readCell(String filepath, String sheetName, int row , int col) {
		DataFormatter df = new DataFormatter();
		try {
		 fis= new FileInputStream(filepath);
		 wb= WorkbookFactory.create(fis);
		}catch(Exception e) {
			e.printStackTrace();
		}
		Sheet sh = wb.getSheet(sheetName);
		Cell c = sh.getRow(row).getCell(col);
		return df.formatCellValue(c);
	}
	public static String getCellData(int row,int col,String fileName,String sheetName) {
		 FileInputStream fis=null;
		 jxl.Workbook wb=null;
		 try{
			fis=new FileInputStream(fileName) ;
			wb=jxl.Workbook.getWorkbook(fis);
			 }
		 catch(Exception e) {
			 e.printStackTrace();
		 }
		jxl.Sheet sheet= wb.getSheet(sheetName);
		jxl.Cell cell=sheet.getCell(col, row);
		return cell.getContents();
	}

}
