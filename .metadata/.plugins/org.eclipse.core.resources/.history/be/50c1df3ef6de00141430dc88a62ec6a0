package ru.kpfu.itis.group403.yuskevich.fileManager.classes;

import java.io.File;
import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.util.Scanner;

import ru.kpfu.itis.group403.yuskevich.fileManager.commands.*;
import ru.kpfu.itis.group403.yuskevich.fileManager.interfaces.Command;
import ru.kpfu.itis.group403.yuskevich.fileManager.interfaces.DirChanger;



public class FileManager implements DirChanger {

	private File curDir;//тут будет храниться текущая директория


	FileManager(){
		curDir = new File("C:\\");
	}

	@Override
	public File getDir() {
		return curDir;
	}

	@Override
	public void setDir(File newDir) {
		curDir = newDir;
	}

	public static void main(String[] args){
		FileManager mainTool = new FileManager();
		Scanner scan = new Scanner(System.in);
		String cString = "command";
		CommandFactory factory = new CommandFactory(mainTool);
		Command command= new Start();
		while(!(command instanceof Exit)){
			try{
				System.out.println("Current Directory: " + mainTool.curDir.getPath());
				System.out.println("Type /help to display possible commands.");
				cString = scan.nextLine();
				command=factory.create(cString);
				command.execute();
			}
			catch(NoSuchCommandException| IllegalArgumentException| IOException e){
				System.err.println("Impossible to execute the command because:\n"+e.getMessage());
				e.printStackTrace();

			}
		}

		scan.close();
	}










	//
	//    //ниже методы которые нам надо реализовать
	//    //ищет файлы по тэгу в указанной директории, f отвечает за вывод папок, должен ругаться на не существующую директорию
	//    //можно добавить аналог show in folder по индексу после поиска
	//
	//
	//    //рпечатает дерево директорий
	//    void print(int deep){
	//
	//    }
	//
	//    //поиск
	//    File[] search(File directory, String tag, int f){
	//        return null;
	//    }
	//
	//    //копирует файл, должен ругаться на неусществующий файл
	//    void copy(File file, File dir){
	//
	//    }
	//
	//    //создает директорию в текущей папке, должен ругаться на \/|*?:<>" в название
	//    void mkdir(String name){
	//
	//    }
	//
	//    //создает файл в текущей папке, должен ругаться на \/|*?:<>" в название
	//    void mkfile(String name){
	//
	//    }
	//
	//    //открывает файл, должен ругаться на несуществующий файл
	//    void open(File file){
	//
	//    }
	//
	//    //same
	//    void rename(File file, String newName){
	//
	//    }
	//
	//    //same
	//    void remove(File file){
	//
	//    }
	//



}
