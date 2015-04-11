package ru.kpfu.itis.group403.yuskevich.fileManager.commands;

import ru.kpfu.itis.group403.yuskevich.fileManager.interfaces.Command;

import java.io.IOException;
import java.nio.file.NoSuchFileException;

/**
 * Created by Ian on 10.04.2015.
 */
public class Show implements Command{

    @Override
    public void init(String command) {

    }

    @Override
    public String keyWord() {
        return "/show";
    }

    @Override
    public boolean check(String command) throws  IllegalArgumentException {
        return false;
    }

    @Override
    public boolean execute() throws IOException {
        return false;
    }
}
