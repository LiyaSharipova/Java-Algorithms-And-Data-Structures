package ru.kpfu.itis.group403.yuskevich.fileManager.commands;

import ru.kpfu.itis.group403.yuskevich.fileManager.interfaces.Command;
import ru.kpfu.itis.group403.yuskevich.fileManager.interfaces.DirChanger;

/**
 * Created by Ian on 01.04.2015.
 */
public class Exit implements Command{

    @Override
    public String keyWord() {
        return "/exit";
    }

    @Override
    public boolean check(String command, DirChanger dir) {
    	if (command.split(" ").length==1){
			return true;
		}
		String[] words = command.split(" ");
		String options=command.substring(words[0].length());// ������ �����
		throw new IllegalArgumentException("wrong options: "+ options) ;
    }

    @Override
    public void execute(String command, DirChanger dirChanger) {

    }
}
