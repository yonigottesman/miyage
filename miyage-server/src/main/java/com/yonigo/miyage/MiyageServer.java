package com.yonigo.miyage;

import javax.net.ssl.SSLException;
import java.security.cert.CertificateException;

public class MiyageServer {

    private MiyageNetworkLayer networkLayer;

    public MiyageServer() throws CertificateException, SSLException {
        networkLayer = new MiyageNetworkLayer();
    }
    public void startServer() throws InterruptedException {
        networkLayer.listen();
    }


    public static void main(String args[]) {
        System.out.println("start server");
        try {
            MiyageServer server = new MiyageServer();
            server.startServer();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(-1);
        }
    }


}
