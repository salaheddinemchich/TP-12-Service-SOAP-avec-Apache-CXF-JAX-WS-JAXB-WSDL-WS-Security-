package com.acme.cxf;

import com.acme.cxf.impl.HelloServiceImpl;
import org.apache.cxf.Bus;
import org.apache.cxf.BusFactory;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;

public class Server {
    public static void main(String[] args) {

        // 1️⃣ Initialiser explicitement le Bus CXF
        Bus bus = BusFactory.newInstance().createBus();
        BusFactory.setDefaultBus(bus);

        String address = "http://localhost:8080/services/hello";

        // 2️⃣ Créer le serveur SOAP
        JaxWsServerFactoryBean factory = new JaxWsServerFactoryBean();
        factory.setServiceBean(new HelloServiceImpl());
        factory.setAddress(address);
        factory.create();

        System.out.println("WSDL available at: " + address + "?wsdl");

        // 3️⃣ Bloquer le thread pour garder le serveur actif
        try {
            Thread.sleep(Long.MAX_VALUE);
        } catch (InterruptedException ignored) {}
    }
}
