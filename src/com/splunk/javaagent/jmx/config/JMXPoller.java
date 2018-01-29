package com.splunk.javaagent.jmx.config;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Root config POJO
 * 
 * @author Damien Dallimore damien@dtdsoftware.com
 * 
 */
@XmlRootElement(name="jmxpoller")
public class JMXPoller {

	// the list of JMX Servers to connect to
	private List<JMXServer> servers;

	// a list of JMX Server Clusters
	private List<Cluster> clusters;

	// a custom formatter
	private Formatter formatter;

	// a custom transport
	private Transport transport;

	public JMXPoller() {
	}

	@XmlElement(type=JMXServer.class, name="jmxserver")
	public List<JMXServer> getServers() {
		return servers;
	}

	public List<JMXServer> normalizeMultiPIDs() {

		List<JMXServer> expandedList = new ArrayList<JMXServer>();

		// look for objects with multiple PIDS from the command output, and
		// clone new JMXServer objects
		if (servers != null) {
			for (JMXServer server : servers) {
				expandedList.add(server);
				List<Integer> pidList = server.getAdditionalPIDsFromCommand();
				if (pidList != null) {
					for (Integer pid : pidList) {
						expandedList.add(server.cloneForAdditionalPID(pid));
					}

				}
			}
		}
		return expandedList;
	}

	public void setServers(List<JMXServer> servers) {

		if (this.servers != null) {
			this.servers.addAll(servers);
		} else
			this.servers = servers;

	}

	@XmlElement(type=Formatter.class, name="formatter")
	public Formatter getFormatter() {
		return formatter;
	}

	public void setFormatter(Formatter formatter) {
		this.formatter = formatter;
	}

	@XmlElement(type=Transport.class, name="transport")
	public Transport getTransport() {
		return transport;
	}

	public void setTransport(Transport transport) {
		this.transport = transport;
	}

	@XmlElement(type=Cluster.class, name="cluster")
	public List<Cluster> getClusters() {
		return clusters;
	}

	/**
	 * Set the clusters and resolve the JMXServer objects
	 * 
	 * @param clusters
	 */
	public void setClusters(List<Cluster> clusters) {

		this.clusters = clusters;

	}

	/**
	 * Extract all JMX Servers out of the cluster and aggregate them in the same
	 * set
	 */
	public void normalizeClusters() {

		if (this.clusters == null)
			return;
		if (this.servers == null) {
			this.servers = new ArrayList<JMXServer>();
		}
		for (Cluster cluster : this.clusters) {

			List<MBean> mbeans = cluster.getMbeans();
			List<JMXServer> clusterServers = cluster.getServers();
			for (JMXServer server : clusterServers) {
				server.setMbeans(mbeans);
				this.servers.add(server);
			}
		}
	}

}
