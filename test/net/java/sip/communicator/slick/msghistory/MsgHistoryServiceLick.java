/*
 * SIP Communicator, the OpenSource Java VoIP and Instant Messaging client.
 *
 * Distributable under LGPL license.
 * See terms of license at gnu.org.
 */
package net.java.sip.communicator.slick.msghistory;

import java.util.Hashtable;

import junit.framework.TestSuite;
import net.java.sip.communicator.util.Logger;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

/**
 * This class launches the bundle of which test the history bundle. this bundle
 * is a set of (j)unit tests. It should be launched by the cruisecontrol module.
 *
 * @author Alexander Pelov
 */
public class MsgHistoryServiceLick extends TestSuite implements BundleActivator {
    private static Logger logger = Logger.getLogger(MsgHistoryServiceLick.class);

    protected static BundleContext bc = null;

    /**
     * Start the History Sevice Implementation Compatibility Kit.
     *
     * @param bundleContext
     *            BundleContext
     * @throws Exception
     */
    public void start(BundleContext bundleContext) throws Exception {
        MsgHistoryServiceLick.bc = bundleContext;

        setName("MsgHistoryServiceLick");
        Hashtable properties = new Hashtable();
        properties.put("service.pid", getName());

        addTestSuite(TestMsgHistoryService.class);
        bundleContext.registerService(getClass().getName(), this, properties);

        logger.debug("Successfully registered " + getClass().getName());
    }

    /**
     * stop
     *
     * @param bundlecontext
     *            BundleContext
     * @throws Exception
     */
    public void stop(BundleContext bundlecontext) throws Exception {
    }

}
