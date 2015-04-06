import java.io.BufferedReader;
import java.io.FileReader;


public class Redactor  {

	try(BufferedReader br= new BufferedReader(new FileReader("in.c"))){
		String line;
		while((line=br.readLine())!=null){
			System.out.println(line);
		}
	}
	public static void main(String[] args) {
		
	}

}
