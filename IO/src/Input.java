import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.zip.ZipInputStream;


public class Input {
	//	private OutputStream outputStream;
	public static void main(String[] args) throws FileNotFoundException, IOException {
		DataInputStream inputStream = null;
		try {
			inputStream = new DataInputStream(new FileInputStream("in.txt"));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			DataOutputStream outputStream=new DataOutputStream(new FileOutputStream("in.txt"));
			outputStream.writeInt(5);

			outputStream.flush();
			int data =inputStream.readInt();
			outputStream.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		SortedMap<String,Charset> map= Charset.availableCharsets();
		Set<Entry<String, Charset>> entrySet= map.entrySet();
		for (Entry <String, Charset> entry: entrySet ) {
			String key=entry.getKey();
			Charset value=entry.getValue();
			System.out.println(key + "    " + value.displayName());
		}
		Charset cs= Charset.forName("KOI8-R");
		try(OutputStream out= new FileOutputStream("in.txt");

				Writer writer= new OutputStreamWriter(out, cs);
				){
            writer.write("dsnvjfvkjsftv");
		}
		String line="";
		try(BufferedReader br= new BufferedReader(new FileReader("in.txt"))){
			while((line=br.readLine())!=null){
				System.out.println(line);
			}
		}
		InputStream in;
		OutputStream out;
	        in=new FileInputStream("encode.txt");
	        Reader r=new BufferedReader(new InputStreamReader(in));
	    
	        out=new FileOutputStream("encode1.txt");
	    
//	   
	    
	    Writer w=new BufferedWriter(new OutputStreamWriter(out, "Unicode"));

	    // Copy characters from input to output.  The InputStreamReader
	    // converts from the input encoding to Unicode,, and the OutputStreamWriter
	    // converts from Unicode to the output encoding.  Characters that cannot be
	    // represented in the output encoding are output as '?'
	    char[] buffer=new char[4096];
	    int len;
	    while((len=r.read(buffer)) != -1)
	        w.write(buffer, 0, len);
	    r.close();
	    w.flush();
	    w.close();
	    new File("encode.txt").delete();
//	    File f= new File("encode1.txt");
	    boolean bol=new File("encode1.txt").renameTo(new File("encode.txt"));
	    File newFile= new File("new.txt");

	}


}
