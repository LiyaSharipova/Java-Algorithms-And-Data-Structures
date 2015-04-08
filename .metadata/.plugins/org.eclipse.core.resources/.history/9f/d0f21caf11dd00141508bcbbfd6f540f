package ru.kpfu.itis.group403.yuskevich.fileManager.commands;

import java.io.IOException;
import java.nio.file.NoSuchFileException;

import ru.kpfu.itis.group403.yuskevich.fileManager.classes.Helper;
import ru.kpfu.itis.group403.yuskevich.fileManager.interfaces.Command;
import ru.kpfu.itis.group403.yuskevich.fileManager.interfaces.DirChanger;

public class Help implements Command {


	@Override
	public String keyWord() {
		return "/help";
	}

	@Override
	public boolean check(String command, DirChanger dir)
			throws NoSuchFileException, IllegalArgumentException {
		return  Helper.checkLength(1, command);
	}

	@Override
	public void execute(String command, DirChanger dirChanger)
			throws IOException {
		System.out.println("/search 'folder name of path to folder' 'tag' ('-folder') - search file or folder if directory");
		System.out.println("/copy 'filename of path to file' 'directory for copy' - create copy of file");
		System.out.println("/mkdir 'name' - create directory in current directory");
		System.out.println("/mkfile 'name' - create file in current directory");
		System.out.println("/remove 'filename of path to file' - delete file or folder");
		System.out.println("/open 'filename of path to file' - open txt file or directory");
		System.out.println("/rename 'filename of path to file' 'new name' - rename file or folder");
		System.out.println("/encode ?????????");
		System.out.println("/exit - stop file manager");
	}

}
