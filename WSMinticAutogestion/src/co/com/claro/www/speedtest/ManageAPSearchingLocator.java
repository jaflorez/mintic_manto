/**
 * ManageAPSearchingLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package co.com.claro.www.speedtest;

public class ManageAPSearchingLocator extends org.apache.axis.client.Service implements co.com.claro.www.speedtest.ManageAPSearching {

    public ManageAPSearchingLocator() {
    }


    public ManageAPSearchingLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ManageAPSearchingLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ManageAPSearchingSoap
    private java.lang.String ManageAPSearchingSoap_address = "https://localhost/SpeedTest.SearchAP/ManageAPSearching.asmx";

    public java.lang.String getManageAPSearchingSoapAddress() {
        return ManageAPSearchingSoap_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ManageAPSearchingSoapWSDDServiceName = "ManageAPSearchingSoap";

    public java.lang.String getManageAPSearchingSoapWSDDServiceName() {
        return ManageAPSearchingSoapWSDDServiceName;
    }

    public void setManageAPSearchingSoapWSDDServiceName(java.lang.String name) {
        ManageAPSearchingSoapWSDDServiceName = name;
    }

    public co.com.claro.www.speedtest.ManageAPSearchingSoap getManageAPSearchingSoap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ManageAPSearchingSoap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getManageAPSearchingSoap(endpoint);
    }

    public co.com.claro.www.speedtest.ManageAPSearchingSoap getManageAPSearchingSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            co.com.claro.www.speedtest.ManageAPSearchingSoapStub _stub = new co.com.claro.www.speedtest.ManageAPSearchingSoapStub(portAddress, this);
            _stub.setPortName(getManageAPSearchingSoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setManageAPSearchingSoapEndpointAddress(java.lang.String address) {
        ManageAPSearchingSoap_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (co.com.claro.www.speedtest.ManageAPSearchingSoap.class.isAssignableFrom(serviceEndpointInterface)) {
                co.com.claro.www.speedtest.ManageAPSearchingSoapStub _stub = new co.com.claro.www.speedtest.ManageAPSearchingSoapStub(new java.net.URL(ManageAPSearchingSoap_address), this);
                _stub.setPortName(getManageAPSearchingSoapWSDDServiceName());
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
        if ("ManageAPSearchingSoap".equals(inputPortName)) {
            return getManageAPSearchingSoap();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("www.claro.com.co", "ManageAPSearching");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("www.claro.com.co", "ManageAPSearchingSoap"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ManageAPSearchingSoap".equals(portName)) {
            setManageAPSearchingSoapEndpointAddress(address);
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
