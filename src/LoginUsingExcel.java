import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginUsingExcel {

	public static void main(String[] args) throws Exception, IOException {
		// TODO Auto-generated method stub
		ExcelParser objExcelParse = new ExcelParser("LoginDataExcel.xls");
		String [][] mySampleLoginData = objExcelParse.myExcelParser();
		
		WebDriver objFirefox = new FirefoxDriver();
		objFirefox.get("http://automationpractice.com/");
		
		for(int row=0; row < mySampleLoginData.length; row++){
			for (int col=0; col < mySampleLoginData[row].length; col++){
				System.out.println(mySampleLoginData[col][row]);
		
		WebElement myElement = objFirefox.findElement(By.xpath("//a[@href='http://automationpractice.com/index.php?controller=my-account']"));
		myElement.click();
		try{
			Thread.sleep(2000);
		}
		catch (Exception e){}
		
		myElement = objFirefox.findElement(By.xpath("//input[@name='email']"));
		myElement.sendKeys(mySampleLoginData[col][row]);
		
		try{
			Thread.sleep(2000);
		}
		catch (Exception e){}
		
		col++;
		
		myElement = objFirefox.findElement(By.xpath("//input[@name='passwd']"));
		myElement.sendKeys(mySampleLoginData[col][row]);
		try{
			Thread.sleep(2000);
		}
		catch (Exception e){}
		
		myElement = objFirefox.findElement(By.xpath("//button[@name='SubmitLogin']"));
		myElement.click();
		
		try{
			Thread.sleep(5000);
		}
		catch (Exception e){}
		
		myElement = objFirefox.findElement(By.xpath("//a[@href='http://automationpractice.com/index.php?mylogout=']"));
		myElement.click();
		
		try{
			Thread.sleep(7000);
		}
		catch (Exception e){}
		
//		try{
//			Thread.sleep(2500);
//		}
//		catch (Exception e){
//			
//		}
		objFirefox.close();
		}
	}
	}
}
