package mx.com.cfdiquadrum.ws.timbrar;

public class ApplicationProxy implements mx.com.cfdiquadrum.ws.timbrar.Application {
  private String _endpoint = null;
  private mx.com.cfdiquadrum.ws.timbrar.Application application = null;
  
  public ApplicationProxy() {
    _initApplicationProxy();
  }
  
  public ApplicationProxy(String endpoint) {
    _endpoint = endpoint;
    _initApplicationProxy();
  }
  
  private void _initApplicationProxy() {
    try {
      application = (new mx.com.cfdiquadrum.ws.timbrar.TimbrarSOAPLocator()).getApplication();
      if (application != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)application)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)application)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (application != null)
      ((javax.xml.rpc.Stub)application)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public mx.com.cfdiquadrum.ws.timbrar.Application getApplication() {
    if (application == null)
      _initApplicationProxy();
    return application;
  }
  
  public views.core.soap.services.apps.AcuseRecepcionCFDI timbrado(byte[] xml, java.lang.String usuario, java.lang.String contrasena) throws java.rmi.RemoteException{
    if (application == null)
      _initApplicationProxy();
    return application.timbrado(xml, usuario, contrasena);
  }
  
  public views.core.soap.services.apps.ConsultaPendiente consulta(java.lang.String usuario, java.lang.String contrasena, java.lang.String uuid) throws java.rmi.RemoteException{
    if (application == null)
      _initApplicationProxy();
    return application.consulta(usuario, contrasena, uuid);
  }
  
  public views.core.soap.services.apps.AcuseRecepcionCFDI timbrar(byte[] xml, java.lang.String usuario, java.lang.String contrasena) throws java.rmi.RemoteException{
    if (application == null)
      _initApplicationProxy();
    return application.timbrar(xml, usuario, contrasena);
  }
  
  
}