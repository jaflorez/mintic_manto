/**
 * GetLocationByBeneficiaryCodeResult.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package co.com.claro.www.speedtest;

public class GetLocationByBeneficiaryCodeResult  implements java.io.Serializable {
    private int exitCode;

    private java.lang.String errorMessage;

    private co.com.claro.www.speedtest.TableLocationsObject locationInformation;

    public GetLocationByBeneficiaryCodeResult() {
    }

    public GetLocationByBeneficiaryCodeResult(
           int exitCode,
           java.lang.String errorMessage,
           co.com.claro.www.speedtest.TableLocationsObject locationInformation) {
           this.exitCode = exitCode;
           this.errorMessage = errorMessage;
           this.locationInformation = locationInformation;
    }


    /**
     * Gets the exitCode value for this GetLocationByBeneficiaryCodeResult.
     * 
     * @return exitCode
     */
    public int getExitCode() {
        return exitCode;
    }


    /**
     * Sets the exitCode value for this GetLocationByBeneficiaryCodeResult.
     * 
     * @param exitCode
     */
    public void setExitCode(int exitCode) {
        this.exitCode = exitCode;
    }


    /**
     * Gets the errorMessage value for this GetLocationByBeneficiaryCodeResult.
     * 
     * @return errorMessage
     */
    public java.lang.String getErrorMessage() {
        return errorMessage;
    }


    /**
     * Sets the errorMessage value for this GetLocationByBeneficiaryCodeResult.
     * 
     * @param errorMessage
     */
    public void setErrorMessage(java.lang.String errorMessage) {
        this.errorMessage = errorMessage;
    }


    /**
     * Gets the locationInformation value for this GetLocationByBeneficiaryCodeResult.
     * 
     * @return locationInformation
     */
    public co.com.claro.www.speedtest.TableLocationsObject getLocationInformation() {
        return locationInformation;
    }


    /**
     * Sets the locationInformation value for this GetLocationByBeneficiaryCodeResult.
     * 
     * @param locationInformation
     */
    public void setLocationInformation(co.com.claro.www.speedtest.TableLocationsObject locationInformation) {
        this.locationInformation = locationInformation;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetLocationByBeneficiaryCodeResult)) return false;
        GetLocationByBeneficiaryCodeResult other = (GetLocationByBeneficiaryCodeResult) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.exitCode == other.getExitCode() &&
            ((this.errorMessage==null && other.getErrorMessage()==null) || 
             (this.errorMessage!=null &&
              this.errorMessage.equals(other.getErrorMessage()))) &&
            ((this.locationInformation==null && other.getLocationInformation()==null) || 
             (this.locationInformation!=null &&
              this.locationInformation.equals(other.getLocationInformation())));
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
        _hashCode += getExitCode();
        if (getErrorMessage() != null) {
            _hashCode += getErrorMessage().hashCode();
        }
        if (getLocationInformation() != null) {
            _hashCode += getLocationInformation().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetLocationByBeneficiaryCodeResult.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("www.claro.com.co", "GetLocationByBeneficiaryCodeResult"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
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
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("locationInformation");
        elemField.setXmlName(new javax.xml.namespace.QName("www.claro.com.co", "LocationInformation"));
        elemField.setXmlType(new javax.xml.namespace.QName("www.claro.com.co", "TableLocationsObject"));
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
