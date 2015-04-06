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
import java.nio.file.NoSuchFileException;

import ru.kpfu.itis.group403.yuskevich.fileManager.classes.Helper;
import ru.kpfu.itis.group403.yuskevich.fileManager.interfaces.Command;
import ru.kpfu.itis.group403.yuskevich.fileManager.interfaces.DirChanger;

public class ChangeEncoding implements Command {



	@Override
	public String keyWord() {
		// TODO Auto-generated method stub
		return "/encode";
	}

	@Override
	public boolean check(String command, DirChanger dir)
			throws NoSuchFileException, IllegalArgumentException {
		// TODO Auto-generated method stub
		return true;
	}

	
	@Override
	public void execute(String command, DirChanger dirChanger) throws IOException {
		String[] words = command.split(" ");
		File file = Helper.correctPath(words[1], dirChanger.getDir());
		File temp = File.createTempFile("temp", ".txt", dirChanger.getDir());

		char[] buffer=new char[4096];
		int len;
		try (   InputStream in=new FileInputStream(file);
				Reader r=new BufferedReader(new InputStreamReader(in));
				OutputStream out=new FileOutputStream(temp);
				Writer w=new BufferedWriter(new OutputStreamWriter(out, words[2]));){
			
			while((len=r.read(buffer)) != -1)
				w.write(buffer, 0, len);
		}
		catch(IOException e){
			throw e;
		}
		boolean g=file.delete();
		boolean bol=temp.renameTo(Helper.correctPath(words[1], dirChanger.getDir()));


	}

}
