package ru.kpfu.itis.group403.yuskevich.fileManager.commands;

import ru.kpfu.itis.group403.yuskevich.fileManager.classes.Tool;
import ru.kpfu.itis.group403.yuskevich.fileManager.interfaces.Command;
import ru.kpfu.itis.group403.yuskevich.fileManager.interfaces.DirChanger;

import java.io.File;
import java.io.IOException;
import java.nio.file.NoSuchFileException;

/**
 * Created by Ian on 09.04.2015.
 */
public class Search implements Command {

    DirChanger dirChanger;
    boolean recursive = false;
    boolean folder = false;
    int depth = 1;
    File path;
    String name;

    public Search(DirChanger dirChanger){
        this.dirChanger = dirChanger;
    }

    @Override
    public void init(String command) throws NoSuchFileException{
        String[] words = Tool.split(command);
        path = Tool.correctPath(words[1], dirChanger.getDir());
        if(!path.exists())
            throw new NoSuchFileException("No such file: "+ path);
        else {
            name = words[2];
            for (int i = 3; i < words.length; i++) {
                if (words[i].equals("-f"))
                    folder = true;
                if (words[i].equals("-r"))
                    recursive = true;
                if (words[i].equals("-d"))
                    depth = Integer.parseInt(words[i + 1]);
            }
        }
    }

    @Override
    public String keyWord() {
        return "/search";
    }

    @Override
    public boolean check(String command) throws NumberFormatException, IllegalArgumentException {//дописать сообщения IllegalAE
        String[] words = Tool.split(command);
        if(words.length>6)
            throw new IllegalArgumentException("Too much options.");
        else if(words.length==6){
            if(words[3].equals("-f")&&words[4].equals("-d")) {
                try {
                    Integer.parseInt(words[5]);
                }catch (NumberFormatException e){
                    throw e;
                }
                return true;
            } else
                throw new IllegalArgumentException("Incorrect options");
        } else  if(words.length==5){
            if(words[3].equals("-f")&&words[4].equals("-r"))
                return true;
            else if(words[3].equals("-d")){
                try {
                    Integer.parseInt(words[4]);
                }catch (NumberFormatException e){
                    throw e;
                }
                return true;
            } else
                throw new IllegalArgumentException("Incorrect options");
        } else  if(words.length==4)
            if(words[3].equals("-r"))
                return true;
            else
                throw new IllegalArgumentException("Incorrect options");
        throw new IllegalArgumentException("Not much options");
    }

    @Override
    public boolean execute() throws IOException {

        File directory = path;
        File[] inDirectory = directory.listFiles();
        if (inDirectory!=null) {
            depth--;
            for (int i = 0; i < inDirectory.length; i++) {
                if (check(inDirectory[i].getName(), name)) {
                    if ((inDirectory[i].isDirectory() & folder)
                            || !(inDirectory[i].isDirectory())) {
                        System.out.println(inDirectory[i].getPath() + " " + inDirectory[i].getName());
                    }
                }
                path = inDirectory[i];
                if ((depth > 0) || recursive)
                    this.execute();
            }
        }
        return true;

    }

    public boolean check(String name, String tag){
        int letters = 0;
        int i = 0;
        while((letters != tag.length())&&(i!=name.length()-1)){
            if(name.charAt(i)==tag.charAt(letters))
                letters++;
            else
                letters = 0;
            i++;
        }
        return (letters==tag.length());
    }


}
