package com.splunk.javaagent.jmx.config;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlAttribute;

/**
 * POJO for an MBean
 * 
 * For MBean definitions , standard JMX object name wildcard patterns * and ?
 * supported for the domain and properties string attributes
 * http://download.oracle
 * .com/javase/1,5.0/docs/api/javax/management/ObjectName.html
 * 
 * 
 * @author Damien Dallimore damien@dtdsoftware.com
 * 
 */

public class MBean {

	// MBean domain literal string or pattern
	private String domain = "";

	// MBean properties list string or pattern in "key=value, key2=value2"
	// format
	private String propertiesList = "";

	// if true, will dump all of the attributes for the MBean
	private boolean dumpAllAttributes;

	private List<Attribute> attributes;

	private Notification notification;

	private List<Operation> operations;

	public MBean() {
	}

	@XmlAttribute(name="domain")
	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	@XmlAttribute(name="properties")
	public String getPropertiesList() {
		return propertiesList;
	}

	public void setPropertiesList(String propertiesList) {
		this.propertiesList = propertiesList;
	}

	@XmlElement(name="attribute")
	public List<Attribute> getAttributes() {
		return attributes;
	}

	public void setAttributes(List<Attribute> attributes) {
		this.attributes = attributes;
	}

	@XmlElement(name="notificationListener")
	public Notification getNotification() {
		return notification;
	}

	public void setNotification(Notification notification) {
		this.notification = notification;
	}

	@XmlElement(name="operation")
	public List<Operation> getOperations() {
		return operations;
	}

	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}

	@XmlAttribute(name="dumpAllAttributes")
	public boolean isDumpAllAttributes() {
		return dumpAllAttributes;
	}

	public void setDumpAllAttributes(boolean dumpAllAttributes) {
		this.dumpAllAttributes = dumpAllAttributes;
	}

}
