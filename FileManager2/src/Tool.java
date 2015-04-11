﻿package ru.kpfu.itis.group403.yuskevich.fileManager.classes;

import java.io.File;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Ian on 01.04.2015.
 */
public class Tool {
	public static boolean checkName(String a){
		Pattern p = Pattern.compile("[^(\\/|*?:<>)]+");  
		Matcher m = p.matcher(a);  
		if( m.matches())  
			return true;
		return false;
	}
    public static String[] split(String command){
        int spase = 1;
        boolean marks = false;
        for(int i = 0; i < command.length(); i++){
            if(command.charAt(i)=='"')
                marks = !marks;
            if(!marks&&command.charAt(i)==' ')
                    spase++;
        }
        String[] words = new String[spase];
        for(int i = 0;i < words.length;i++)
            words[i] = "" ;
        int element = 0;
        for(int i = 0; i < command.length();i++){
            if(command.charAt(i)=='"'){
                marks = !marks;
                if(i==command.length()-1)
                    break;
                i++;
            }
            if(!marks&&command.charAt(i)==' ')
                element++;
            else {
                    words[element] += command.charAt(i);
            }
        }
        return  words;
    }

	//должен проверять имя файла на знаки \/|*?:<>"
	public static boolean checkName(String a){
		//		for(int i = 0; i < a.length();i++){
		//			if(a.charAt(i)=='/'||a.charAt(i)=='|'||a.charAt(i)=='*'||a.charAt(i)=='?'||
		//					a.charAt(i)=='"'||a.charAt(i)=='<'||a.charAt(i)=='>'||a.charAt(i)=='\\'||a.charAt(i)==':')
		//				return false;
		//		}.*+//*+.*+(/*)*+.*$
		//		return true;
		Pattern p = Pattern.compile("[^(\\/|*?:<>)]+");  
		Matcher m = p.matcher(a);  
		if( m.matches())  
			return true;
		return false;
	}


	//пользователь может ввести либо путь либо конкретное имя файла в текущей директории, этот метод распознает эти 2 случая
	public static File correctPath(String path,File dir ){
		Pattern p = Pattern.compile("^C:\\\\+.*$");  
		Matcher m = p.matcher(path);  
		if( m.matches())  
			return new File(path);
		else
			return new File(dir.getPath()+File.separator+path);
	}

	public static boolean checkLength(int length, String[] commandWords) throws IllegalArgumentException {
		if(commandWords.length==length){
			return true;
		}
		String options="";
		for (int i = length; i < commandWords.length; i++) {
			options+=commandWords[i]+" ";
		}
		throw new IllegalArgumentException("Extra option(s): "+ options) ;// выводит только лишние слова

	}

	public static void main(String[] args) {

		String test = "one \"two two\" three four \"five five five\" six seven \"eight\" \"nine ten\"";

        String[] testResult = split(test);

        for(int i = 0; i < testResult.length; i++){
            System.out.println(testResult[i]);
        }
		
	}
}
