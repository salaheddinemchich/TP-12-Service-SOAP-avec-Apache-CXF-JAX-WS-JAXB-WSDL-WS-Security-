package com.acme.cxf.client;

import com.acme.cxf.api.HelloService;
import javax.xml.namespace.QName;
import jakarta.xml.ws.Service;

import java.net.URL;

public class ClientDemo {
    public static void main(String[] args) throws Exception {

        URL wsdl = new URL("http://localhost:8080/services/hello?wsdl");

        // QName(targetNamespace, serviceName dans le WSDL)
        QName qname = new QName("http://api.cxf.acme.com/", "HelloService");

        // Chargement du service
        Service svc = Service.create(wsdl, qname);

        // Proxy dynamique
        HelloService port = svc.getPort(HelloService.class);

        // Appels test
        System.out.println(port.sayHello("ClientJava"));
        System.out.println(port.findPersonById("1").getName());
    }
}
