package ru.kpfu.itis.group403.yuskevich.fileManager;

import java.io.File;
import java.util.Scanner;


public class FileManager {

    File curentDir;//тут будет храниться текущая директория
    File[] lastSearch;//тут будет храниться результат последнего поиска
    String commandString;


    FileManager(){
        curentDir = new File("C:\\");
    }

    public static void main(String[] args){
//        FileManager mainTool = new FileManager();
//        Scanner scan = new Scanner(System.in);
//        while(mainTool.commandString.equals("/exit")){
//            mainTool.commandString = scan.nextLine();
//            mainTool.parse(stringToArray(mainTool.commandString));
//            System.out.println("Current Directory: " + mainTool.curentDir.getPath());
//            System.out.println("Type /help to display possible commands.");
//            
//        }
    	System.out.println("copy something".split(" ")[0]);

    }

    //ниже вспомогательные методы
    //переходит в выбранную директорию, хотя можно совместить с методом open нижк
    //void cd(String dir){
    //
    //}

    //разбивает строку на массив слов для удобства
    static String[] stringToArray(String command){
//        int spase = 1;
//        for(int i = 0; i < command.length(); i++){
//            if(command.charAt(i)==' ')
//                spase++;
//        }
//        String[] words = new String[spase];
//        int word = 0;
//        for(int i = 0; i < command.length();i++){
//            if(command.charAt(i)==' ')
//                word++;
//            else
//                words[word]+=command.charAt(i);
//        }
//       return  words;
    	return command.split(" ");
    }

    //анализирует команды,главный методод, вызывает нужные методы по командам, должен ругаться на совсем некоректные запросы
     void parse(String[] command){
        if(command[0].equals("/search")){
            if(command.length>4||command.length<3||(command.length==4&!command[3].equals("-folder")))
                synError();
            else{
                if(!this.correctPath(command[1]).exists())
                    pathError();
                else
                    search(this.correctPath(command[1]),command[2],command.length);
            }

        } else if(command[0].equals("/showsearch")){
            for(int i = 0; i < lastSearch.length;i++)
                System.out.println(lastSearch[i].getPath());

        } else if(command[0].equals("/copy")){
            if(check(command,2))
                copy(correctPath(command[1]));

        } else if(command[0].equals("/remove")){
            if(check(command,2))
                remove(correctPath(command[1]));

        } else if(command[0].equals("/open")){
            if(check(command,2))
                open(correctPath(command[1]));

        } else if(command[0].equals("/rename")){
            if(check(command,3))
                rename(correctPath(command[1]),command[2]);

        } else if(command[0].equals("/mkdir")){
            if(checkName(command[1]))
                mkdir(command[1]);

        } else if(command[0].equals("/mkfile")) {
            if (checkName(command[1]))
                mkdir(command[1]);

        }else if(command[0].equals("/back")){
                back();

        } else if(command[0].equals("/encode")){

        } else if(command[0].equals("/exit")){

        } else{
            System.out.println("Unknown command!");
        }

    }

    //возвращает пользователя в директорию выше(не назад, а именно на уровень выше)
    void back(){

    }

    //должен проверять имя файла на знаки \/|*?:<>"
    boolean checkName(String a){
        for(int i = 0; i < a.length();i++){
            if(a.charAt(i)=='/'||a.charAt(i)=='|'||a.charAt(i)=='*'||a.charAt(i)=='?'||
                    a.charAt(i)=='"'||a.charAt(i)=='<'||a.charAt(i)=='>'||a.charAt(i)==':')//????????????????
                return false;
        }
        return true;
    }

    //должен делать проверку комманд на соответствие числу слов количеству b и существование указанного файла
    boolean check(String[] a, int b){
        if(a.length!=b) {
            synError();
            return false;
        }else{
            if(!this.correctPath(a[1]).exists()) {
                pathError();
                return false;
            }else
                return true;
        }
    }
    //пользователь может ввести либо путь либо конкретное имя файла в текущей директории, этот метод распознает эти 2 случая
     File correctPath(String path){
        boolean directory = false;
        for(int i = 0; i < path.length();i++)
            if(path.charAt(i)=='/')//?????????????????????????????????
                directory = true;
        if(directory)
            return new File(path);
        else
            return new File(this.curentDir.getPath()+"/"+path);
    }

    //выводит сообщения, создал для сокращения копипасты
    void synError(){
        System.out.println("Wrong command syntax!");
    }
    void pathError(){
        System.out.println("Wrong path or file name!");
    }

    //просто выводит перечень методов и моответствующии команды с кратким описанием
    void help(){
        System.out.println("/search 'folder name of path to folder' 'tag' ('-folder') - search file or folder if directory");
        System.out.println("/showsearch - show last search result");
        System.out.println("/copy 'filename of path to file' - create copy of file");
        System.out.println("/mkdir 'name' - create directory in current directory");
        System.out.println("/mkfile 'name' - create file in current directory");
        System.out.println("/remove 'filename of path to file' - delete file or folder");
        System.out.println("/open 'filename of path to file' - open txt file or directory");
        System.out.println("/rename 'filename of path to file' 'new name' - rename file or folder");
        System.out.println("/encode ?????????");
        System.out.println("/exit - stop file manager");

    }






    //ниже методы которые нам надо реализовать
    //ищет файлы по тэгу в указанной директории, f отвечает за вывод папок, должен ругаться на не существующую директорию
    //можно добавить аналог show in folder по индексу после поиска
    File[] search(File directory, String tag, int f){
        return null;
    }
    File showSearch(){
       return null;
    }

    //копирует файл, должен ругаться на неусществующий файл
    void copy(File file){
    }

    //создает директорию в текущей папке, должен ругаться на \/|*?:<>" в название
    void mkdir(String name){

    }

    //создает файл в текущей папке, должен ругаться на \/|*?:<>" в название
    void mkfile(String name){

    }

    //открывает файл, должен ругаться на несуществующий файл
    void open(File file){

    }

    //same
    void rename(File file, String newName){

    }

    //same
    void remove(File file){

    }

    //меняет кодировку на выбранную, тоже ругается на несуществующую команду
    void changeEncoding(String encode){

    }


   
}
