package org.test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	
static WebDriver driver;
	
	public static void LaunchDriver() {		
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	}
	public void SetProperty(String value) {
		System.setProperty("webdriver.chrome.driver", value);	
	}
	public  static void GetUrl(String url) {
		driver.get(url);
	}
	public String CurrentUrl() {
		String url = driver.getCurrentUrl();
		return url;
	}
	public String GetTitle() {
		String title = driver.getTitle();
		return title;
	}
	public static void ToClose() {
		driver.close();
	}
	public void ToQuit() {
		driver.quit();
	}
	public WebElement findElementById(String data) {
		WebElement element = driver.findElement(By.id(data));
		return element;
	}
	public WebElement findElementByName(String name) {
		WebElement element = driver.findElement(By.name(name));
		return element;
	}
	public WebElement findElementByXpath(String xpath) {
		WebElement element = driver.findElement(By.xpath(xpath));
		return element;
	}
	public void EnterText(WebElement element,String data) {
		element.sendKeys(data);
	}
	public void ToClick(WebElement element) {
		element.click();
	}
	public String ToGetText(WebElement element) {
		String text = element.getText();
		return text;	
	}
	public String ToGetAttribute(WebElement element) {
		String string = element.getAttribute("value");
		return string;
	}
//	public void ToSleep() {
//		Thread.sleep(5000);
//	}
	public void Mousetoelement(WebElement target) {
		Actions action=new Actions(driver);
		action.moveToElement(target).perform();
	}
	public static void ToMaximize() {
		driver.manage().window().maximize();
	}
	public void ToKeyPress(int key) throws AWTException {
		Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_UP);
	}
	public void ToKeyRelease(int key) throws AWTException {
		Robot robot=new Robot();
		robot.keyRelease(KeyEvent.VK_UP);
	}
	public void ToRightClick(WebElement element) {
		Actions action=new Actions(driver);
		action.contextClick(element).perform();
	}
	public void ToNavigate(String string) {
		Navigation navigate=driver.navigate();
		navigate.to(string);
	}
	public void ToNavigateBack() {
		Navigation navigate=driver.navigate();
		navigate.back();
	}
	public void ToRefresh() {
		Navigation navigate=driver.navigate();
		navigate.refresh();
	}
	public void Okayinalert() {
		Alert alert=driver.switchTo().alert();
		alert.accept();
	}
	public void Cancelinalert() {
		Alert alert=driver.switchTo().alert();
		alert.dismiss();
	}
	public void ToSelectByValue(WebElement element,String value) {
		Select select=new Select(element);
		select.selectByValue(value);
	}
	public void ToSelectByText(WebElement element,String value) {
		Select select=new Select(element);
		select.selectByVisibleText(value);
	}
	public void ToSelectByIndex(WebElement element,int index) {
		Select select=new Select(element);
		select.selectByIndex(index);
	}
	public int ToGetOptions(WebElement element) {
		Select select=new Select(element);
		List<WebElement> options = select.getOptions();
		int len=options.size();
		return len;
	}
	public boolean ToCheckMultiple(WebElement element) {
		Select select=new Select(element);
		boolean b = select.isMultiple();
		return b;
	}
	public void ToDeselectByIndex(WebElement element,int index) {
		Select select=new Select(element);
		select.deselectByIndex(index);
	}
	public void ToDeselectByValue(WebElement element,String value) {
		Select select=new Select(element);
		select.deselectByValue(value);
	} 
	public void ToDeselectByText(WebElement element,String text) {
		Select select=new Select(element);
		select.deselectByVisibleText(text);
	}
	public void ToDeselectAll(WebElement element) {
		Select select=new Select(element);
		select.deselectAll();
	}
//	public WebElement ToGetOptionss(WebElement element) {
//		Select select=new Select(element);
//		List<WebElement> list = select.getOptions();
//		return element;
//	}
	public void SwitchToFrame(WebElement element) {
		driver.switchTo().frame(element);
	}
	public void SwitchToFramee(String name) {
		driver.switchTo().frame(name);
	}
	public void SwitchToFram(int index) {
		driver.switchTo().frame(index);
	}
	public void DefaultContent() {
		driver.switchTo().defaultContent();
	}                                         
	public void SwitchParentFrame() {
		driver.switchTo().parentFrame();
	}
	public void JavaScript(String data,WebElement element) {
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0], setAttribute('value',' "+data+" ')",element);	
	}
	public void JavaScriptt(String data,WebElement element) {
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript(" return arguments[0], getAttribute('value')",element);	
	}
	public void JavaScripttt(String data,WebElement element) {
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0], click()",element);	
	}
	public void JavaSScript(String data,WebElement element) {
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0], ScrollIntoView(true)",element);	
	}
	public void Javacript(String data,WebElement element) {
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0], ScrollIntoView(false)",element);	
	}
	public void Frame(int index) {
		driver.switchTo().frame(index);
	}
	public void Framee(String id){
		driver.switchTo().frame(id);
	}
	public void FrameElement(WebElement element) {
		driver.switchTo().frame(element);
	}
	public void Fram(String name) {
		driver.switchTo().frame(name);
	}
	public void FrameDefault() {
		driver.switchTo().defaultContent();
	}
	public void ParentFrame() {
		driver.switchTo().parentFrame();
	}
	public void Window(String id) {
		driver.switchTo().window(id);
	}
	public void Windows(String title) {
		driver.switchTo().window(title);
	}
	public void Windowss(String url) {
		driver.switchTo().window(url);
	}
	public Set<String> WindowHandles() {
		Set<String> handles = driver.getWindowHandles();
		return handles;
	}
	public String WindowHandle() {
		String handles = driver.getWindowHandle();
		return handles;
	}
	public String getXcel(String sheet,int RowNum,int cellnum) throws IOException{
		String data=null;
		File file=new File("C:\\Users\\spark\\eclipse-workspace\\Junit\\excel\\Base.xlsx");
		FileInputStream stream=new FileInputStream(file);
		Workbook workbook =new XSSFWorkbook(stream);
		Sheet sheet2 = workbook.getSheet(sheet);
		Row row = sheet2.getRow(RowNum);
		Cell cell = row.getCell(cellnum);
		int cellType = cell.getCellType();
		if (cellType == 1) {
			 data = cell.getStringCellValue();
		}
		if (cellType==0) {
			if (DateUtil.isCellDateFormatted(cell)) {
				Date date = cell.getDateCellValue();
				SimpleDateFormat df=new SimpleDateFormat("dd/mm/yyy");
				data = df.format(date);
			}else {
				double d = cell.getNumericCellValue();
				long l=(long)d;
				data = String.valueOf(l);
			}
		}
		return data;
	}
	public List<String> getOptionsText(WebElement element) {
		List<String> list=new ArrayList<String>();
		Select select=new Select(element);
		List<WebElement> options = select.getOptions();
		for (WebElement eachelement : options) {
			String text = eachelement.getText();
			list.add(text);
		}
		return list;
	}
	public String UpdateXcel(String sheet,int RowNum,int cellnum,String data) throws IOException{
		File file=new File("C:\\Users\\spark\\eclipse-workspace\\Junit\\excel\\Base.xlsx");
		FileInputStream stream=new FileInputStream(file);
		Workbook workbook =new XSSFWorkbook(stream);
		Sheet sheet2 = workbook.getSheet(sheet);
		Row row = sheet2.getRow(RowNum);
		Cell cell = row.createCell(cellnum);
		cell.setCellValue(data);
		FileOutputStream o=new FileOutputStream(file);
		workbook.write(o);
		return data;
	
	
	}

}
