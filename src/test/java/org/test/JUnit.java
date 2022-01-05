package org.test;
import java.io.IOException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import com.sun.jna.Library;

public class JUnit extends BaseClass{
@BeforeClass
public static void beforeclass() {
LaunchDriver();
GetUrl("https://adactinhotelapp.com/");
ToMaximize();
}
@AfterClass
public static void afterclass() {
	//ToClose();
}
@Test
public void openpage() throws IOException, InterruptedException {
  WebElement findElementById = findElementById("username");
  String name = getXcel("Sheet1", 1, 0);
  EnterText(findElementById, name);
  
 WebElement pass = findElementById("password");
EnterText(pass, getXcel("Sheet1", 1, 1));

WebElement findElementById2 = findElementById("login");
ToClick(findElementById2);

WebElement loct = findElementById("location");
EnterText(loct, getXcel("Sheet1", 1, 2));

WebElement hotel= findElementById("hotels");
EnterText(hotel, getXcel("Sheet1", 1, 3));

WebElement roomtype = findElementById("room_type");
EnterText(roomtype, getXcel("Sheet1", 1, 4));

WebElement roomno = findElementById("room_nos");
EnterText(roomno, getXcel("Sheet1", 1 ,5 ));

WebElement adultrom = findElementById("adult_room");
EnterText(adultrom, getXcel("Sheet1", 1, 8));

WebElement childroom = findElementById("child_room");
EnterText(childroom, getXcel("Sheet1", 1,9));

WebElement submit = findElementById("Submit");
ToClick(submit);

WebElement radiobtn = findElementById("radiobutton_0");
ToClick(radiobtn);

WebElement cont = findElementById("continue");
ToClick(cont);

WebElement frstname = findElementById("first_name");
EnterText(frstname, getXcel("Sheet1", 1 , 10));

WebElement lstname = findElementById("last_name");
EnterText(lstname, getXcel("Sheet1", 1, 11));


WebElement address = findElementById("address");
EnterText(address, getXcel("Sheet1", 1, 12));

WebElement crdno = findElementById("cc_num");
EnterText(crdno, getXcel("Sheet1", 1, 13));

WebElement crdtype = findElementById("cc_type");
ToSelectByIndex(crdtype, 2);

WebElement month = findElementById("cc_exp_month");
EnterText(month, getXcel("Sheet1", 1, 15));

WebElement year = findElementById("cc_exp_year");
EnterText(year, getXcel("Sheet1", 1, 16));

WebElement cvv = findElementById("cc_cvv");
EnterText(cvv, getXcel("Sheet1", 1, 17));

WebElement book = findElementById("book_now");
ToClick(book);

Thread.sleep(10000);

WebElement orderno = findElementById("order_no");
String order = ToGetAttribute(orderno);


UpdateXcel("Sheet1", 1, 18, order);

System.out.println(order);
System.out.println("done........");







}

	
	
}

