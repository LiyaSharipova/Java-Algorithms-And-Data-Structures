package ru.kpfu.itis.group403.yuskevich.fileManager.commands;

import ru.kpfu.itis.group403.yuskevich.fileManager.interfaces.Command;
import ru.kpfu.itis.group403.yuskevich.fileManager.interfaces.DirChanger;

public class Start implements Command {

	@Override
	public String keyWord() {
		// TODO Auto-generated method stub
		return "/start";
	}

	@Override
	public boolean check(String command, DirChanger dir) throws IllegalArgumentException {
		if (command.split(" ").length==1){
			return true;
		}
		String[] words = command.split(" ");
		String options=command.substring(words[0].length());// ������ �����
		throw new IllegalArgumentException("wrong options: "+ options) ;
	}

	@Override
	public void execute(String command, DirChanger dirChanger) {
		// TODO Auto-generated method stub

	}

}
