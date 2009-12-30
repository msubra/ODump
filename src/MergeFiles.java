

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

public class MergeFiles {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		File f = new File("C:/maheshexp/My Documents/Stock Data1");
		File[] files = f.listFiles();
		
		FileOutputStream fs = new FileOutputStream("Stock-All.csv");
		BufferedOutputStream bos = new BufferedOutputStream(fs);
		
		for (int i = 0; i < files.length; i++) {
			FileInputStream fis = new FileInputStream(files[i]);
			System.out.println("Reading: " + files[i] );
			byte x = -1;
			
			try {
				while( (x = (byte) fis.read()) != -1 )
				{
					fs.write(x);
				}
				fis.close();
			} catch (IOException e) {
				
			}
						
		}
		
		try {
			fs.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	
}
