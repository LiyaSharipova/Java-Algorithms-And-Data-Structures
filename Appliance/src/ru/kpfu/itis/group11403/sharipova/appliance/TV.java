package ru.kpfu.itis.group11403.sharipova.appliance;


public class TV extends Appliance{
	private double diag;
	public TV (double price, double weight, double power,String model, double diag){
		super(price, weight, power, model);
		this.diag=diag;
	}
	public double getRating(){
		double rating=(1000/price+100/weight+ power*100)*diag/100;
		return rating;
	}

}
