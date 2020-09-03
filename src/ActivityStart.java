// Creating Michal Fujak 2.9.2020 20:45


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

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
			try
			{
				// File load
				@SuppressWarnings("resource")
				Scanner scanner = new Scanner(System.in);
				//
				FileInputStream fis = new FileInputStream(scanner.nextLine());
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
							if(numData.primeNumber(startStage.convertFromDouble) != false)
							{
								System.out.println(startStage.convertFromDouble + " : je prvocislo! ");
							}
							break;
							
						case STRING:
							// System.out.print(cell.getStringCellValue() + "\t\t\t");
							try
							{
								startStage.cellStringValue = cell.getStringCellValue();
								startStage.convertFromString = Integer.parseInt(startStage.cellStringValue);
								//
								if(numData.primeNumber(startStage.convertFromString) != false)
								{
									System.out.println(startStage.convertFromString + " : je prvocislo! ");
								}
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
			catch(FileNotFoundException excFile)
			{
				excFile.printStackTrace();
			}
				
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
	}

}
