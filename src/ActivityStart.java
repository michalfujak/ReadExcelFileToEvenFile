// Creating Michal Fujak 2.9.2020 20:45


import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ActivityStart {
	
	// variable public
	public int convertFromDouble = 0;
	public int convertFromString = 0;
	private String cellStringValue = null;

	public static void main(String[] args) 
	{
		// start main function
		NumericData numData = new NumericData();
		// class call.this
		ActivityStart startStage = new ActivityStart();
		
		try
		{
			// File load
			File file = new File("C:\\IT_Projekty\\Java\\ReadExcelFileToEvenValue\\excel\\vzorek_dat.xlsx");
			// File file = new File("C:\\IT_Projekty\\Java\\ReadExcelFileToEvenValue\\excel\\students.xlsx");
			//
			FileInputStream fis = new FileInputStream(file);
			// creating Workbook
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			// creating sheet page (index)
			XSSFSheet sheet = wb.getSheetAt(0);
			// iterating over excel file
			Iterator<Row> itr = sheet.iterator();
			//
			while(itr.hasNext())
			{
				Row row = itr.next();
				// iterating over each column
				Iterator<Cell> cellIterator = row.cellIterator();
				// getColumn disable
				// Iterator<Cell> cellIterator = row.getCell(1);
				while(cellIterator.hasNext())
				{
					Cell cell = cellIterator.next();
					//
					switch(cell.getCellTypeEnum())
					{
					case NUMERIC:
						// numeric data, from excel.file
						double xXx = cell.getNumericCellValue();
						startStage.convertFromDouble = (int)xXx;
						numData.checkNumber(startStage.convertFromDouble);
						break;
						
					case STRING:
						// System.out.print(cell.getStringCellValue() + "\t\t\t");
						try
						{
							startStage.cellStringValue = cell.getStringCellValue();
							startStage.convertFromString = Integer.parseInt(startStage.cellStringValue);
							//
							numData.checkNumber(startStage.convertFromString);
						}
						catch(NumberFormatException exc)
						{
							// ignore
							// exc.printStackTrace();
						}
						break;
						
					default:
						break;
					}
				}
			}
			wb.close();
			
			
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
	}

}
