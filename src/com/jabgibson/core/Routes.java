package com.jabgibson.core;

import static spark.Spark.get;

import com.jabgibson.handler.RootHandler;

public final class Routes {

	public static void go(String version) {
		get("/", (request, response) -> {
			return RootHandler.instance(request, response).get();
		});
		
		get("/version", (request, response) -> {
			return version;
		});
	}
}
