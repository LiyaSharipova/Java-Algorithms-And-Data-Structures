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
        String cString = "command";
        //		Command command= new Start(); !(command instanceof Exit)
        Command command;
        Scanner scan = new Scanner(System.in);
        boolean f=true;
        while(f){
            try{
                System.out.println("Current Directory: " + mainTool.curDir.getPath());
                System.out.println("Type /help to display possible commands.");
                cString = scan.nextLine();
                CommandFactory factory = new CommandFactory(mainTool, scan);
                command=factory.create(cString);
                f=command.execute();

            }
            catch(NoSuchCommandException| IllegalArgumentException| IOException  e){
                System.err.println("Impossible to execute the command because:\n"+e.getMessage());
                e.printStackTrace();

            }
        }
        scan.close();
    }


}
