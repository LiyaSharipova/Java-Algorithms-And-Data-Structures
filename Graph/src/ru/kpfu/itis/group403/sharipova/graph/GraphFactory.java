package ru.kpfu.itis.group403.sharipova.graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

public class GraphFactory<V> {
	public static MyGraph<String> createGraph(String path) {
		MyGraph<String> gr= new MyGraph<String>();
		String len;
		try (   InputStream in=new FileInputStream(path);
				BufferedReader r=new BufferedReader(new InputStreamReader(in));
				){
			
			while((len=r.readLine()) != null){
				String[] names= len.split(" ");
				for (int i = 1; i < names.length; i++) {
					gr.add(names[0], names[i]);
				}
			}
				
		}
		catch(IOException e){
			e.printStackTrace();;
		}
		return gr;
	}
	public static void main(String[] args) {
		createGraph("friendship.txt").print();
		
	}

}
