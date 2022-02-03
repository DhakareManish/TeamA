package UtilityPack;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {
	 
	
	public static void savescreenshot(WebDriver driver ,int TestId) throws IOException {
		
		File sourceFolder=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		// Open the current date and time
		String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
		
		File destinationFolder=new File("E:\\velocity\\AUTOMATION NOTES\\selenium\\Screenshots\\"+TestId+""+timestamp+".jpg");
		
		FileHandler.copy(sourceFolder, destinationFolder);
		
		}
	
	public static String getUserNameDataFromSheet(int row ,int col) throws EncryptedDocumentException, IOException {
		String username = null;
		File sourceFile = new File("E:\\velocity\\AUTOMATION NOTES\\UsernameAndPassWord.xlsx");

		FileInputStream fis = new FileInputStream(sourceFile);

		Sheet sheet = WorkbookFactory.create(fis).getSheet("User");

		Row row1 = sheet.getRow(row);
		Cell cell1 = row1.getCell(col);

		try {
			username = cell1.getStringCellValue();

		} catch (NullPointerException e) {

			e.printStackTrace();
		}
		catch (Exception e) {

			e.printStackTrace();
		}
		
		
		// .getRow(1).getCell(1).getStringCellValue();

		return username;

	}
	
	public static String getPassDataFromSheet(int row ,int col) throws EncryptedDocumentException, IOException {
		String pass = null;
		File sourceFile = new File("E:\\velocity\\AUTOMATION NOTES\\UsernameAndPassWord.xlsx");

		FileInputStream fis = new FileInputStream(sourceFile);

		Sheet sheet = WorkbookFactory.create(fis).getSheet("Password");

		Row row1 = sheet.getRow(row);
		Cell cell1 = row1.getCell(col);

		try {
			pass = cell1.getStringCellValue();

		} catch (NullPointerException e) {

			e.printStackTrace();
		}
		catch (Exception e) {

			e.printStackTrace();
		}

		// .getRow(1).getCell(1).getStringCellValue();

		return pass;

	}
	
	
	
	
	
	

}
