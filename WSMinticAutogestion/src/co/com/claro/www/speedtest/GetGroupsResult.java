/**
 * GetGroupsResult.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package co.com.claro.www.speedtest;

public class GetGroupsResult  implements java.io.Serializable {
    private co.com.claro.www.speedtest.GroupsObject[] groups;

    private int exitCode;

    private java.lang.String errorMessage;

    public GetGroupsResult() {
    }

    public GetGroupsResult(
           co.com.claro.www.speedtest.GroupsObject[] groups,
           int exitCode,
           java.lang.String errorMessage) {
           this.groups = groups;
           this.exitCode = exitCode;
           this.errorMessage = errorMessage;
    }


    /**
     * Gets the groups value for this GetGroupsResult.
     * 
     * @return groups
     */
    public co.com.claro.www.speedtest.GroupsObject[] getGroups() {
        return groups;
    }


    /**
     * Sets the groups value for this GetGroupsResult.
     * 
     * @param groups
     */
    public void setGroups(co.com.claro.www.speedtest.GroupsObject[] groups) {
        this.groups = groups;
    }


    /**
     * Gets the exitCode value for this GetGroupsResult.
     * 
     * @return exitCode
     */
    public int getExitCode() {
        return exitCode;
    }


    /**
     * Sets the exitCode value for this GetGroupsResult.
     * 
     * @param exitCode
     */
    public void setExitCode(int exitCode) {
        this.exitCode = exitCode;
    }


    /**
     * Gets the errorMessage value for this GetGroupsResult.
     * 
     * @return errorMessage
     */
    public java.lang.String getErrorMessage() {
        return errorMessage;
    }


    /**
     * Sets the errorMessage value for this GetGroupsResult.
     * 
     * @param errorMessage
     */
    public void setErrorMessage(java.lang.String errorMessage) {
        this.errorMessage = errorMessage;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetGroupsResult)) return false;
        GetGroupsResult other = (GetGroupsResult) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.groups==null && other.getGroups()==null) || 
             (this.groups!=null &&
              java.util.Arrays.equals(this.groups, other.getGroups()))) &&
            this.exitCode == other.getExitCode() &&
            ((this.errorMessage==null && other.getErrorMessage()==null) || 
             (this.errorMessage!=null &&
              this.errorMessage.equals(other.getErrorMessage())));
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
        if (getGroups() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getGroups());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getGroups(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        _hashCode += getExitCode();
        if (getErrorMessage() != null) {
            _hashCode += getErrorMessage().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetGroupsResult.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("www.claro.com.co", "GetGroupsResult"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("groups");
        elemField.setXmlName(new javax.xml.namespace.QName("www.claro.com.co", "Groups"));
        elemField.setXmlType(new javax.xml.namespace.QName("www.claro.com.co", "GroupsObject"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("www.claro.com.co", "GroupsObject"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("exitCode");
        elemField.setXmlName(new javax.xml.namespace.QName("www.claro.com.co", "ExitCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("errorMessage");
        elemField.setXmlName(new javax.xml.namespace.QName("www.claro.com.co", "ErrorMessage"));
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
