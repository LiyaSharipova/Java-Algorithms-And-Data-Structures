package ru.kpfu.itis.group403.yuskevich.fileManager.interfaces;

import java.io.File;
import java.io.IOException;
import java.nio.file.NoSuchFileException;

import ru.kpfu.itis.group403.yuskevich.fileManager.classes.NoSuchCommandException;

/**
 * Created by Ian on 30.03.2015.
 */
public interface Command {
	void init(String command)throws NoSuchFileException;
    String keyWord();// возвращает ключивое слово типа "/copy"
    boolean check(String command) throws IllegalArgumentException;//проверяет корректность строки
    //проверяет пути до файла, существует ли такой файл

    boolean execute() throws IOException;//выполняет

}
