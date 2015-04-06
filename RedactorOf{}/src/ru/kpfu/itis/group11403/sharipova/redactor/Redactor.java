package ru.kpfu.itis.group11403.sharipova.redactor;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;


public class Redactor  {
	public static void edit(File from, File to) {
		try(InputStream in=new FileInputStream(from);
				BufferedReader r=new BufferedReader(new InputStreamReader(in));
				OutputStream out=new FileOutputStream(to);
				Writer w=new BufferedWriter(new OutputStreamWriter(out, "UTF-8"));){
			String prLine=r.readLine();
			String curLine;
			while((curLine=r.readLine())!=null){
				if(curLine.trim().equals("{")){
					w.write(prLine+"{\r\n");
					prLine=r.readLine();
				}
				else{
					w.write(prLine+"\r\n");
					prLine=curLine;
				
				}
			}
			w.write(prLine);
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		edit(new File("check.txt"), new File("check1.txt"));

	}

}
