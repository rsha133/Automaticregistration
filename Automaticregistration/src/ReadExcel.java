import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public static void main(String[] args) throws IOException {
		File file = new File("C:\\Users\\rshar133\\Desktop\\member registration.xlsx");
		FileInputStream fis = new FileInputStream(file);

		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sh = wb.getSheetAt(0);
		String a = sh.getRow(0).getCell(0).toString();
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.println(sh.getRow(i).getCell(j).toString());
			}
		}

	}
}




