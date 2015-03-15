package ru.kpfu.itis.group11403.sharipova.linkedlist;

import java.util.Comparator;

public class StudentHelper {
	public Comparator<Student> compareByGrade(){
		return new Comparator<Student>(){

			@Override
			public int compare(Student o1, Student o2) {
				if((o1!=null)&&(o2!=null)){
					Student first = (Student)o1;
					Student second = (Student)o2;	
					if(first.getGrade()-second.getGrade()<0){
						return -1;
					}   
					else if(first.getGrade()-second.getGrade() > 0){
						return 1;
					}
					return 0;  
				}

				else{return 0;}
			}			

		}
     ;
	}
	public Comparator<Student> compareByYear(){
		return new Comparator<Student>(){

			@Override
			public int compare(Student o1, Student o2) {
				if((o1!=null)&&(o2!=null)){
					Student first = (Student)o1;
					Student second = (Student)o2;	
					if(first.getYear()-second.getYear()<0){
						return -1;
					}   
					else if(first.getYear()-second.getYear() > 0){
						return 1;
					}
					return 0;  
				}

				else{return 0;}
			}			

		}
    ;
	}
	public Comparator<Student> compareByName(){
		return new Comparator<Student>(){

			@Override
			public int compare(Student o1, Student o2) {
				if((o1!=null)&&(o2!=null)){
					Student first = (Student)o1;
					Student second = (Student)o2;	
					return first.getName().compareTo(second.getName());		
				}

				else{return 0;}
			}			

		}
    ;
	}
}


