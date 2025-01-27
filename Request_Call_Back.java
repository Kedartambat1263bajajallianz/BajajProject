package RequestCall;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;


public class Request_Call_Back {
	
	private static final String CellType = null;
	WebDriver driver;
	 @SuppressWarnings("deprecation")
		public static String formatNumber(double row) {

			 String cellValueStr = Double.toString(row);
			
				 // Split the scientific notation 
				 String[] parts = cellValueStr.toLowerCase().split("e");
				 // Parse the base number and exponent 
				 
				 BigDecimal baseNumber = new BigDecimal(parts[0]); 
				 int exponent = Integer.parseInt(parts[1]);
				 // Use BigDecimal for precise conversion 
				 BigDecimal bigDecimal = baseNumber.multiply(BigDecimal.valueOf(Math.pow(10, exponent)));
				 // Convert to string without scientific notation 
					
				 return bigDecimal.stripTrailingZeros().setScale(0, BigDecimal.ROUND_UNNECESSARY).toPlainString();
					 }
	 

	    @BeforeClass()

	    public void Open_Browser_And_Open_URL() {
	        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Kedar.Tambat\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

	        driver = new ChromeDriver();

	       // System.setProperty("Web driver.edge.driver", "C:\\Users\\Kedar.Tambat\\Downloads\\msedgedriver.exe");

	       // WebDriver driver = new EdgeDriver();

	        driver.manage().window().maximize();

	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	    }

	    @Test()
	    public void Check_Lead_flow_Page2() throws InterruptedException, IOException {
	        System.out.println("Kedar Test arogya-sanjeevani-standard-health-insurance-policy Pass");
	        driver.get("https://www.bajajallianz.com/health-insurance-plans/arogya-sanjeevani-standard-health-insurance-policy.html");
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // 20 seconds timeout
	        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='callBack']")));
	        element.click();
	        WebElement FUllName= driver.findElement(By.xpath("//*[@class='lblinput callBackName inputChar']"));
	        FUllName.sendKeys("Dont call on this Number Its a testing lead");
	      //  WebElement MobileNumb= driver.findElement(By.xpath("//*[@class='lblinput callBackMobNumber inputNum']"));
	      //MobileNumb.sendKeys("9284482268");
	       //new code to fetch excel data
	        WebElement MobileNumb= driver.findElement(By.xpath("//*[@class='lblinput callBackMobNumber inputNum']"));
			File file = new File("D:\\Daily Task Report\\ExcelSheet.xlsx");
			FileInputStream fis = new FileInputStream(file);
			XSSFWorkbook workbook = new XSSFWorkbook(fis); 
			XSSFSheet sheet = workbook.getSheetAt(0);
			XSSFRow col = sheet.getRow(0);
			XSSFCell cell = col.getCell(14);
			if (cell != null && cell.getCellType() == cell.CELL_TYPE_NUMERIC) { 
				double cellValue = cell.getNumericCellValue();
				String formattedNumber = formatNumber(cellValue);
				System.out.println("Perfect Number: " + formattedNumber);
				MobileNumb.sendKeys(formattedNumber);
				} 
			else { System.out.println("Cell is not numeric or is empty."); }
	        //**********************************************************************************************************
	        WebElement Enquiry= driver.findElement(By.id("enqfor"));
	        Select enqry =new Select(Enquiry);
	        enqry.selectByVisibleText("Purchase");
	        WebElement Callbckbt= driver.findElement(By.xpath("//*[@class='btn'][text()='Call Back']"));
	        Callbckbt.click();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20)); // 20 seconds timeout
	        WebElement element1 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='popupSec callbackthankyou activePopup']")));
	        System.out.println(element1.isDisplayed());
	    }
	   
		@Test()
	    public void Check_Lead_flow_Page3() throws InterruptedException, IOException {
	        System.out.println("Kedar Test motor-insurance/electric-bike-insurance Pass");
	        driver.get("https://www.bajajallianz.com/motor-insurance/electric-bike-insurance.html");
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // 20 seconds timeout
	        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='callBack']")));
	        element.click();
	        WebElement FUllName= driver.findElement(By.xpath("//*[@class='lblinput callBackName inputChar']"));
	        FUllName.sendKeys("Dont call on this Number Its a testing lead");
	        WebElement MobileNumb= driver.findElement(By.xpath("//*[@class='lblinput callBackMobNumber inputNum']"));
//	        MobileNumb.sendKeys(formattedNumber);
	        //***********************************
		       //new code to fetch excel data
			File file = new File("D:\\Daily Task Report\\ExcelSheet.xlsx");
			FileInputStream fis = new FileInputStream(file);
			XSSFWorkbook workbook = new XSSFWorkbook(fis); 
			XSSFSheet sheet = workbook.getSheetAt(0);
			XSSFRow col = sheet.getRow(1);
			XSSFCell cell = col.getCell(14);
			if (cell != null && cell.getCellType() == cell.CELL_TYPE_NUMERIC) { 
				double cellValue = cell.getNumericCellValue();
				String formattedNumber = formatNumber(cellValue);
				System.out.println("Perfect Number: " + formattedNumber);
				MobileNumb.sendKeys(formattedNumber);
				} 
			else { System.out.println("Cell is not numeric or is empty."); }


	        //******************************
	        
	        WebElement Enquiry= driver.findElement(By.id("enqfor"));
	        Select enqry =new Select(Enquiry);
	        enqry.selectByVisibleText("Purchase");
	        WebElement Callbckbt= driver.findElement(By.xpath("//*[@class='btn'][text()='Call Back']"));
	        Callbckbt.click();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20)); // 20 seconds timeout
	        WebElement element1 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='popupSec callbackthankyou activePopup']")));
	        System.out.println(element1.isDisplayed());
	    }
	    @Test()
	    public void Check_Lead_flow_Page4() throws InterruptedException, IOException {
	        System.out.println("Kedar Test motor-insurance/electric-car-insurance Pass");
	        driver.get("https://www.bajajallianz.com/motor-insurance/electric-car-insurance.html");
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // 20 seconds timeout
	        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='callBack']")));
	        element.click();
	        WebElement FUllName= driver.findElement(By.xpath("//*[@class='lblinput callBackName inputChar']"));
	        FUllName.sendKeys("Dont call on this Number Its a testing lead");
	        WebElement MobileNumb= driver.findElement(By.xpath("//*[@class='lblinput callBackMobNumber inputNum']"));
	        //**************************
			File file = new File("D:\\Daily Task Report\\ExcelSheet.xlsx");
			FileInputStream fis = new FileInputStream(file);
			XSSFWorkbook workbook = new XSSFWorkbook(fis); 
			XSSFSheet sheet = workbook.getSheetAt(0);
			XSSFRow col = sheet.getRow(2);
			XSSFCell cell = col.getCell(14);
			if (cell != null && cell.getCellType() == cell.CELL_TYPE_NUMERIC) { 
				double cellValue = cell.getNumericCellValue();
				String formattedNumber = formatNumber(cellValue);
				System.out.println("Perfect Number: " + formattedNumber);
				MobileNumb.sendKeys(formattedNumber);
				} 
			else { System.out.println("Cell is not numeric or is empty."); }

	        //**************************
	        WebElement Enquiry= driver.findElement(By.id("enqfor"));
	        Select enqry =new Select(Enquiry);
	        enqry.selectByVisibleText("Purchase");
	        WebElement Callbckbt= driver.findElement(By.xpath("//*[@class='btn'][text()='Call Back']"));
	        Callbckbt.click();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20)); // 20 seconds timeout
	        WebElement element1 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='popupSec callbackthankyou activePopup']")));
	        System.out.println(element1.isDisplayed());
	    }
	    @Test()
	    public void Check_Lead_flow_Page5() throws InterruptedException, IOException {
	        System.out.println("Kedar Test motor-insurance/commerical-electric-vehicle-insurance Pass");
	        driver.get("https://www.bajajallianz.com/motor-insurance/commerical-electric-vehicle-insurance.html");
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // 20 seconds timeout
	        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='callBack']")));
	        element.click();
	        WebElement FUllName= driver.findElement(By.xpath("//*[@class='lblinput callBackName inputChar']"));
	        FUllName.sendKeys("Dont call on this Number Its a testing lead");
	        WebElement MobileNumb= driver.findElement(By.xpath("//*[@class='lblinput callBackMobNumber inputNum']"));
	        //***********************************
		       //new code to fetch excel data
			File file = new File("D:\\Daily Task Report\\ExcelSheet.xlsx");
			FileInputStream fis = new FileInputStream(file);
			XSSFWorkbook workbook = new XSSFWorkbook(fis); 
			XSSFSheet sheet = workbook.getSheetAt(0);
			XSSFRow col = sheet.getRow(3);
			XSSFCell cell = col.getCell(14);
			if (cell != null && cell.getCellType() == cell.CELL_TYPE_NUMERIC) { 
				double cellValue = cell.getNumericCellValue();
				String formattedNumber = formatNumber(cellValue);
				System.out.println("Perfect Number: " + formattedNumber);
				MobileNumb.sendKeys(formattedNumber);
				} 
			else { System.out.println("Cell is not numeric or is empty."); }

	        //******************************
	    
	        WebElement Enquiry= driver.findElement(By.id("enqfor"));
	        Select enqry =new Select(Enquiry);
	        enqry.selectByVisibleText("Purchase");
	        WebElement Callbckbt= driver.findElement(By.xpath("//*[@class='btn'][text()='Call Back']"));
	        Callbckbt.click();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20)); // 20 seconds timeout
	        WebElement element1 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='popupSec callbackthankyou activePopup']")));
	        System.out.println(element1.isDisplayed());
	    }
	  
		@Test()
	    public void Check_Lead_flow_Page6() throws InterruptedException, IOException {
	        System.out.println("Kedar Test motor-insurance/car-insurance Pass");
	        driver.get("https://www.bajajallianz.com/motor-insurance/car-insurance-online.html");
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	      //  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // 35 seconds timeout
	      //  WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='callBack']")));
	        WebElement element= driver.findElement(By.xpath("//*[@alt='Request Callback Icon']"));
	        element.click();
	        WebElement FUllName= driver.findElement(By.xpath("//*[@class='lblinput callBackName inputChar']"));
	        FUllName.sendKeys("Dont call on this Number Its a testing lead");
	        WebElement MobileNumb= driver.findElement(By.xpath("//*[@class='lblinput callBackMobNumber inputNum']"));
	        
	        //***********************************
		       //new code to fetch excel data
			File file = new File("D:\\Daily Task Report\\ExcelSheet.xlsx");
			FileInputStream fis = new FileInputStream(file);
			XSSFWorkbook workbook = new XSSFWorkbook(fis); 
			XSSFSheet sheet = workbook.getSheetAt(0);
			XSSFRow col = sheet.getRow(4);
			XSSFCell cell = col.getCell(14);
			if (cell != null && cell.getCellType() == cell.CELL_TYPE_NUMERIC) { 
				double cellValue = cell.getNumericCellValue();
				String formattedNumber = formatNumber(cellValue);
				System.out.println("Perfect Number: " + formattedNumber);
				MobileNumb.sendKeys(formattedNumber);
				} 
			else { System.out.println("Cell is not numeric or is empty."); }
	        //******************************
	        WebElement Enquiry= driver.findElement(By.id("enqfor"));
	        Select enqry =new Select(Enquiry);
	        enqry.selectByVisibleText("Purchase");
	        WebElement Callbckbt= driver.findElement(By.xpath("//*[@class='btn callbackBtn-hmevt']"));
	        Callbckbt.click();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	      //  WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10)); // 20 seconds timeout
	      //  WebElement element1 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='popupSec callbackthankyou activePopup']")));
	       // System.out.println(element1.isDisplayed());
	    }
	    @Test()
	    public void Check_Lead_flow_Page7() throws InterruptedException, IOException {
	        System.out.println("Kedar Test motor-insurance/two-wheeler-insurance Pass");
	        driver.get("https://www.bajajallianz.com/motor-insurance/two-wheeler-insurance-online.html");
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	      //  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // 35 seconds timeout
	     //   WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='callBack']")));
	        WebElement element= driver.findElement(By.xpath("//*[@alt='Request Callback Icon']"));
	        element.click();
	        WebElement FUllName= driver.findElement(By.xpath("//*[@class='lblinput callBackName inputChar']"));
	        FUllName.sendKeys("Dont call on this Number Its a testing lead");
	        WebElement MobileNumb= driver.findElement(By.xpath("//*[@class='lblinput callBackMobNumber inputNum']"));
	        //**************************
		       //new code to fetch excel data

			File file = new File("D:\\Daily Task Report\\ExcelSheet.xlsx");
			FileInputStream fis = new FileInputStream(file);
			XSSFWorkbook workbook = new XSSFWorkbook(fis); 
			XSSFSheet sheet = workbook.getSheetAt(0);
			XSSFRow col = sheet.getRow(5);
			XSSFCell cell = col.getCell(14);
			if (cell != null && cell.getCellType() == cell.CELL_TYPE_NUMERIC) { 
				double cellValue = cell.getNumericCellValue();
				String formattedNumber = formatNumber(cellValue);
				System.out.println("Perfect Number: " + formattedNumber);
				MobileNumb.sendKeys(formattedNumber);
				} 
			else { System.out.println("Cell is not numeric or is empty."); }
	        //***************************
	        
	        WebElement Enquiry= driver.findElement(By.id("enqfor"));
	        Select enqry =new Select(Enquiry);
	        enqry.selectByVisibleText("Purchase");
	        WebElement Callbckbt= driver.findElement(By.xpath("//*[@class='btn callbackBtn-hmevt']"));
	        Callbckbt.click();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	      //  WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(05)); // 20 seconds timeout
	      //  WebElement element1 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='popupSec callbackthankyou activePopup']")));
	       // System.out.println(element1.isDisplayed());
	    }
	    @Test()
	    public void Check_Lead_flow_Page8() throws InterruptedException, IOException {
	        System.out.println("Kedar Test motor-insurance/third-party-car-insurance Pass");
	        driver.get("https://www.bajajallianz.com/motor-insurance/third-party-car-insurance-online.html");
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // 20 seconds timeout
	        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='callBack']")));
	        element.click();
	        WebElement FUllName= driver.findElement(By.xpath("//*[@class='lblinput callBackName inputChar']"));
	        FUllName.sendKeys("Dont call on this Number Its a testing lead");
	        WebElement MobileNumb= driver.findElement(By.xpath("//*[@class='lblinput callBackMobNumber inputNum']"));
	        //**************************
		       //new code to fetch excel data
	 
			File file = new File("D:\\Daily Task Report\\ExcelSheet.xlsx");
			FileInputStream fis = new FileInputStream(file);
			XSSFWorkbook workbook = new XSSFWorkbook(fis); 
			XSSFSheet sheet = workbook.getSheetAt(0);
			XSSFRow col = sheet.getRow(6);
			XSSFCell cell = col.getCell(14);
			if (cell != null && cell.getCellType() == cell.CELL_TYPE_NUMERIC) { 
				double cellValue = cell.getNumericCellValue();
				String formattedNumber = formatNumber(cellValue);
				System.out.println("Perfect Number: " + formattedNumber);
				MobileNumb.sendKeys(formattedNumber);
				} 
			else { System.out.println("Cell is not numeric or is empty."); }
	        //***************************
	        WebElement Enquiry= driver.findElement(By.id("enqfor"));
	        Select enqry =new Select(Enquiry);
	        enqry.selectByVisibleText("Purchase");
	        WebElement Callbckbt= driver.findElement(By.xpath("//*[@class='btn'][text()='Call Back']"));
	        Callbckbt.click();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20)); // 20 seconds timeout
	        WebElement element1 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='popupSec callbackthankyou activePopup']")));
	        System.out.println(element1.isDisplayed());
	    }
	    @Test()
	    public void Check_Lead_flow_Page9() throws InterruptedException, IOException {
	        System.out.println("Kedar Test motor-insurance/two-wheeler-insurance-third-party Pass");
	        driver.get("https://www.bajajallianz.com/motor-insurance/two-wheeler-insurance-third-party.html");
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // 20 seconds timeout
	        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='callBack']")));
	        element.click();
	        WebElement FUllName= driver.findElement(By.xpath("//*[@class='lblinput callBackName inputChar']"));
	        FUllName.sendKeys("Dont call on this Number Its a testing lead");
	        WebElement MobileNumb= driver.findElement(By.xpath("//*[@class='lblinput callBackMobNumber inputNum']"));
	        //**************************
		       //new code to fetch excel data
			File file = new File("D:\\Daily Task Report\\ExcelSheet.xlsx");
			FileInputStream fis = new FileInputStream(file);
			XSSFWorkbook workbook = new XSSFWorkbook(fis); 
			XSSFSheet sheet = workbook.getSheetAt(0);
			XSSFRow col = sheet.getRow(7);
			XSSFCell cell = col.getCell(14);
			if (cell != null && cell.getCellType() == cell.CELL_TYPE_NUMERIC) { 
				double cellValue = cell.getNumericCellValue();
				String formattedNumber = formatNumber(cellValue);
				System.out.println("Perfect Number: " + formattedNumber);
				MobileNumb.sendKeys(formattedNumber);
				} 
			else { System.out.println("Cell is not numeric or is empty."); }

	        //***************************
	       
	        WebElement Enquiry= driver.findElement(By.id("enqfor"));
	        Select enqry =new Select(Enquiry);
	        enqry.selectByVisibleText("Purchase");
	        WebElement Callbckbt= driver.findElement(By.xpath("//*[@class='btn'][text()='Call Back']"));
	        Callbckbt.click();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20)); // 20 seconds timeout
	        WebElement element1 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='popupSec callbackthankyou activePopup']")));
	        System.out.println(element1.isDisplayed());
	    }
	    @Test()
	    public void Check_Lead_flow_Page10() throws InterruptedException, IOException {
	        System.out.println("Kedar Test motor-insurance/commercial-vehicle-insurance Pass");
	        driver.get("https://www.bajajallianz.com/motor-insurance/commercial-vehicle-insurance.html");
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // 20 seconds timeout
	        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='callBack']")));
	        element.click();
	        WebElement FUllName= driver.findElement(By.xpath("//*[@class='lblinput callBackName inputChar']"));
	        FUllName.sendKeys("Dont call on this Number Its a testing lead");
	        WebElement MobileNumb= driver.findElement(By.xpath("//*[@class='lblinput callBackMobNumber inputNum']"));
	        //**************************
		       //new code to fetch excel data
			File file = new File("D:\\Daily Task Report\\ExcelSheet.xlsx");
			FileInputStream fis = new FileInputStream(file);
			XSSFWorkbook workbook = new XSSFWorkbook(fis); 
			XSSFSheet sheet = workbook.getSheetAt(0);
			XSSFRow col = sheet.getRow(8);
			XSSFCell cell = col.getCell(14);
			if (cell != null && cell.getCellType() == cell.CELL_TYPE_NUMERIC) { 
				double cellValue = cell.getNumericCellValue();
				String formattedNumber = formatNumber(cellValue);
				System.out.println("Perfect Number: " + formattedNumber);
				MobileNumb.sendKeys(formattedNumber);
				} 
			else { System.out.println("Cell is not numeric or is empty."); }

	        //***************************
	       
	        WebElement Enquiry= driver.findElement(By.id("enqfor"));
	        Select enqry =new Select(Enquiry);
	        enqry.selectByVisibleText("Purchase");
	        WebElement Callbckbt= driver.findElement(By.xpath("//*[@class='btn'][text()='Call Back']"));
	        Callbckbt.click();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20)); // 20 seconds timeout
	        WebElement element1 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='popupSec callbackthankyou activePopup']")));
	        System.out.println(element1.isDisplayed());
	    }
	    @Test()
	    public void Check_Lead_flow_Page11() throws InterruptedException, IOException {
	        System.out.println("Kedar Test travel-insurance-online/family-travel-insurance Pass");
	        driver.get("https://www.bajajallianz.com/travel-insurance-online/family-travel-insurance.html");
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // 20 seconds timeout
	        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='callBack']")));
	        element.click();
	        WebElement FUllName= driver.findElement(By.xpath("//*[@class='lblinput callBackName inputChar']"));
	        FUllName.sendKeys("Dont call on this Number Its a testing lead");
	        WebElement MobileNumb= driver.findElement(By.xpath("//*[@class='lblinput callBackMobNumber inputNum']"));
	        //**************************
		       //new code to fetch excel data
			File file = new File("D:\\Daily Task Report\\ExcelSheet.xlsx");
			FileInputStream fis = new FileInputStream(file);
			XSSFWorkbook workbook = new XSSFWorkbook(fis); 
			XSSFSheet sheet = workbook.getSheetAt(0);
			XSSFRow col = sheet.getRow(9);
			XSSFCell cell = col.getCell(14);
			if (cell != null && cell.getCellType() == cell.CELL_TYPE_NUMERIC) { 
				double cellValue = cell.getNumericCellValue();
				String formattedNumber = formatNumber(cellValue);
				System.out.println("Perfect Number: " + formattedNumber);
				MobileNumb.sendKeys(formattedNumber);
				} 
			else { System.out.println("Cell is not numeric or is empty."); }

	        //***************************
	       
	        WebElement Enquiry= driver.findElement(By.id("enqfor"));
	        Select enqry =new Select(Enquiry);
	        enqry.selectByVisibleText("Purchase");
	        WebElement Callbckbt= driver.findElement(By.xpath("//*[@class='btn'][text()='Call Back']"));
	        Callbckbt.click();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10)); // 20 seconds timeout
	        WebElement element1 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='popupSec callbackthankyou activePopup']")));
	        System.out.println(element1.isDisplayed());
	    }
	    @Test()
	    public void Check_Lead_flow_Page12() throws InterruptedException, IOException {
	        System.out.println("Kedar Test travel-insurance-online/bharat-bhraman-domestic-travel-insurance Pass");
	        driver.get("https://www.bajajallianz.com/travel-insurance-online/bharat-bhraman-domestic-travel-insurance.html");
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // 20 seconds timeout
	        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='callBack']")));
	        element.click();
	        WebElement FUllName= driver.findElement(By.xpath("//*[@class='lblinput callBackName inputChar']"));
	        FUllName.sendKeys("Dont call on this Number Its a testing lead");
	        WebElement MobileNumb= driver.findElement(By.xpath("//*[@class='lblinput callBackMobNumber inputNum']"));
	        //**************************
		       //new code to fetch excel data
			File file = new File("D:\\Daily Task Report\\ExcelSheet.xlsx");
			FileInputStream fis = new FileInputStream(file);
			XSSFWorkbook workbook = new XSSFWorkbook(fis); 
			XSSFSheet sheet = workbook.getSheetAt(0);
			XSSFRow col = sheet.getRow(10);
			XSSFCell cell = col.getCell(14);
			if (cell != null && cell.getCellType() == cell.CELL_TYPE_NUMERIC) { 
				double cellValue = cell.getNumericCellValue();
				String formattedNumber = formatNumber(cellValue);
				System.out.println("Perfect Number: " + formattedNumber);
				MobileNumb.sendKeys(formattedNumber);
				} 
			else { System.out.println("Cell is not numeric or is empty."); }

	        //***************************
	       
	        WebElement Enquiry= driver.findElement(By.id("enqfor"));
	        Select enqry =new Select(Enquiry);
	        enqry.selectByVisibleText("Purchase");
	        WebElement Callbckbt= driver.findElement(By.xpath("//*[@class='btn'][text()='Call Back']"));
	        Callbckbt.click();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10)); // 20 seconds timeout
	        WebElement element1 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='popupSec callbackthankyou activePopup']")));
	        System.out.println(element1.isDisplayed());
	    }

	    @Test()
	    public void Check_Lead_flow_Page13() throws InterruptedException, IOException {
	        System.out.println("Kedar Test home-insurance/my-home-insurance Pass");
	        driver.get("https://www.bajajallianz.com/home-insurance/my-home-insurance.html");
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // 20 seconds timeout
	        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='callBack']")));
	        element.click();
	        WebElement FUllName= driver.findElement(By.xpath("//*[@class='lblinput callBackName inputChar']"));
	        FUllName.sendKeys("Dont call on this Number Its a testing lead");
	        WebElement MobileNumb= driver.findElement(By.xpath("//*[@class='lblinput callBackMobNumber inputNum']"));
	        //**************************
		       //new code to fetch excel data
			File file = new File("D:\\Daily Task Report\\ExcelSheet.xlsx");
			FileInputStream fis = new FileInputStream(file);
			XSSFWorkbook workbook = new XSSFWorkbook(fis); 
			XSSFSheet sheet = workbook.getSheetAt(0);
			XSSFRow col = sheet.getRow(11);
			XSSFCell cell = col.getCell(14);
			if (cell != null && cell.getCellType() == cell.CELL_TYPE_NUMERIC) { 
				double cellValue = cell.getNumericCellValue();
				String formattedNumber = formatNumber(cellValue);
				System.out.println("Perfect Number: " + formattedNumber);
				MobileNumb.sendKeys(formattedNumber);
				} 
			else { System.out.println("Cell is not numeric or is empty."); }

	        //***************************
	       
	        WebElement Enquiry= driver.findElement(By.id("enqfor"));
	        Select enqry =new Select(Enquiry);
	        enqry.selectByVisibleText("Purchase");
	        WebElement Callbckbt= driver.findElement(By.xpath("//*[@class='btn'][text()='Call Back']"));
	        Callbckbt.click();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10)); // 20 seconds timeout
	        WebElement element1 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='popupSec callbackthankyou activePopup']")));
	        System.out.println(element1.isDisplayed());
	    }
	    @Test()
	    public void Check_Lead_flow_Page14() throws InterruptedException, IOException {
	        System.out.println("Kedar Test commercial-insurance/engineering-insurance Pass");
	        driver.get("https://www.bajajallianz.com/commercial-insurance/engineering-insurance.html");
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40)); // 20 seconds timeout
	        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='callBack']")));
	        element.click();
	        WebElement FUllName= driver.findElement(By.xpath("//*[@class='lblinput callBackName inputChar']"));
	        FUllName.sendKeys("Dont call on this Number Its a testing lead");
	        WebElement MobileNumb= driver.findElement(By.xpath("//*[@class='lblinput callBackMobNumber inputNum']"));
	        //**************************
		       //new code to fetch excel data
			File file = new File("D:\\Daily Task Report\\ExcelSheet.xlsx");
			FileInputStream fis = new FileInputStream(file);
			XSSFWorkbook workbook = new XSSFWorkbook(fis); 
			XSSFSheet sheet = workbook.getSheetAt(0);
			XSSFRow col = sheet.getRow(12);
			XSSFCell cell = col.getCell(14);
			if (cell != null && cell.getCellType() == cell.CELL_TYPE_NUMERIC) { 
				double cellValue = cell.getNumericCellValue();
				String formattedNumber = formatNumber(cellValue);
				System.out.println("Perfect Number: " + formattedNumber);
				MobileNumb.sendKeys(formattedNumber);
				} 
			else { System.out.println("Cell is not numeric or is empty."); }

	        //***************************
	       
	        WebElement Enquiry= driver.findElement(By.id("enqfor"));
	        Select enqry =new Select(Enquiry);
	        enqry.selectByVisibleText("Purchase");
	        WebElement Callbckbt= driver.findElement(By.xpath("//*[@class='btn'][text()='Call Back']"));
	        Callbckbt.click();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20)); // 20 seconds timeout
	        WebElement element1 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='popupSec callbackthankyou activePopup']")));
	        System.out.println(element1.isDisplayed());
	    }
	    @Test()
	    public void Check_Lead_flow_Page15() throws InterruptedException, IOException {
	        System.out.println("Kedar Test pet-insurance/dog-insurance Pass");
	        driver.get("https://www.bajajallianz.com/pet-insurance/dog-insurance.html");
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // 20 seconds timeout
	        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='callBack']")));
	        element.click();
	        WebElement FUllName= driver.findElement(By.xpath("//*[@class='lblinput callBackName inputChar']"));
	        FUllName.sendKeys("Dont call on this Number Its a testing lead");
	        WebElement MobileNumb= driver.findElement(By.xpath("//*[@class='lblinput callBackMobNumber inputNum']"));
	        //**************************
		       //new code to fetch excel data
	        
			File file = new File("D:\\Daily Task Report\\ExcelSheet.xlsx");
			FileInputStream fis = new FileInputStream(file);
			XSSFWorkbook workbook = new XSSFWorkbook(fis); 
			XSSFSheet sheet = workbook.getSheetAt(0);
			XSSFRow col = sheet.getRow(13);
			XSSFCell cell = col.getCell(14);
			if (cell != null && cell.getCellType() == cell.CELL_TYPE_NUMERIC) { 
				double cellValue = cell.getNumericCellValue();
				String formattedNumber = formatNumber(cellValue);
				System.out.println("Perfect Number: " + formattedNumber);
				MobileNumb.sendKeys(formattedNumber);
				} 
			else { System.out.println("Cell is not numeric or is empty."); }
	        //***************************
	     
	        WebElement Enquiry= driver.findElement(By.id("enqfor"));
	        Select enqry =new Select(Enquiry);
	        enqry.selectByVisibleText("Purchase");
	        WebElement Callbckbt= driver.findElement(By.xpath("//*[@class='btn'][text()='Call Back']"));
	        Callbckbt.click();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20)); // 20 seconds timeout
	        WebElement element1 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='popupSec callbackthankyou activePopup']")));
	        System.out.println(element1.isDisplayed());
	    }
	    @Test()
	    public void Check_Lead_flow_Page16() throws InterruptedException, IOException {
	        System.out.println("Kedar Test cyber-insurance Pass");
	        driver.get("https://www.bajajallianz.com/cyber-insurance.html");
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // 20 seconds timeout
	        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='callBack']")));
	        element.click();
	        WebElement FUllName= driver.findElement(By.xpath("//*[@class='lblinput callBackName inputChar']"));
	        FUllName.sendKeys("Dont call on this Number Its a testing lead");
	        WebElement MobileNumb= driver.findElement(By.xpath("//*[@class='lblinput callBackMobNumber inputNum']"));
	        //**************************
		       //new code to fetch excel data
			File file = new File("D:\\Daily Task Report\\ExcelSheet.xlsx");
			FileInputStream fis = new FileInputStream(file);
			XSSFWorkbook workbook = new XSSFWorkbook(fis); 
			XSSFSheet sheet = workbook.getSheetAt(0);
			XSSFRow col = sheet.getRow(14);
			XSSFCell cell = col.getCell(14);
			if (cell != null && cell.getCellType() == cell.CELL_TYPE_NUMERIC) { 
				double cellValue = cell.getNumericCellValue();
				String formattedNumber = formatNumber(cellValue);
				System.out.println("Perfect Number: " + formattedNumber);
				MobileNumb.sendKeys(formattedNumber);
				} 
			else { System.out.println("Cell is not numeric or is empty."); }

	        //***************************
	       
	        WebElement Enquiry= driver.findElement(By.id("enqfor"));
	        Select enqry =new Select(Enquiry);
	        enqry.selectByVisibleText("Purchase");
	        WebElement Callbckbt= driver.findElement(By.xpath("//*[@class='btn'][text()='Call Back']"));
	        Callbckbt.click();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20)); // 20 seconds timeout
	        WebElement element1 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='popupSec callbackthankyou activePopup']")));
	        System.out.println(element1.isDisplayed());
	    }
	    @Test()
	    public void Check_Lead_flow_Genaral_Page() throws InterruptedException, IOException {
	        System.out.println("Kedar Test general-insurance Pass");
	        driver.get("https://www.bajajallianz.com/general-insurance.html");
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // 20 seconds timeout
	        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='callBack']")));
	        element.click();
	        WebElement FUllName= driver.findElement(By.xpath("//*[@class='lblinput callBackName inputChar']"));
	        FUllName.sendKeys("Dont call on this Number Its a testing lead");
	        WebElement MobileNumb= driver.findElement(By.xpath("//*[@class='lblinput callBackMobNumber inputNum']"));
	        //**************************
		       //new code to fetch excel data
			File file = new File("D:\\Daily Task Report\\ExcelSheet.xlsx");
			FileInputStream fis = new FileInputStream(file);
			XSSFWorkbook workbook = new XSSFWorkbook(fis); 
			XSSFSheet sheet = workbook.getSheetAt(0);
			XSSFRow col = sheet.getRow(15);
			XSSFCell cell = col.getCell(14);
			if (cell != null && cell.getCellType() == cell.CELL_TYPE_NUMERIC) { 
				double cellValue = cell.getNumericCellValue();
				String formattedNumber = formatNumber(cellValue);
				System.out.println("Perfect Number: " + formattedNumber);
				MobileNumb.sendKeys(formattedNumber);
				} 
			else { System.out.println("Cell is not numeric or is empty."); }

	        //***************************
	      
	        WebElement Enquiry= driver.findElement(By.id("enqfor"));
	        Select enqry =new Select(Enquiry);
	        enqry.selectByVisibleText("Purchase");
	        WebElement Callbckbt= driver.findElement(By.xpath("//*[@class='btn'][text()='Call Back']"));
	        Callbckbt.click();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20)); // 20 seconds timeout
	        WebElement element1 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='popupSec callbackthankyou activePopup']")));
	        System.out.println(element1.isDisplayed());
	    }

	    @AfterClass()
	    public void Close_Browser() throws InterruptedException {
	        Thread.sleep(10000);
	        driver.close();
	    }

	}
