/**
 * QueryServiceServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ac.uat.crmht.service.CRMHT.QueryService_jws;

public class QueryServiceServiceLocator extends org.apache.axis.client.Service implements ac.uat.crmht.service.CRMHT.QueryService_jws.QueryServiceService {

    public QueryServiceServiceLocator() {
    }


    public QueryServiceServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public QueryServiceServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for QueryService
    private java.lang.String QueryService_address = "http://gate.hp.uat.ac/CRMHT/QueryService.jws";

    public java.lang.String getQueryServiceAddress() {
        return QueryService_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String QueryServiceWSDDServiceName = "QueryService";

    public java.lang.String getQueryServiceWSDDServiceName() {
        return QueryServiceWSDDServiceName;
    }

    public void setQueryServiceWSDDServiceName(java.lang.String name) {
        QueryServiceWSDDServiceName = name;
    }

    public ac.uat.crmht.service.CRMHT.QueryService_jws.QueryService getQueryService() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(QueryService_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getQueryService(endpoint);
    }

    public ac.uat.crmht.service.CRMHT.QueryService_jws.QueryService getQueryService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            ac.uat.crmht.service.CRMHT.QueryService_jws.QueryServiceSoapBindingStub _stub = new ac.uat.crmht.service.CRMHT.QueryService_jws.QueryServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getQueryServiceWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setQueryServiceEndpointAddress(java.lang.String address) {
        QueryService_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (ac.uat.crmht.service.CRMHT.QueryService_jws.QueryService.class.isAssignableFrom(serviceEndpointInterface)) {
                ac.uat.crmht.service.CRMHT.QueryService_jws.QueryServiceSoapBindingStub _stub = new ac.uat.crmht.service.CRMHT.QueryService_jws.QueryServiceSoapBindingStub(new java.net.URL(QueryService_address), this);
                _stub.setPortName(getQueryServiceWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("QueryService".equals(inputPortName)) {
            return getQueryService();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://service.crmht.uat.ac/CRMHT/QueryService.jws", "QueryServiceService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://service.crmht.uat.ac/CRMHT/QueryService.jws", "QueryService"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("QueryService".equals(portName)) {
            setQueryServiceEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
