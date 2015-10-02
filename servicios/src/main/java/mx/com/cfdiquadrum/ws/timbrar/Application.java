/**
 * Application.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package mx.com.cfdiquadrum.ws.timbrar;

public interface Application extends java.rmi.Remote {
    public views.core.soap.services.apps.AcuseRecepcionCFDI timbrado(byte[] xml, java.lang.String usuario, java.lang.String contrasena) throws java.rmi.RemoteException;
    public views.core.soap.services.apps.ConsultaPendiente consulta(java.lang.String usuario, java.lang.String contrasena, java.lang.String uuid) throws java.rmi.RemoteException;
    public views.core.soap.services.apps.AcuseRecepcionCFDI timbrar(byte[] xml, java.lang.String usuario, java.lang.String contrasena) throws java.rmi.RemoteException;
}
