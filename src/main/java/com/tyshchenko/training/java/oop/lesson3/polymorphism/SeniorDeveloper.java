package com.tyshchenko.training.java.oop.lesson3.polymorphism;

/**
 * @author Alexander Tyshchenko.
 */
public class SeniorDeveloper extends Developer {

	public SeniorDeveloper(String name, int basicSalary, int experience) {
		super(name, basicSalary, experience);
	}

	@Override
	public double getSalary() {
		return (basicSalary * 2) + (experience > 0 ? basicSalary * experience * 0.1 : 0);
	}
}
