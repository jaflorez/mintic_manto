/**
 * TableLocationsObject.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package co.com.claro.www.speedtest;

public class TableLocationsObject  implements java.io.Serializable {
    private int locationID;

    private java.lang.String location_name;

    private java.lang.String beneficiary_code;

    private int enrollment;

    private java.lang.String location_code;

    private java.lang.String wlan_network;

    private java.lang.String address;

    private java.lang.String latitude;

    private java.lang.String longitude;

    private java.lang.Integer institution_id;

    private java.lang.Integer town_id;

    public TableLocationsObject() {
    }

    public TableLocationsObject(
           int locationID,
           java.lang.String location_name,
           java.lang.String beneficiary_code,
           int enrollment,
           java.lang.String location_code,
           java.lang.String wlan_network,
           java.lang.String address,
           java.lang.String latitude,
           java.lang.String longitude,
           java.lang.Integer institution_id,
           java.lang.Integer town_id) {
           this.locationID = locationID;
           this.location_name = location_name;
           this.beneficiary_code = beneficiary_code;
           this.enrollment = enrollment;
           this.location_code = location_code;
           this.wlan_network = wlan_network;
           this.address = address;
           this.latitude = latitude;
           this.longitude = longitude;
           this.institution_id = institution_id;
           this.town_id = town_id;
    }


    /**
     * Gets the locationID value for this TableLocationsObject.
     * 
     * @return locationID
     */
    public int getLocationID() {
        return locationID;
    }


    /**
     * Sets the locationID value for this TableLocationsObject.
     * 
     * @param locationID
     */
    public void setLocationID(int locationID) {
        this.locationID = locationID;
    }


    /**
     * Gets the location_name value for this TableLocationsObject.
     * 
     * @return location_name
     */
    public java.lang.String getLocation_name() {
        return location_name;
    }


    /**
     * Sets the location_name value for this TableLocationsObject.
     * 
     * @param location_name
     */
    public void setLocation_name(java.lang.String location_name) {
        this.location_name = location_name;
    }


    /**
     * Gets the beneficiary_code value for this TableLocationsObject.
     * 
     * @return beneficiary_code
     */
    public java.lang.String getBeneficiary_code() {
        return beneficiary_code;
    }


    /**
     * Sets the beneficiary_code value for this TableLocationsObject.
     * 
     * @param beneficiary_code
     */
    public void setBeneficiary_code(java.lang.String beneficiary_code) {
        this.beneficiary_code = beneficiary_code;
    }


    /**
     * Gets the enrollment value for this TableLocationsObject.
     * 
     * @return enrollment
     */
    public int getEnrollment() {
        return enrollment;
    }


    /**
     * Sets the enrollment value for this TableLocationsObject.
     * 
     * @param enrollment
     */
    public void setEnrollment(int enrollment) {
        this.enrollment = enrollment;
    }


    /**
     * Gets the location_code value for this TableLocationsObject.
     * 
     * @return location_code
     */
    public java.lang.String getLocation_code() {
        return location_code;
    }


    /**
     * Sets the location_code value for this TableLocationsObject.
     * 
     * @param location_code
     */
    public void setLocation_code(java.lang.String location_code) {
        this.location_code = location_code;
    }


    /**
     * Gets the wlan_network value for this TableLocationsObject.
     * 
     * @return wlan_network
     */
    public java.lang.String getWlan_network() {
        return wlan_network;
    }


    /**
     * Sets the wlan_network value for this TableLocationsObject.
     * 
     * @param wlan_network
     */
    public void setWlan_network(java.lang.String wlan_network) {
        this.wlan_network = wlan_network;
    }


    /**
     * Gets the address value for this TableLocationsObject.
     * 
     * @return address
     */
    public java.lang.String getAddress() {
        return address;
    }


    /**
     * Sets the address value for this TableLocationsObject.
     * 
     * @param address
     */
    public void setAddress(java.lang.String address) {
        this.address = address;
    }


    /**
     * Gets the latitude value for this TableLocationsObject.
     * 
     * @return latitude
     */
    public java.lang.String getLatitude() {
        return latitude;
    }


    /**
     * Sets the latitude value for this TableLocationsObject.
     * 
     * @param latitude
     */
    public void setLatitude(java.lang.String latitude) {
        this.latitude = latitude;
    }


    /**
     * Gets the longitude value for this TableLocationsObject.
     * 
     * @return longitude
     */
    public java.lang.String getLongitude() {
        return longitude;
    }


    /**
     * Sets the longitude value for this TableLocationsObject.
     * 
     * @param longitude
     */
    public void setLongitude(java.lang.String longitude) {
        this.longitude = longitude;
    }


    /**
     * Gets the institution_id value for this TableLocationsObject.
     * 
     * @return institution_id
     */
    public java.lang.Integer getInstitution_id() {
        return institution_id;
    }


    /**
     * Sets the institution_id value for this TableLocationsObject.
     * 
     * @param institution_id
     */
    public void setInstitution_id(java.lang.Integer institution_id) {
        this.institution_id = institution_id;
    }


    /**
     * Gets the town_id value for this TableLocationsObject.
     * 
     * @return town_id
     */
    public java.lang.Integer getTown_id() {
        return town_id;
    }


    /**
     * Sets the town_id value for this TableLocationsObject.
     * 
     * @param town_id
     */
    public void setTown_id(java.lang.Integer town_id) {
        this.town_id = town_id;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof TableLocationsObject)) return false;
        TableLocationsObject other = (TableLocationsObject) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.locationID == other.getLocationID() &&
            ((this.location_name==null && other.getLocation_name()==null) || 
             (this.location_name!=null &&
              this.location_name.equals(other.getLocation_name()))) &&
            ((this.beneficiary_code==null && other.getBeneficiary_code()==null) || 
             (this.beneficiary_code!=null &&
              this.beneficiary_code.equals(other.getBeneficiary_code()))) &&
            this.enrollment == other.getEnrollment() &&
            ((this.location_code==null && other.getLocation_code()==null) || 
             (this.location_code!=null &&
              this.location_code.equals(other.getLocation_code()))) &&
            ((this.wlan_network==null && other.getWlan_network()==null) || 
             (this.wlan_network!=null &&
              this.wlan_network.equals(other.getWlan_network()))) &&
            ((this.address==null && other.getAddress()==null) || 
             (this.address!=null &&
              this.address.equals(other.getAddress()))) &&
            ((this.latitude==null && other.getLatitude()==null) || 
             (this.latitude!=null &&
              this.latitude.equals(other.getLatitude()))) &&
            ((this.longitude==null && other.getLongitude()==null) || 
             (this.longitude!=null &&
              this.longitude.equals(other.getLongitude()))) &&
            ((this.institution_id==null && other.getInstitution_id()==null) || 
             (this.institution_id!=null &&
              this.institution_id.equals(other.getInstitution_id()))) &&
            ((this.town_id==null && other.getTown_id()==null) || 
             (this.town_id!=null &&
              this.town_id.equals(other.getTown_id())));
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
        _hashCode += getLocationID();
        if (getLocation_name() != null) {
            _hashCode += getLocation_name().hashCode();
        }
        if (getBeneficiary_code() != null) {
            _hashCode += getBeneficiary_code().hashCode();
        }
        _hashCode += getEnrollment();
        if (getLocation_code() != null) {
            _hashCode += getLocation_code().hashCode();
        }
        if (getWlan_network() != null) {
            _hashCode += getWlan_network().hashCode();
        }
        if (getAddress() != null) {
            _hashCode += getAddress().hashCode();
        }
        if (getLatitude() != null) {
            _hashCode += getLatitude().hashCode();
        }
        if (getLongitude() != null) {
            _hashCode += getLongitude().hashCode();
        }
        if (getInstitution_id() != null) {
            _hashCode += getInstitution_id().hashCode();
        }
        if (getTown_id() != null) {
            _hashCode += getTown_id().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(TableLocationsObject.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("www.claro.com.co", "TableLocationsObject"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("locationID");
        elemField.setXmlName(new javax.xml.namespace.QName("www.claro.com.co", "locationID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("location_name");
        elemField.setXmlName(new javax.xml.namespace.QName("www.claro.com.co", "location_name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("beneficiary_code");
        elemField.setXmlName(new javax.xml.namespace.QName("www.claro.com.co", "beneficiary_code"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("enrollment");
        elemField.setXmlName(new javax.xml.namespace.QName("www.claro.com.co", "enrollment"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("location_code");
        elemField.setXmlName(new javax.xml.namespace.QName("www.claro.com.co", "location_code"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("wlan_network");
        elemField.setXmlName(new javax.xml.namespace.QName("www.claro.com.co", "wlan_network"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("address");
        elemField.setXmlName(new javax.xml.namespace.QName("www.claro.com.co", "address"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("latitude");
        elemField.setXmlName(new javax.xml.namespace.QName("www.claro.com.co", "latitude"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("longitude");
        elemField.setXmlName(new javax.xml.namespace.QName("www.claro.com.co", "longitude"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("institution_id");
        elemField.setXmlName(new javax.xml.namespace.QName("www.claro.com.co", "institution_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("town_id");
        elemField.setXmlName(new javax.xml.namespace.QName("www.claro.com.co", "town_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(true);
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
