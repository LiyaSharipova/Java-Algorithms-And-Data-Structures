package ru.kpfu.itis.group11403.sharipova.student;

import java.util.Comparator;

public class StudentHelper {
	public Comparator compareByGrade(){
		return new Comparator(){

			@Override
			public int compare(Object o1, Object o2) {
				if((o1 instanceof Student)&&(o2 instanceof Student)){
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
	public Comparator compareByYear(){
		return new Comparator(){

			@Override
			public int compare(Object o1, Object o2) {
				if((o1 instanceof Student)&&(o2 instanceof Student)){
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
	public Comparator compareByName(){
		return new Comparator(){

			@Override
			public int compare(Object o1, Object o2) {
				if((o1 instanceof Student)&&(o2 instanceof Student)){
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


