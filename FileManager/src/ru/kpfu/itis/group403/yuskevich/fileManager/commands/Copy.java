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
import java.util.Scanner;

import ru.kpfu.itis.group403.yuskevich.fileManager.classes.Tool;
import ru.kpfu.itis.group403.yuskevich.fileManager.classes.WrongInputException;
import ru.kpfu.itis.group403.yuskevich.fileManager.interfaces.Command;
import ru.kpfu.itis.group403.yuskevich.fileManager.interfaces.DirChanger;

public class Copy implements Command {
	private Scanner sc;
	private DirChanger dirChanger;
	private File file, copyDir;
	public Copy( DirChanger dir, Scanner sc) {
		super();
		this.sc = sc;
		this.dirChanger = dir;
	}

	@Override
	public void init(String command) {
		String[] words = Tool.split(command);
		file=Tool.correctPath(words[1], dirChanger.getDir());
		copyDir=Tool.correctPath(words[2], dirChanger.getDir());
	}

	@Override
	public String keyWord() {
		return "/copy";
	}

	@Override
	public boolean check(String command) throws IllegalArgumentException {
		String[] words = Tool.split(command);
		return  Tool.checkLength(3, words);
	}

	@Override
	public boolean  execute() throws IOException {
		if(!(file.exists()&&
				copyDir.exists())){
			throw new NoSuchFileException("no such file: "+ 
					file.getPath()+" or "+ copyDir.getPath());
		}
		File copyFile;
		String path=file.getPath();
		String fileName=path.substring(path.lastIndexOf(File.separatorChar)+1);
		File fileDir=new File(path.substring(0, path.lastIndexOf(File.separatorChar)+1));

		if (fileDir.equals(copyDir)){
			copyFile=new File(rightName(path));
		}
		else{
			String copyPath=copyDir.getPath()+'\\'+fileName;
			copyFile=new File(copyPath);
			if (copyFile.exists()){
				boolean f=false;
				System.out.println("The file with this name aiready exists.Type 'R'/'C' to replace/copy ");
				while(!f){
					try{
						String mark=sc.nextLine();
						if(mark.equalsIgnoreCase("R")){							
							f=true;
						}
						else if(mark.equalsIgnoreCase("C")){
							copyFile=new File(rightName(copyPath));
							f=true;
						}
						else throw new IllegalArgumentException("Wrong input");
					}
					catch(IllegalArgumentException e){
						System.err.println(e.getMessage());
					}
				}
			}
			else{
				copyFile=new File(rightName(copyPath));
			}				
		}
		char[] buffer=new char[4096];
		int len;
		try (   InputStream in=new FileInputStream(file);
				Reader r=new BufferedReader(new InputStreamReader(in));
				OutputStream out=new FileOutputStream(copyFile);
				Writer w=new BufferedWriter(new OutputStreamWriter(out));){

			while((len=r.read(buffer)) != -1)
				w.write(buffer, 0, len);
		}
		catch(IOException e){
			throw e;
		}

		return true;
	}
	private String rightName(String path){
		StringBuffer copyFileName= new StringBuffer(path);
		int i=2;
		copyFileName=copyFileName.insert(path.lastIndexOf('.'),"_copy");
		if(new File(copyFileName.toString()).exists()){
			copyFileName=copyFileName.insert(copyFileName.toString().lastIndexOf('.'),"(1)");
		}
		if(new File(copyFileName.toString()).exists()){
			while(new File(copyFileName.toString()).exists()){
				copyFileName=copyFileName.replace(copyFileName.toString().lastIndexOf('(')+1,
						copyFileName.toString().lastIndexOf(')') , Integer.toString(i));
				i++;
			}
		}
		return copyFileName.toString();
	}

}
