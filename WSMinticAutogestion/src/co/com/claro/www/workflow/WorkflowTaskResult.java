/**
 * WorkflowTaskResult.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package co.com.claro.www.workflow;

public class WorkflowTaskResult  implements java.io.Serializable {
    private java.lang.String workflowTaskID;

    private java.lang.String webServiceName;

    private java.lang.String componentClassName;

    private java.lang.String componentName;

    public WorkflowTaskResult() {
    }

    public WorkflowTaskResult(
           java.lang.String workflowTaskID,
           java.lang.String webServiceName,
           java.lang.String componentClassName,
           java.lang.String componentName) {
           this.workflowTaskID = workflowTaskID;
           this.webServiceName = webServiceName;
           this.componentClassName = componentClassName;
           this.componentName = componentName;
    }


    /**
     * Gets the workflowTaskID value for this WorkflowTaskResult.
     * 
     * @return workflowTaskID
     */
    public java.lang.String getWorkflowTaskID() {
        return workflowTaskID;
    }


    /**
     * Sets the workflowTaskID value for this WorkflowTaskResult.
     * 
     * @param workflowTaskID
     */
    public void setWorkflowTaskID(java.lang.String workflowTaskID) {
        this.workflowTaskID = workflowTaskID;
    }


    /**
     * Gets the webServiceName value for this WorkflowTaskResult.
     * 
     * @return webServiceName
     */
    public java.lang.String getWebServiceName() {
        return webServiceName;
    }


    /**
     * Sets the webServiceName value for this WorkflowTaskResult.
     * 
     * @param webServiceName
     */
    public void setWebServiceName(java.lang.String webServiceName) {
        this.webServiceName = webServiceName;
    }


    /**
     * Gets the componentClassName value for this WorkflowTaskResult.
     * 
     * @return componentClassName
     */
    public java.lang.String getComponentClassName() {
        return componentClassName;
    }


    /**
     * Sets the componentClassName value for this WorkflowTaskResult.
     * 
     * @param componentClassName
     */
    public void setComponentClassName(java.lang.String componentClassName) {
        this.componentClassName = componentClassName;
    }


    /**
     * Gets the componentName value for this WorkflowTaskResult.
     * 
     * @return componentName
     */
    public java.lang.String getComponentName() {
        return componentName;
    }


    /**
     * Sets the componentName value for this WorkflowTaskResult.
     * 
     * @param componentName
     */
    public void setComponentName(java.lang.String componentName) {
        this.componentName = componentName;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof WorkflowTaskResult)) return false;
        WorkflowTaskResult other = (WorkflowTaskResult) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.workflowTaskID==null && other.getWorkflowTaskID()==null) || 
             (this.workflowTaskID!=null &&
              this.workflowTaskID.equals(other.getWorkflowTaskID()))) &&
            ((this.webServiceName==null && other.getWebServiceName()==null) || 
             (this.webServiceName!=null &&
              this.webServiceName.equals(other.getWebServiceName()))) &&
            ((this.componentClassName==null && other.getComponentClassName()==null) || 
             (this.componentClassName!=null &&
              this.componentClassName.equals(other.getComponentClassName()))) &&
            ((this.componentName==null && other.getComponentName()==null) || 
             (this.componentName!=null &&
              this.componentName.equals(other.getComponentName())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getWorkflowTaskID() != null) {
            _hashCode += getWorkflowTaskID().hashCode();
        }
        if (getWebServiceName() != null) {
            _hashCode += getWebServiceName().hashCode();
        }
        if (getComponentClassName() != null) {
            _hashCode += getComponentClassName().hashCode();
        }
        if (getComponentName() != null) {
            _hashCode += getComponentName().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(WorkflowTaskResult.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("www.claro.com.co", "WorkflowTaskResult"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("workflowTaskID");
        elemField.setXmlName(new javax.xml.namespace.QName("www.claro.com.co", "WorkflowTaskID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("webServiceName");
        elemField.setXmlName(new javax.xml.namespace.QName("www.claro.com.co", "WebServiceName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("componentClassName");
        elemField.setXmlName(new javax.xml.namespace.QName("www.claro.com.co", "ComponentClassName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("componentName");
        elemField.setXmlName(new javax.xml.namespace.QName("www.claro.com.co", "ComponentName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
