package RequestCall;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.Duration;

import org.apache.poi.ss.usermodel.Cell;
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
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PRACTICE1221 {

	 private static final String CellType = null;
	WebDriver driver;
	 @SuppressWarnings("deprecation")
		public static String formatNumber(double row) {

		        // Remove scientific notation and ensure full number representation
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
		WebElement MobileNumb= driver.findElement(By.xpath("//*[@class='lblinput callBackMobNumber inputNum']"));
		
		File file = new File("D:\\Daily Task Report\\ExcelSheet.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fis); 
		XSSFSheet sheet = workbook.getSheetAt(0);
		XSSFRow col = sheet.getRow(1);
		XSSFCell cell = col.getCell(0);
		if (cell != null && cell.getCellType() == cell.CELL_TYPE_NUMERIC) { 
			double cellValue = cell.getNumericCellValue();
			String formattedNumber = formatNumber(cellValue);
			System.out.println("Perfect Number: " + formattedNumber);
			MobileNumb.sendKeys(formattedNumber);
			} 
		else { System.out.println("Cell is not numeric or is empty."); }
       
       
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
}
