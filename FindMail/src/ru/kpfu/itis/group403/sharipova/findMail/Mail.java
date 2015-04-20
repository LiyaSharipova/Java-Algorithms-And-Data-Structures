package ru.kpfu.itis.group403.sharipova.findMail;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Mail {
	public static void makeMailList(String path) {
		try (   InputStream in=new FileInputStream(new File(path));
				BufferedReader r=new BufferedReader(new InputStreamReader(in, "UTF-8"));
				OutputStream out=new FileOutputStream("mailList.txt");
				Writer w=new BufferedWriter(new OutputStreamWriter(out, "UTF-8"));){
			String len;
			Pattern p = Pattern.compile(".+(mail\\.ru|gmail\\.com| yaslit\\.ru)");
			Matcher m ;  
			while((len=r.readLine()) != null){
				String[] words=len.split(" ");
				for (int i = 0; i < words.length; i++) {
					m = p.matcher(words[i]);
					if( m.matches()) 
						w.write(words[i]+" ");
				}


			}
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		makeMailList("in.txt");
	}
}
