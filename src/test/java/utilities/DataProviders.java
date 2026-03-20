package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	//DataProvider 1
	
	@DataProvider(name="LoginData")
	public String [][]getData()throws IOException{
		
		String path= ".\\testData\\login_data.xlsx"; 
		
		ExcelUtility xlUtility=new ExcelUtility(path);
		
		int totalrows=xlUtility.getRowCount("Sheet1");
		int totalcols=xlUtility.getCellCount("Sheet1", 1);
		
		String logindata[][]=new String[totalrows][totalcols];
		
		for(int i=1;i<=totalrows;i++) 
		{
			for(int j=0;j<totalcols;j++) 
			{
				logindata[i-1][j]=xlUtility.getCellData("Sheet1", i, j);  
			}
		}
		return logindata; 

}
}
