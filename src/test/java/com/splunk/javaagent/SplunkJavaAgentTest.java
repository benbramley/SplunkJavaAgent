package com.splunk.javaagent;

import junit.framework.Assert;
import org.junit.Test;
import org.junit.Rule;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.rules.ExpectedException;
import com.splunk.javaagent.SplunkJavaAgent;
import java.util.Properties;
import java.lang.instrument.Instrumentation;
import static org.mockito.Mockito.*;


public class SplunkJavaAgentTest {

    private Instrumentation inst;
    private SplunkJavaAgent agent;

    @Before
    public void setUp() {

        agent = new SplunkJavaAgent();
        agent.loadProperties("src/test/resources/splunkagent.properties");
        agent.initCommonProperties();

    }

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void testLoadMissingProperties() {

        exception.expect(NullPointerException.class);
        agent.loadProperties("src/test/resources/splunkagent.propertiez");
    
    }

    @Test
    public void testLoadProperties() {
        
        Assert.assertTrue(agent.loadProperties("src/test/resources/splunkagent.properties"));
    
    }

     @Test
    public void testLoadCommonProperties() {

        Assert.assertTrue(agent.initCommonProperties());

    }

    @Test
    public void testInitTransport() {

        Assert.assertTrue(agent.initTransport());

    }

      @Test
    public void testInitTracing() {

        Assert.assertTrue(agent.initTracing());

    }

    @Test
    public void testInitFilters() {

        Assert.assertTrue(agent.initFilters());

    }

    @Test
    public void testInitJMX() {

        Assert.assertTrue(agent.initJMX());

    }

     @Test
    public void testInitHprof() {

        Assert.assertTrue(agent.initHprof());

    } 

}
