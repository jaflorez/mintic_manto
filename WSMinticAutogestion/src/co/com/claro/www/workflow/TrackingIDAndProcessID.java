/**
 * TrackingIDAndProcessID.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package co.com.claro.www.workflow;

public class TrackingIDAndProcessID  implements java.io.Serializable {
    private java.lang.String workflowTrackingID;

    private java.lang.String processID;

    public TrackingIDAndProcessID() {
    }

    public TrackingIDAndProcessID(
           java.lang.String workflowTrackingID,
           java.lang.String processID) {
           this.workflowTrackingID = workflowTrackingID;
           this.processID = processID;
    }


    /**
     * Gets the workflowTrackingID value for this TrackingIDAndProcessID.
     * 
     * @return workflowTrackingID
     */
    public java.lang.String getWorkflowTrackingID() {
        return workflowTrackingID;
    }


    /**
     * Sets the workflowTrackingID value for this TrackingIDAndProcessID.
     * 
     * @param workflowTrackingID
     */
    public void setWorkflowTrackingID(java.lang.String workflowTrackingID) {
        this.workflowTrackingID = workflowTrackingID;
    }


    /**
     * Gets the processID value for this TrackingIDAndProcessID.
     * 
     * @return processID
     */
    public java.lang.String getProcessID() {
        return processID;
    }


    /**
     * Sets the processID value for this TrackingIDAndProcessID.
     * 
     * @param processID
     */
    public void setProcessID(java.lang.String processID) {
        this.processID = processID;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof TrackingIDAndProcessID)) return false;
        TrackingIDAndProcessID other = (TrackingIDAndProcessID) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.workflowTrackingID==null && other.getWorkflowTrackingID()==null) || 
             (this.workflowTrackingID!=null &&
              this.workflowTrackingID.equals(other.getWorkflowTrackingID()))) &&
            ((this.processID==null && other.getProcessID()==null) || 
             (this.processID!=null &&
              this.processID.equals(other.getProcessID())));
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
        if (getWorkflowTrackingID() != null) {
            _hashCode += getWorkflowTrackingID().hashCode();
        }
        if (getProcessID() != null) {
            _hashCode += getProcessID().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(TrackingIDAndProcessID.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("www.claro.com.co", "TrackingIDAndProcessID"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("workflowTrackingID");
        elemField.setXmlName(new javax.xml.namespace.QName("www.claro.com.co", "WorkflowTrackingID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("processID");
        elemField.setXmlName(new javax.xml.namespace.QName("www.claro.com.co", "ProcessID"));
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
