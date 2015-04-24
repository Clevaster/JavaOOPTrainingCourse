package com.tyshchenko.training.java.oop.lesson3.polymorphism;

/**
 * @author Alexander Tyshchenko.
 */
public class JuniorDeveloper extends Developer {

	public JuniorDeveloper(String name, double basicSalary, int experience) {
		super(name, basicSalary, experience);
	}

	@Override
	public double getSalary() {
		return basicSalary + (experience > 0 ? basicSalary * experience * 0.1 : 0);
	}
}
