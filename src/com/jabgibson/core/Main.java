package com.jabgibson.core;

import spark.servlet.SparkApplication;

public class Main implements SparkApplication {
	private final String VERSION = "0.1";

	@Override
	public void init() {
		
		// Do some other init stuff before routes are made, I think routes comes last
		Routes.go(VERSION);
		
	}
}
