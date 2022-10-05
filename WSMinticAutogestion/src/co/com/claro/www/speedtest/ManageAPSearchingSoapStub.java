/**
 * ManageAPSearchingSoapStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package co.com.claro.www.speedtest;

public class ManageAPSearchingSoapStub extends org.apache.axis.client.Stub implements co.com.claro.www.speedtest.ManageAPSearchingSoap {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[9];
        _initOperationDesc1();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("NoAction");
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("SearchAPByText");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("www.claro.com.co", "TextToSearch"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("www.claro.com.co", "MaxRows"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("www.claro.com.co", "SearchAPByTextResult"));
        oper.setReturnClass(co.com.claro.www.speedtest.SearchAPByTextResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("www.claro.com.co", "SearchAPByTextResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("SearchAPByBW");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("www.claro.com.co", "DownloadBWOperator"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("www.claro.com.co", "DownloadBWValue"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"), java.math.BigDecimal.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("www.claro.com.co", "UploadBWOperator"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("www.claro.com.co", "UploadBWValue"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"), java.math.BigDecimal.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("www.claro.com.co", "GeneralOperator"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("www.claro.com.co", "MaxRows"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("www.claro.com.co", "SearchAPByBWResult"));
        oper.setReturnClass(co.com.claro.www.speedtest.SearchAPByBWResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("www.claro.com.co", "SearchAPByBWResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("AddAP");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("www.claro.com.co", "AP"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("www.claro.com.co", "ArrayOfSearchAPResultObject"), co.com.claro.www.speedtest.SearchAPResultObject[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("www.claro.com.co", "SearchAPResultObject"));
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("www.claro.com.co", "AllowUpdate"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"), boolean.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("www.claro.com.co", "AddAPResult"));
        oper.setReturnClass(co.com.claro.www.speedtest.AddAPResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("www.claro.com.co", "AddAPResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[3] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("SearchLocationByText");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("www.claro.com.co", "TextToSearch"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("www.claro.com.co", "MaxRows"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("www.claro.com.co", "SearchLocationByTextResult"));
        oper.setReturnClass(co.com.claro.www.speedtest.SearchLocationByTextResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("www.claro.com.co", "SearchLocationByTextResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[4] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetLocationByBeneficiaryCode");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("www.claro.com.co", "BeneficiaryCode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("www.claro.com.co", "GetLocationByBeneficiaryCodeResult"));
        oper.setReturnClass(co.com.claro.www.speedtest.GetLocationByBeneficiaryCodeResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("www.claro.com.co", "GetLocationByBeneficiaryCodeResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[5] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("DisableAPsByBeneficiaryCode");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("www.claro.com.co", "BeneficiaryCode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("www.claro.com.co", "apIDtoExclude"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("www.claro.com.co", "DisableAPsByBeneficiaryCodeResult"));
        oper.setReturnClass(co.com.claro.www.speedtest.DisableAPsByBeneficiaryCodeResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("www.claro.com.co", "DisableAPsByBeneficiaryCodeResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[6] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("SearchAllAPsByText");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("www.claro.com.co", "TextToSearch"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("www.claro.com.co", "MaxRows"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("www.claro.com.co", "SearchAllAPsByTextResult"));
        oper.setReturnClass(co.com.claro.www.speedtest.SearchAllAPsByTextResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("www.claro.com.co", "SearchAllAPsByTextResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[7] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetGroups");
        oper.setReturnType(new javax.xml.namespace.QName("www.claro.com.co", "GetGroupsResult"));
        oper.setReturnClass(co.com.claro.www.speedtest.GetGroupsResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("www.claro.com.co", "GetGroupsResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[8] = oper;

    }

    public ManageAPSearchingSoapStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public ManageAPSearchingSoapStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public ManageAPSearchingSoapStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
        if (service == null) {
            super.service = new org.apache.axis.client.Service();
        } else {
            super.service = service;
        }
        ((org.apache.axis.client.Service)super.service).setTypeMappingVersion("1.2");
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
            qName = new javax.xml.namespace.QName("www.claro.com.co", "AddAPResult");
            cachedSerQNames.add(qName);
            cls = co.com.claro.www.speedtest.AddAPResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("www.claro.com.co", "ArrayOfGroupsObject");
            cachedSerQNames.add(qName);
            cls = co.com.claro.www.speedtest.GroupsObject[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("www.claro.com.co", "GroupsObject");
            qName2 = new javax.xml.namespace.QName("www.claro.com.co", "GroupsObject");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("www.claro.com.co", "ArrayOfKeyValueDataType");
            cachedSerQNames.add(qName);
            cls = co.com.claro.www.speedtest.KeyValueDataType[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("www.claro.com.co", "KeyValueDataType");
            qName2 = new javax.xml.namespace.QName("www.claro.com.co", "KeyValueDataType");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("www.claro.com.co", "ArrayOfSearchAPResultObject");
            cachedSerQNames.add(qName);
            cls = co.com.claro.www.speedtest.SearchAPResultObject[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("www.claro.com.co", "SearchAPResultObject");
            qName2 = new javax.xml.namespace.QName("www.claro.com.co", "SearchAPResultObject");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("www.claro.com.co", "DisableAPsByBeneficiaryCodeResult");
            cachedSerQNames.add(qName);
            cls = co.com.claro.www.speedtest.DisableAPsByBeneficiaryCodeResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("www.claro.com.co", "GetGroupsResult");
            cachedSerQNames.add(qName);
            cls = co.com.claro.www.speedtest.GetGroupsResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("www.claro.com.co", "GetLocationByBeneficiaryCodeResult");
            cachedSerQNames.add(qName);
            cls = co.com.claro.www.speedtest.GetLocationByBeneficiaryCodeResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("www.claro.com.co", "GroupsObject");
            cachedSerQNames.add(qName);
            cls = co.com.claro.www.speedtest.GroupsObject.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("www.claro.com.co", "KeyValueDataType");
            cachedSerQNames.add(qName);
            cls = co.com.claro.www.speedtest.KeyValueDataType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("www.claro.com.co", "SearchAllAPsByTextResult");
            cachedSerQNames.add(qName);
            cls = co.com.claro.www.speedtest.SearchAllAPsByTextResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("www.claro.com.co", "SearchAPByBWResult");
            cachedSerQNames.add(qName);
            cls = co.com.claro.www.speedtest.SearchAPByBWResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("www.claro.com.co", "SearchAPByTextResult");
            cachedSerQNames.add(qName);
            cls = co.com.claro.www.speedtest.SearchAPByTextResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("www.claro.com.co", "SearchAPResultObject");
            cachedSerQNames.add(qName);
            cls = co.com.claro.www.speedtest.SearchAPResultObject.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("www.claro.com.co", "SearchLocationByTextResult");
            cachedSerQNames.add(qName);
            cls = co.com.claro.www.speedtest.SearchLocationByTextResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("www.claro.com.co", "TableLocationsObject");
            cachedSerQNames.add(qName);
            cls = co.com.claro.www.speedtest.TableLocationsObject.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

    }

    protected org.apache.axis.client.Call createCall() throws java.rmi.RemoteException {
        try {
            org.apache.axis.client.Call _call = super._createCall();
            if (super.maintainSessionSet) {
                _call.setMaintainSession(super.maintainSession);
            }
            if (super.cachedUsername != null) {
                _call.setUsername(super.cachedUsername);
            }
            if (super.cachedPassword != null) {
                _call.setPassword(super.cachedPassword);
            }
            if (super.cachedEndpoint != null) {
                _call.setTargetEndpointAddress(super.cachedEndpoint);
            }
            if (super.cachedTimeout != null) {
                _call.setTimeout(super.cachedTimeout);
            }
            if (super.cachedPortName != null) {
                _call.setPortName(super.cachedPortName);
            }
            java.util.Enumeration keys = super.cachedProperties.keys();
            while (keys.hasMoreElements()) {
                java.lang.String key = (java.lang.String) keys.nextElement();
                _call.setProperty(key, super.cachedProperties.get(key));
            }
            // All the type mapping information is registered
            // when the first call is made.
            // The type mapping information is actually registered in
            // the TypeMappingRegistry of the service, which
            // is the reason why registration is only needed for the first call.
            synchronized (this) {
                if (firstCall()) {
                    // must set encoding style before registering serializers
                    _call.setEncodingStyle(null);
                    for (int i = 0; i < cachedSerFactories.size(); ++i) {
                        java.lang.Class cls = (java.lang.Class) cachedSerClasses.get(i);
                        javax.xml.namespace.QName qName =
                                (javax.xml.namespace.QName) cachedSerQNames.get(i);
                        java.lang.Object x = cachedSerFactories.get(i);
                        if (x instanceof Class) {
                            java.lang.Class sf = (java.lang.Class)
                                 cachedSerFactories.get(i);
                            java.lang.Class df = (java.lang.Class)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                        else if (x instanceof javax.xml.rpc.encoding.SerializerFactory) {
                            org.apache.axis.encoding.SerializerFactory sf = (org.apache.axis.encoding.SerializerFactory)
                                 cachedSerFactories.get(i);
                            org.apache.axis.encoding.DeserializerFactory df = (org.apache.axis.encoding.DeserializerFactory)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                    }
                }
            }
            return _call;
        }
        catch (java.lang.Throwable _t) {
            throw new org.apache.axis.AxisFault("Failure trying to get the Call object", _t);
        }
    }

    public void noAction() throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("www.claro.com.co/NoAction");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("www.claro.com.co", "NoAction"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public co.com.claro.www.speedtest.SearchAPByTextResult searchAPByText(java.lang.String textToSearch, int maxRows) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("www.claro.com.co/SearchAPByText");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("www.claro.com.co", "SearchAPByText"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {textToSearch, new java.lang.Integer(maxRows)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (co.com.claro.www.speedtest.SearchAPByTextResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (co.com.claro.www.speedtest.SearchAPByTextResult) org.apache.axis.utils.JavaUtils.convert(_resp, co.com.claro.www.speedtest.SearchAPByTextResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public co.com.claro.www.speedtest.SearchAPByBWResult searchAPByBW(java.lang.String downloadBWOperator, java.math.BigDecimal downloadBWValue, java.lang.String uploadBWOperator, java.math.BigDecimal uploadBWValue, java.lang.String generalOperator, int maxRows) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("www.claro.com.co/SearchAPByBW");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("www.claro.com.co", "SearchAPByBW"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {downloadBWOperator, downloadBWValue, uploadBWOperator, uploadBWValue, generalOperator, new java.lang.Integer(maxRows)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (co.com.claro.www.speedtest.SearchAPByBWResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (co.com.claro.www.speedtest.SearchAPByBWResult) org.apache.axis.utils.JavaUtils.convert(_resp, co.com.claro.www.speedtest.SearchAPByBWResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public co.com.claro.www.speedtest.AddAPResult addAP(co.com.claro.www.speedtest.SearchAPResultObject[] AP, boolean allowUpdate) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("www.claro.com.co/AddAP");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("www.claro.com.co", "AddAP"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {AP, new java.lang.Boolean(allowUpdate)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (co.com.claro.www.speedtest.AddAPResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (co.com.claro.www.speedtest.AddAPResult) org.apache.axis.utils.JavaUtils.convert(_resp, co.com.claro.www.speedtest.AddAPResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public co.com.claro.www.speedtest.SearchLocationByTextResult searchLocationByText(java.lang.String textToSearch, int maxRows) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[4]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("www.claro.com.co/SearchLocationByText");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("www.claro.com.co", "SearchLocationByText"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {textToSearch, new java.lang.Integer(maxRows)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (co.com.claro.www.speedtest.SearchLocationByTextResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (co.com.claro.www.speedtest.SearchLocationByTextResult) org.apache.axis.utils.JavaUtils.convert(_resp, co.com.claro.www.speedtest.SearchLocationByTextResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public co.com.claro.www.speedtest.GetLocationByBeneficiaryCodeResult getLocationByBeneficiaryCode(java.lang.String beneficiaryCode) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[5]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("www.claro.com.co/GetLocationByBeneficiaryCode");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("www.claro.com.co", "GetLocationByBeneficiaryCode"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {beneficiaryCode});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (co.com.claro.www.speedtest.GetLocationByBeneficiaryCodeResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (co.com.claro.www.speedtest.GetLocationByBeneficiaryCodeResult) org.apache.axis.utils.JavaUtils.convert(_resp, co.com.claro.www.speedtest.GetLocationByBeneficiaryCodeResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public co.com.claro.www.speedtest.DisableAPsByBeneficiaryCodeResult disableAPsByBeneficiaryCode(java.lang.String beneficiaryCode, int apIDtoExclude) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[6]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("www.claro.com.co/DisableAPsByBeneficiaryCode");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("www.claro.com.co", "DisableAPsByBeneficiaryCode"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {beneficiaryCode, new java.lang.Integer(apIDtoExclude)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (co.com.claro.www.speedtest.DisableAPsByBeneficiaryCodeResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (co.com.claro.www.speedtest.DisableAPsByBeneficiaryCodeResult) org.apache.axis.utils.JavaUtils.convert(_resp, co.com.claro.www.speedtest.DisableAPsByBeneficiaryCodeResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public co.com.claro.www.speedtest.SearchAllAPsByTextResult searchAllAPsByText(java.lang.String textToSearch, int maxRows) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[7]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("www.claro.com.co/SearchAllAPsByText");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("www.claro.com.co", "SearchAllAPsByText"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {textToSearch, new java.lang.Integer(maxRows)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (co.com.claro.www.speedtest.SearchAllAPsByTextResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (co.com.claro.www.speedtest.SearchAllAPsByTextResult) org.apache.axis.utils.JavaUtils.convert(_resp, co.com.claro.www.speedtest.SearchAllAPsByTextResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public co.com.claro.www.speedtest.GetGroupsResult getGroups() throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[8]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("www.claro.com.co/GetGroups");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("www.claro.com.co", "GetGroups"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (co.com.claro.www.speedtest.GetGroupsResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (co.com.claro.www.speedtest.GetGroupsResult) org.apache.axis.utils.JavaUtils.convert(_resp, co.com.claro.www.speedtest.GetGroupsResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

}
