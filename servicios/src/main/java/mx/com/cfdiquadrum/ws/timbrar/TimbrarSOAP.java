/**
 * TimbrarSOAP.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package mx.com.cfdiquadrum.ws.timbrar;

public interface TimbrarSOAP extends javax.xml.rpc.Service {
    public java.lang.String getApplicationAddress();

    public mx.com.cfdiquadrum.ws.timbrar.Application getApplication() throws javax.xml.rpc.ServiceException;

    public mx.com.cfdiquadrum.ws.timbrar.Application getApplication(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
