package com.jbk.utilites;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class PageBase {
	public Logger log;

	public Logger pageLogs() {
		log = Logger.getLogger(this.getClass());
		String path = (System.getProperty("user.dir") + "/log4jPage.properties");
		PropertyConfigurator.configure(path);
		return log;
	}

}
