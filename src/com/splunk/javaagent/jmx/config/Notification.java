package com.splunk.javaagent.jmx.config;

import javax.xml.bind.annotation.XmlAttribute;

/**
 * POJO for an MBean notification
 * 
 * @author Damien Dallimore damien@dtdsoftware.com
 * 
 */
public class Notification {

	private String filterImplementationClass;

	public Notification() {
	}

	@XmlAttribute(name="filterImplementationClass")
	public String getFilterImplementationClass() {
		return filterImplementationClass;
	}

	public void setFilterImplementationClass(String filterImplementationClass) {
		this.filterImplementationClass = filterImplementationClass;
	}

}
