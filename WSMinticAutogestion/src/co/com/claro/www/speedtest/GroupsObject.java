/**
 * GroupsObject.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package co.com.claro.www.speedtest;

public class GroupsObject  implements java.io.Serializable {
    private int groupID;

    private java.lang.String group_name;

    private java.lang.String schedule;

    private boolean group_enabled;

    public GroupsObject() {
    }

    public GroupsObject(
           int groupID,
           java.lang.String group_name,
           java.lang.String schedule,
           boolean group_enabled) {
           this.groupID = groupID;
           this.group_name = group_name;
           this.schedule = schedule;
           this.group_enabled = group_enabled;
    }


    /**
     * Gets the groupID value for this GroupsObject.
     * 
     * @return groupID
     */
    public int getGroupID() {
        return groupID;
    }


    /**
     * Sets the groupID value for this GroupsObject.
     * 
     * @param groupID
     */
    public void setGroupID(int groupID) {
        this.groupID = groupID;
    }


    /**
     * Gets the group_name value for this GroupsObject.
     * 
     * @return group_name
     */
    public java.lang.String getGroup_name() {
        return group_name;
    }


    /**
     * Sets the group_name value for this GroupsObject.
     * 
     * @param group_name
     */
    public void setGroup_name(java.lang.String group_name) {
        this.group_name = group_name;
    }


    /**
     * Gets the schedule value for this GroupsObject.
     * 
     * @return schedule
     */
    public java.lang.String getSchedule() {
        return schedule;
    }


    /**
     * Sets the schedule value for this GroupsObject.
     * 
     * @param schedule
     */
    public void setSchedule(java.lang.String schedule) {
        this.schedule = schedule;
    }


    /**
     * Gets the group_enabled value for this GroupsObject.
     * 
     * @return group_enabled
     */
    public boolean isGroup_enabled() {
        return group_enabled;
    }


    /**
     * Sets the group_enabled value for this GroupsObject.
     * 
     * @param group_enabled
     */
    public void setGroup_enabled(boolean group_enabled) {
        this.group_enabled = group_enabled;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GroupsObject)) return false;
        GroupsObject other = (GroupsObject) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.groupID == other.getGroupID() &&
            ((this.group_name==null && other.getGroup_name()==null) || 
             (this.group_name!=null &&
              this.group_name.equals(other.getGroup_name()))) &&
            ((this.schedule==null && other.getSchedule()==null) || 
             (this.schedule!=null &&
              this.schedule.equals(other.getSchedule()))) &&
            this.group_enabled == other.isGroup_enabled();
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
        _hashCode += getGroupID();
        if (getGroup_name() != null) {
            _hashCode += getGroup_name().hashCode();
        }
        if (getSchedule() != null) {
            _hashCode += getSchedule().hashCode();
        }
        _hashCode += (isGroup_enabled() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GroupsObject.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("www.claro.com.co", "GroupsObject"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("groupID");
        elemField.setXmlName(new javax.xml.namespace.QName("www.claro.com.co", "groupID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("group_name");
        elemField.setXmlName(new javax.xml.namespace.QName("www.claro.com.co", "group_name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("schedule");
        elemField.setXmlName(new javax.xml.namespace.QName("www.claro.com.co", "schedule"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("group_enabled");
        elemField.setXmlName(new javax.xml.namespace.QName("www.claro.com.co", "group_enabled"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
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
