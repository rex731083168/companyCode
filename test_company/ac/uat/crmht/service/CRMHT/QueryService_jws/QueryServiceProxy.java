package ac.uat.crmht.service.CRMHT.QueryService_jws;

public class QueryServiceProxy implements ac.uat.crmht.service.CRMHT.QueryService_jws.QueryService {
  private String _endpoint = null;
  private ac.uat.crmht.service.CRMHT.QueryService_jws.QueryService queryService = null;
  
  public QueryServiceProxy() {
    _initQueryServiceProxy();
  }
  
  public QueryServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initQueryServiceProxy();
  }
  
  private void _initQueryServiceProxy() {
    try {
      queryService = (new ac.uat.crmht.service.CRMHT.QueryService_jws.QueryServiceServiceLocator()).getQueryService();
      if (queryService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)queryService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)queryService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (queryService != null)
      ((javax.xml.rpc.Stub)queryService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public ac.uat.crmht.service.CRMHT.QueryService_jws.QueryService getQueryService() {
    if (queryService == null)
      _initQueryServiceProxy();
    return queryService;
  }
  
  public java.lang.String getXMLList(java.lang.String tradeCode, java.lang.String filterName, java.lang.String[] param) throws java.rmi.RemoteException{
    if (queryService == null)
      _initQueryServiceProxy();
    return queryService.getXMLList(tradeCode, filterName, param);
  }
  
  public java.lang.String CCFunction(java.lang.String input) throws java.rmi.RemoteException{
    if (queryService == null)
      _initQueryServiceProxy();
    return queryService.CCFunction(input);
  }
  
  
}