import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.zip.ZipInputStream;


public class Zip {
	InputStream inputStream;
	public static void readZip(){
		InputStream in=null;
		try {
			in = new FileInputStream("arch.zip");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ZipInputStream zip= new ZipInputStream(in);
	}
	public static void main(String[] args) {
		
	}
}
