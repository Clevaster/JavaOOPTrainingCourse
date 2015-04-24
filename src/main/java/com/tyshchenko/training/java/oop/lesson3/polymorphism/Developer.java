package com.tyshchenko.training.java.oop.lesson3.polymorphism;

/**
 * @author Alexander Tyshchenko.
 */
public abstract class Developer {

	protected String name;
	protected double basicSalary;
	protected int experience;
	
	public Developer(String name, double basicSalary, int experience) {
		this.name = name;
		this.basicSalary = basicSalary;
		this.experience = experience;
	}
	
	public String getName() {
		return name;
	}
	
	public double getBasicSalary() {
		return basicSalary;
	}
	
	public abstract double getSalary();
}
