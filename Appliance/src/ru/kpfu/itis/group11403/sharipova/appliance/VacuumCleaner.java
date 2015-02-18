package ru.kpfu.itis.group11403.sharipova.appliance;


public class VacuumCleaner extends Appliance{
	private double volume;
	public VacuumCleaner (double price, double weight, double power, String model, double volume){
		super(price, weight, power, model);
		this.volume=volume;
	}
	public double getRating(){
		double rating=(price*1000+100/weight+ power*100)*volume/20;
		return rating;
	}
}
