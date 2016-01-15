package com.jabgibson.handler;

import com.jabgibson.core.Properties;
import com.jabgibson.util.RqRsUtil;

import spark.Request;
import spark.Response;

public class RootHandler {

	private Request rq;
	private Response rs;

	public RootHandler(Request rq, Response rs) {
		this.rq = rq;
		this.rs = rs;
	}
	
	public static RootHandler instance(Request rq, Response rs) {
		return new RootHandler(rq, rs);
	}
	
	public String get() {
		if (!RqRsUtil.isAuthorizedBasic(Properties.USER, Properties.PASS, rq.headers("authorization"))) {
			rs.status(404);
			return "";
		}
		
		String body = "Hello. This is a test service";
		
		return body;
	}
}
