import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class registration {
	ArrayList<String> list = new ArrayList<String>();
	ArrayList<String> list1 = new ArrayList<String>();
	ArrayList<String> list2 = new ArrayList<String>();
	ArrayList<String> list3 = new ArrayList<String>();
	ArrayList<String> list4 = new ArrayList<String>();
	ArrayList<String> list5 = new ArrayList<String>();

	public void data() throws IOException {
		// System.out.println("jnjhsdfvsdukv");

		FileInputStream file = new FileInputStream(new File("C:\\Users\\rshar133\\Desktop\\automation.xlsx"));

		// Create Workbook instance holding reference to.xlsx file
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet Sheet = workbook.getSheetAt(0);
		Iterator<Row> iterator = Sheet.iterator();
		Row nextRow = iterator.next();
		int rowCount = Sheet.getLastRowNum();
		int columnCount = nextRow.getLastCellNum();
		Cell cell = null;
		XSSFRow row;   
		DataFormatter formatter = new DataFormatter();

		// System.out.print(rowCount+"asdgh"+columnCount);
		for (int i = 0; i < 1; i++) {
			XSSFRow ro1 = Sheet.getRow(0);
			{
				for (int j = 0; j < columnCount; j++) {
					cell = ro1.getCell(j);
					String value = cell.getStringCellValue();
					// System.out.println(value);
					if (value.equalsIgnoreCase("Policy")) {
						int asd1 = cell.getColumnIndex();
						for (int j1 = 0; j1 <= rowCount; j1++) {
							XSSFRow row1 = Sheet.getRow(j1);
							cell = row1.getCell(asd1);
							// System.out.println(formatter.formatCellValue(Sheet.getRow(j1).getCell(asd1)));
							list.add(formatter.formatCellValue(Sheet.getRow(j1).getCell(asd1)));
						}
					}
					if (value.equalsIgnoreCase("Subscriber Id")) {
						int asd1 = cell.getColumnIndex();
						for (int j1 = 0; j1 <= rowCount; j1++) {
							XSSFRow row1 = Sheet.getRow(j1);
							cell = row1.getCell(asd1);
							// System.out.println(formatter.formatCellValue(Sheet.getRow(j1).getCell(asd1)));
							list1.add(formatter.formatCellValue(Sheet.getRow(j1).getCell(asd1)));
						}
					}
					if (value.equalsIgnoreCase("Last Name")) {
						int asd1 = cell.getColumnIndex();
						for (int j1 = 0; j1 <= rowCount; j1++) {
							XSSFRow row1 = Sheet.getRow(j1);
							cell = row1.getCell(asd1);
							// System.out.println(formatter.formatCellValue(Sheet.getRow(j1).getCell(asd1)));
							list2.add(formatter.formatCellValue(Sheet.getRow(j1).getCell(asd1)));
						}
					}
					if (value.equalsIgnoreCase("First Name")) {
						int asd1 = cell.getColumnIndex();
						for (int j1 = 0; j1 <= rowCount; j1++) {
							XSSFRow row1 = Sheet.getRow(j1);
							cell = row1.getCell(asd1);
							// System.out.println(formatter.formatCellValue(Sheet.getRow(j1).getCell(asd1)));
							list3.add(formatter.formatCellValue(Sheet.getRow(j1).getCell(asd1)));
						}
					}
					if (value.equalsIgnoreCase("DOB")) {
						int asd1 = cell.getColumnIndex();
						for (int j1 = 0; j1 <= rowCount; j1++) {
							XSSFRow row1 = Sheet.getRow(j1);
							cell = row1.getCell(asd1);
							// System.out.println(formatter.formatCellValue(Sheet.getRow(j1).getCell(asd1)));
							list4.add(formatter.formatCellValue(Sheet.getRow(j1).getCell(asd1)));
						}
					}
					if (value.equalsIgnoreCase("User Name")) {
						int asd1 = cell.getColumnIndex();
						for (int j1 = 0; j1 <= rowCount; j1++) {
							XSSFRow row1 = Sheet.getRow(j1);
							cell = row1.getCell(asd1);
							// System.out.println(formatter.formatCellValue(Sheet.getRow(j1).getCell(asd1)));
							list5.add(formatter.formatCellValue(Sheet.getRow(j1).getCell(asd1)));
						}
					}
				}

			}
		}
		int si = list.size();
		// System.out.print(si);
		/*
		 * for(int h=1;h<si;h++) { System.out.println(list.get(h));
		 * System.out.println(list1.get(h)); System.out.println(list2.get(h));
		 * System.out.println(list3.get(h)); System.out.println(list4.get(h)); }
		 */
	}

	public void member() throws InterruptedException {

		String url = "https://systest3.myuhc.com/member/prewelcome.do?currentLanguageFromPreCheck=en";
		System.out.println("Launching Firefox browser..");
		// WebDriver driver = new FirefoxDriver();
		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\rshar133\\Documents\\MyJabberFiles\\pchoudh5@corpimsvcs.com\\geckodriver.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", true);
		WebDriver driver = new FirefoxDriver(capabilities);
		driver.manage().window().maximize();
		driver.navigate().to(url);
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);

		driver.findElement(By.xpath(".//*[@id='hsid-login']/div[5]/p[2]/a")).click();

		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//*[@id='piFirstName']")).sendKeys(list3.get(1));

		driver.findElement(By.xpath(".//*[@id='piLastName']")).sendKeys(list2.get(1));

		driver.findElement(By.xpath(".//*[@id='piDoB']")).sendKeys(list4.get(1));

		driver.findElement(By.xpath(".//*[@id='registerWithMember']")).click();

		driver.findElement(By.xpath(".//*[@id='piMemberId4Myuhc']")).sendKeys(list1.get(1));

		driver.findElement(By.xpath(".//*[@id='piGroupNum4Myuhc']")).sendKeys(list.get(1));

		driver.findElement(By.xpath("html/body/div/div/div[2]/flex[2]/flex-content[1]/div/form/div/div[2]/p/button"))
				.click();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);

		String s = list3.get(1) + "_alpha_001";
		driver.findElement(By.xpath(".//*[@id='username']")).sendKeys(s);

		driver.findElement(By.xpath(".//*[@id='password']")).sendKeys("Test2day");

		driver.findElement(By.xpath(".//*[@id='confirmPassword']")).sendKeys("Test2day");

		driver.findElement(By.xpath(".//*[@id='email']")).sendKeys("rahul_sharma133@optum.com");

		driver.findElement(By.xpath(".//*[@id='confirmEmail']")).sendKeys("rahul_sharma133@optum.com");
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);

		driver.findElement(By.xpath(".//*[@id='secOption']")).sendKeys("security Questions");
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);

		driver.findElement(By.xpath(".//*[@id='q0']")).sendKeys("What was your first phone number?");
		driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);

		driver.findElement(By.xpath(".//*[@id='a0']")).sendKeys("testnumber");
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);

		driver.findElement(By.xpath(".//*[@id='q1']")).sendKeys("What is your best friend's name?");
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);

		driver.findElement(By.xpath(".//*[@id='a1']")).sendKeys("testname");
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);

		driver.findElement(By.xpath(".//*[@id='q2']")).sendKeys("What is your favorite color?");
		driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);

		driver.findElement(By.xpath(".//*[@id='a2']")).sendKeys("testcolor");

		driver.findElement(By.xpath(".//*[@id='remember']")).click();
		driver.findElement(By.xpath(".//*[@id='terms']")).click();
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);

		driver.findElement(
				By.xpath("html/body/div[1]/div/div[2]/flex[2]/flex-content[1]/div/div/form[3]/div[2]/p/button"))
				.click();

		/*
		 * System.out.println(list.get(i)); System.out.println(list1.get(i));
		 * System.out.println(list2.get(i)); System.out.println(list3.get(i));
		 * System.out.println(list4.get(i)); }
		 */
	}

	public static void main(String args[]) throws IOException, InterruptedException {
		registration r = new registration();
		r.data();
		r.member();
	}
}
