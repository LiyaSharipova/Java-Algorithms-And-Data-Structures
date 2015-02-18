package ru.kpfu.itis.group11403.sharipova.appliance;
import java.util.*;


public class Appliance implements Comparable {
	double price, weight, power;
	String model;
	public static final double E=0.00000001;
	public Appliance(double price, double weight, double power, String model){
		this.price=price;
		this.weight=weight;
		this.power=power;
		this.model=model;

	}
	public double getRating(){
		double rating=1000/price+1000/weight+ power*100;
		return rating;
	}


	@Override
	// поменяла знаки, чтобы сортировалось по убыванию
	public int compareTo(Object obj) {
		Appliance tmp = (Appliance)obj;
		if(this.getRating()- tmp.getRating()> E){
			return -1;
		}   
		else if(this.getRating()-tmp.getRating() < E){
			return 1;
		}
		return 0;  
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Appliance[] appliance = new Appliance[4];
		appliance[0] = new VacuumCleaner(3000, 5, 230, "Vacuum cleaner 211",25);
		appliance[3] = new TV(1000, 8, 200, "TV 197", 10);
		appliance[1] = new Blender(2000, 2, 200, "Blender 3000");
		appliance[2] = new Toster(1000, 1.5, 200, "Toster 88");
		Arrays.sort(appliance);
		

		/* Печать отсортированных значений */

		for(int i = 0; i < appliance.length; i++)
		{
			System.out.println(appliance[i].getRating()+" "+ appliance[i].model);
		}

	}


}

