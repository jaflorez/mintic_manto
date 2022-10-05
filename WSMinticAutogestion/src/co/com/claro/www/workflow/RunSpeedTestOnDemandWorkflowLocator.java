/**
 * RunSpeedTestOnDemandWorkflowLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package co.com.claro.www.workflow;

public class RunSpeedTestOnDemandWorkflowLocator extends org.apache.axis.client.Service implements co.com.claro.www.workflow.RunSpeedTestOnDemandWorkflow {

    public RunSpeedTestOnDemandWorkflowLocator() {
    }


    public RunSpeedTestOnDemandWorkflowLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public RunSpeedTestOnDemandWorkflowLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for RunSpeedTestOnDemandWorkflowSoap
    private java.lang.String RunSpeedTestOnDemandWorkflowSoap_address = "https://gestionate.triara.co/SpeedTest.OnDemandWorkflow/RunSpeedTestOnDemandWorkflow.asmx";

    public java.lang.String getRunSpeedTestOnDemandWorkflowSoapAddress() {
        return RunSpeedTestOnDemandWorkflowSoap_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String RunSpeedTestOnDemandWorkflowSoapWSDDServiceName = "RunSpeedTestOnDemandWorkflowSoap";

    public java.lang.String getRunSpeedTestOnDemandWorkflowSoapWSDDServiceName() {
        return RunSpeedTestOnDemandWorkflowSoapWSDDServiceName;
    }

    public void setRunSpeedTestOnDemandWorkflowSoapWSDDServiceName(java.lang.String name) {
        RunSpeedTestOnDemandWorkflowSoapWSDDServiceName = name;
    }

    public co.com.claro.www.workflow.RunSpeedTestOnDemandWorkflowSoap getRunSpeedTestOnDemandWorkflowSoap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(RunSpeedTestOnDemandWorkflowSoap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getRunSpeedTestOnDemandWorkflowSoap(endpoint);
    }

    public co.com.claro.www.workflow.RunSpeedTestOnDemandWorkflowSoap getRunSpeedTestOnDemandWorkflowSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            co.com.claro.www.workflow.RunSpeedTestOnDemandWorkflowSoapStub _stub = new co.com.claro.www.workflow.RunSpeedTestOnDemandWorkflowSoapStub(portAddress, this);
            _stub.setPortName(getRunSpeedTestOnDemandWorkflowSoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setRunSpeedTestOnDemandWorkflowSoapEndpointAddress(java.lang.String address) {
        RunSpeedTestOnDemandWorkflowSoap_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (co.com.claro.www.workflow.RunSpeedTestOnDemandWorkflowSoap.class.isAssignableFrom(serviceEndpointInterface)) {
                co.com.claro.www.workflow.RunSpeedTestOnDemandWorkflowSoapStub _stub = new co.com.claro.www.workflow.RunSpeedTestOnDemandWorkflowSoapStub(new java.net.URL(RunSpeedTestOnDemandWorkflowSoap_address), this);
                _stub.setPortName(getRunSpeedTestOnDemandWorkflowSoapWSDDServiceName());
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
        if ("RunSpeedTestOnDemandWorkflowSoap".equals(inputPortName)) {
            return getRunSpeedTestOnDemandWorkflowSoap();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("www.claro.com.co", "RunSpeedTestOnDemandWorkflow");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("www.claro.com.co", "RunSpeedTestOnDemandWorkflowSoap"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("RunSpeedTestOnDemandWorkflowSoap".equals(portName)) {
            setRunSpeedTestOnDemandWorkflowSoapEndpointAddress(address);
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
