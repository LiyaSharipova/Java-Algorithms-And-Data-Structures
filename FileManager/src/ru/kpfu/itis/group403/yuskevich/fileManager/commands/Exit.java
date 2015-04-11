package ru.kpfu.itis.group403.yuskevich.fileManager.commands;

import java.util.Scanner;

import ru.kpfu.itis.group403.yuskevich.fileManager.classes.Tool;
import ru.kpfu.itis.group403.yuskevich.fileManager.interfaces.Command;

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
	} 

	@Override
	public String keyWord() {
		return "/exit";
	}

	@Override
	public boolean check(String command) throws IllegalArgumentException {
		String[] words=command.split(" ");
		return  Tool.checkLength(1, words);
	}

	@Override
	public boolean  execute() {
          sc.close();
          return false;
	}
}
