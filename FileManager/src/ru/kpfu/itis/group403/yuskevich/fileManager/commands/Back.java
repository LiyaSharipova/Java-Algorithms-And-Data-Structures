package ru.kpfu.itis.group403.yuskevich.fileManager.commands;

import java.io.File;

import ru.kpfu.itis.group403.yuskevich.fileManager.classes.Tool;
import ru.kpfu.itis.group403.yuskevich.fileManager.interfaces.Command;
import ru.kpfu.itis.group403.yuskevich.fileManager.interfaces.DirChanger;


public class Back implements Command {
	private DirChanger dirChanger;
	public void init(String command) {
    } 
	public Back(DirChanger dirChanger) {
		super(); 
		this.dirChanger =dirChanger;
	}

	@Override
	public String keyWord() {
		return "/back";
	}

	@Override
	public boolean check(String command) throws IllegalArgumentException {
		String[] words=command.split(" ");
		return Tool.checkLength(1, words);
	}

	@Override
	public boolean  execute() {
		String path = dirChanger.getDir().getPath();
		if(!path.equals("C:\\")) {
			for (int i = path.length() - 1; i >= 0;i--)
				if(path.charAt(i)=='\\') {
					path = path.substring(0, i);
					break;
				}
			dirChanger.setDir(new File(path));
		}
       return true;
	}

	
}
