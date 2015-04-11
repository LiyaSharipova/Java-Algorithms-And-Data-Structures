package ru.kpfu.itis.group403.yuskevich.fileManager.classes;

import java.nio.file.NoSuchFileException;
import java.util.Scanner;

import ru.kpfu.itis.group403.yuskevich.fileManager.commands.*;
import ru.kpfu.itis.group403.yuskevich.fileManager.interfaces.Command;
import ru.kpfu.itis.group403.yuskevich.fileManager.interfaces.DirChanger;


public class CommandFactory {
    private Command[] allCommands;

    public CommandFactory(DirChanger dirChanger, Scanner sc){
        allCommands = new Command[10];
        allCommands[0] = new Exit(sc);
        allCommands[1] = new Open(dirChanger);
        allCommands[2] = new Back(dirChanger);
        allCommands[3]= new Remove(dirChanger);
        allCommands[4]= new ChangeEncoding(dirChanger);
        allCommands[5]=new Copy(dirChanger, sc);
        allCommands[6]= new Search(dirChanger);
        allCommands[7]= new Rename(dirChanger,sc);
        allCommands[8]= new Mkdir(dirChanger,sc);
        allCommands[9]= new Mkfile(dirChanger,sc);
    }
    public Command create(String commandString) throws NoSuchFileException, NoSuchCommandException{
    	commandString=commandString.trim();
        for(Command command: allCommands){
            if(Tool.split(commandString)[0].equals(command.keyWord())){
            	if(command.check(commandString)){
            		command.init(commandString);
                    return command;
            	}
            }
                
        }
        throw new NoSuchCommandException("wrong command name: "+  commandString.split(" ")[0] );
        
    }

}


