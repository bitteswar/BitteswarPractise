package com.hca.qa.testcase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class excelhandling {


			public static void main(String[] args) throws EncryptedDocumentException, IOException  {
				FileInputStream Fi = new FileInputStream("C:\\Users\\HP15 BA022AX\\Desktop\\Desktop Backups\\expedure.xlsx");

				Workbook workbook = WorkbookFactory.create(Fi);
				Sheet sh = workbook.getSheet("Bitteswar1");
				Cell cellvalue = sh.getRow(0).getCell(0);

				String value1 = cellvalue.getStringCellValue();
				System.out.println(value1);

			}

		


	}


