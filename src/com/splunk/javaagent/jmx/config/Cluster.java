package com.splunk.javaagent.jmx.config;

import java.util.List;

/**
 * POJO for a cluster of JMX Servers
 * 
 * @author Damien Dallimore damien@dtdsoftware.com
 * 
 */
public class Cluster {

	private String name;
	private String description;

	// the cluster MBeans to Query
	private List<MBean> mbeans;

	// the cluster members
	private List<JMXServer> servers;

	public Cluster() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<MBean> getMbeans() {
		return mbeans;
	}

	public void setMbeans(List<MBean> mbeans) {
		this.mbeans = mbeans;
	}

	public List<JMXServer> getServers() {
		return servers;
	}

	public void setServers(List<JMXServer> servers) {
		this.servers = servers;
	}

}
