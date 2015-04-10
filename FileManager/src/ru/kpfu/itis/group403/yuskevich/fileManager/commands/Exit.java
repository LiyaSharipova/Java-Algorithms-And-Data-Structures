package ru.kpfu.itis.group403.yuskevich.fileManager.commands;

import java.util.Scanner;

import ru.kpfu.itis.group403.yuskevich.fileManager.classes.Helper;
import ru.kpfu.itis.group403.yuskevich.fileManager.classes.WrongInputException;
import ru.kpfu.itis.group403.yuskevich.fileManager.interfaces.Command;
import ru.kpfu.itis.group403.yuskevich.fileManager.interfaces.DirChanger;

/**
 * Created by Ian on 01.04.2015.
 */
public class Exit implements Command{
	public Exit(Scanner sc) {
		super();
		this.sc = sc;
	}

	private String[] commandWords;
	private Scanner sc;
	public void init(String command) {
		String[] words=command.split(" ");
		commandWords=new String[words.length-1];
		System.arraycopy(words, 1, commandWords, 0, words.length-1);
	} 

	@Override
	public String keyWord() {
		return "/exit";
	}

	@Override
	public boolean check(String command) throws WrongInputException {
		String[] words=command.split(" ");
		return  Helper.checkLength(1, words);
	}

	@Override
	public boolean  execute() {
          sc.close();
          return false;
	}
}
