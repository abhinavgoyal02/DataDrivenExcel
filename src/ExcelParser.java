import java.io.File;
import java.io.IOException;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class ExcelParser {
	private String filePath;
	private String[][] loginDataArray;
	
	public ExcelParser(String p_filePath){
		this.filePath = p_filePath;
	}
	
	public String[][] myExcelParser() throws Exception, IOException {
		File myExcelFile = new File(this.filePath);
		Workbook objWorkbook = Workbook.getWorkbook(myExcelFile);
		Sheet objSheet = objWorkbook.getSheet(0);
		int ncol = objSheet.getColumns();
		int nrow = objSheet.getRows();
		
		loginDataArray = new String[ncol][nrow];
		
		for (int row=0; row < nrow; row++)
		{
			for (int col=0; col < ncol; col++){
				Cell objCell = objSheet.getCell(col,row);
				//System.out.println(objCell.getContents());
				loginDataArray[col][row] = objCell.getContents();
			}
		}
		return loginDataArray;
	}
}
