package ru.kpfu.itis.group403.yuskevich.fileManager.commands;

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

import ru.kpfu.itis.group403.yuskevich.fileManager.classes.Tool;
import ru.kpfu.itis.group403.yuskevich.fileManager.interfaces.Command;
import ru.kpfu.itis.group403.yuskevich.fileManager.interfaces.DirChanger;

public class ChangeEncoding implements Command {
	private String[] commandWords;
	private DirChanger dirChanger;
	private File file;
	private String from, to;
	@Override
	public void init(String command) {
		String[] words = Tool.split(command);
		file= Tool.correctPath(words[1], dirChanger.getDir());
		from=words[2];
		to=words[3];
	} 

	

	@Override
	public String keyWord() {
		// TODO Auto-generated method stub
		return "/encode";
	}

	@Override
	public boolean check(String command){
		String[] words = Tool.split(command);
	    return Tool.checkLength(4, words);
	}

	
	@Override
	public boolean  execute() throws IOException {
		String path=file.getPath();
		File dir=new File(path.substring(0, path.lastIndexOf(File.separatorChar)));
		File temp = File.createTempFile("temp", ".txt", dir);
		char[] buffer=new char[4096];
		int len;
		try (   InputStream in=new FileInputStream(file);
				Reader r=new BufferedReader(new InputStreamReader(in, from));
				OutputStream out=new FileOutputStream(temp);
				Writer w=new BufferedWriter(new OutputStreamWriter(out, to));){
			
			while((len=r.read(buffer)) != -1)
				w.write(buffer, 0, len);
		}
		catch(IOException e){
			throw e;
		}
		file.delete();
		temp.renameTo(Tool.correctPath(path, dirChanger.getDir()));
		 return true;
	}

	public ChangeEncoding(DirChanger dirChanger) {
		super();
		this.dirChanger = dirChanger;
	}

}
