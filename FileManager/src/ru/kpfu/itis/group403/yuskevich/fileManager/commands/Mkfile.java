package ru.kpfu.itis.group403.yuskevich.fileManager.commands;

import java.io.File;
import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.util.Scanner;

import ru.kpfu.itis.group403.yuskevich.fileManager.classes.Tool;
import ru.kpfu.itis.group403.yuskevich.fileManager.interfaces.Command;
import ru.kpfu.itis.group403.yuskevich.fileManager.interfaces.DirChanger;

public class Mkfile implements Command {
	private DirChanger dirChanger;
	private Scanner sc;
	private String fileName;

	public Mkfile(DirChanger dirChanger, Scanner sc) {
		super();
		this.dirChanger = dirChanger;
		this.sc = sc;
	}

	private String[] commandWords;
	@Override
	public void init(String command) {
		String[] words = Tool.split(command);
		fileName=words[1];
	} 


	@Override
	public String keyWord() {
		// TODO Auto-generated method stub
		return "/mkfile";
	}

	@Override
	public boolean check(String command) throws IllegalArgumentException {
		String[] words = Tool.split(command);
		return  Tool.checkLength(2, words);
	}

	@Override
	public boolean  execute() throws IOException {
		File file=Tool.correctPath(fileName, dirChanger.getDir());
		if(file.createNewFile()){
			return true;
		}
		boolean f=false;
		System.out.println("The file with this name aiready exists.Type 'R'/'C' to replace/cancel ");
		while(!f){
			try{
				String mark=sc.nextLine();
				if(mark.equalsIgnoreCase("R")){							
					f=true;
					new Remove(dirChanger).deleteDirectory(file);
					file.createNewFile();
				}
				else if(mark.equalsIgnoreCase("C")){
					return true;
				}
				else throw new IllegalArgumentException("Wrong input");
			}
			catch(IllegalArgumentException e){
				System.err.println(e.getMessage());
			}
		}
		return true;
	}


}
