package com.upfpo.app.upagri;

public class DbtServiceSoapProxy implements com.upfpo.app.upagri.DbtServiceSoap {
  private String _endpoint = null;
  private com.upfpo.app.upagri.DbtServiceSoap dbtServiceSoap = null;
  
  public DbtServiceSoapProxy() {
    _initDbtServiceSoapProxy();
  }
  
  public DbtServiceSoapProxy(String endpoint) {
    _endpoint = endpoint;
    _initDbtServiceSoapProxy();
  }
  
  private void _initDbtServiceSoapProxy() {
    try {
      dbtServiceSoap = (new com.upfpo.app.upagri.DbtServiceLocator()).getDbtServiceSoap();
      if (dbtServiceSoap != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)dbtServiceSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)dbtServiceSoap)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (dbtServiceSoap != null)
      ((javax.xml.rpc.Stub)dbtServiceSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.upfpo.app.upagri.DbtServiceSoap getDbtServiceSoap() {
    if (dbtServiceSoap == null)
      _initDbtServiceSoapProxy();
    return dbtServiceSoap;
  }
  
  public com.upfpo.app.upagri.DBTDATAResponseDBTDATAResult DBTDATA(java.lang.String SCHEME_CODE) throws java.rmi.RemoteException{
    if (dbtServiceSoap == null)
      _initDbtServiceSoapProxy();
    return dbtServiceSoap.DBTDATA(SCHEME_CODE);
  }
  
  public com.upfpo.app.upagri.UPAGRIResponseUPAGRIResult UPAGRI(java.lang.String REG_NO) throws java.rmi.RemoteException{
    if (dbtServiceSoap == null)
      _initDbtServiceSoapProxy();
    return dbtServiceSoap.UPAGRI(REG_NO);
  }
  
  public com.upfpo.app.upagri.UPAGRI_AREAResponseUPAGRI_AREAResult UPAGRI_AREA(java.lang.String REG_NO) throws java.rmi.RemoteException{
    if (dbtServiceSoap == null)
      _initDbtServiceSoapProxy();
    return dbtServiceSoap.UPAGRI_AREA(REG_NO);
  }
  
  
}