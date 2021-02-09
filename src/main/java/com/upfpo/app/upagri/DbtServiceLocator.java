/**
 * DbtServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.upfpo.app.upagri;

public class DbtServiceLocator extends org.apache.axis.client.Service implements com.upfpo.app.upagri.DbtService {

    public DbtServiceLocator() {
    }


    public DbtServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public DbtServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for DbtServiceSoap
    private java.lang.String DbtServiceSoap_address = "http://upagriculture.com:81/DbtService.asmx";

    public java.lang.String getDbtServiceSoapAddress() {
        return DbtServiceSoap_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String DbtServiceSoapWSDDServiceName = "DbtServiceSoap";

    public java.lang.String getDbtServiceSoapWSDDServiceName() {
        return DbtServiceSoapWSDDServiceName;
    }

    public void setDbtServiceSoapWSDDServiceName(java.lang.String name) {
        DbtServiceSoapWSDDServiceName = name;
    }

    public com.upfpo.app.upagri.DbtServiceSoap getDbtServiceSoap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(DbtServiceSoap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getDbtServiceSoap(endpoint);
    }

    public com.upfpo.app.upagri.DbtServiceSoap getDbtServiceSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.upfpo.app.upagri.DbtServiceSoapStub _stub = new com.upfpo.app.upagri.DbtServiceSoapStub(portAddress, this);
            _stub.setPortName(getDbtServiceSoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setDbtServiceSoapEndpointAddress(java.lang.String address) {
        DbtServiceSoap_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.upfpo.app.upagri.DbtServiceSoap.class.isAssignableFrom(serviceEndpointInterface)) {
                com.upfpo.app.upagri.DbtServiceSoapStub _stub = new com.upfpo.app.upagri.DbtServiceSoapStub(new java.net.URL(DbtServiceSoap_address), this);
                _stub.setPortName(getDbtServiceSoapWSDDServiceName());
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
        if ("DbtServiceSoap".equals(inputPortName)) {
            return getDbtServiceSoap();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://tempuri.org/", "DbtService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://tempuri.org/", "DbtServiceSoap"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("DbtServiceSoap".equals(portName)) {
            setDbtServiceSoapEndpointAddress(address);
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
