package com.yonigo.miyage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.net.ssl.SSLException;
import java.security.cert.CertificateException;

public class MiyageServer {

    private static final Logger logger = LogManager.getLogger(MiyageServer.class);
    private MiyageNetworkLayer networkLayer;

    public MiyageServer() throws CertificateException, SSLException {
        networkLayer = new MiyageNetworkLayer();
    }

    public void startServer() throws InterruptedException {
        networkLayer.listen();
    }


    public static void main(String args[]) {
        logger.info("start server");

        try {
            MiyageServer server = new MiyageServer();
            server.startServer();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(-1);
        }
    }


}
