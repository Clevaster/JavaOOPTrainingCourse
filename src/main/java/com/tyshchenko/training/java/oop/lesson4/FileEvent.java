package com.tyshchenko.training.java.oop.lesson4;

public class FileEvent implements FileEvenListener {

	@Override
	public void onFileAdded(String s) {
		System.out.println("File added: " + s);
	}

}
