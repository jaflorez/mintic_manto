/**
 * WorkStatusItem.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package co.com.claro.www.workflow;

public class WorkStatusItem  implements java.io.Serializable {
    private java.lang.String workflowTaskID;

    private java.lang.String componentName;

    private java.lang.String componentDescription;

    private java.lang.String componentID;

    private java.lang.String eventType;

    private java.lang.String description;

    private int escalationSequenceNumber;

    private java.lang.String finishPath;

    private java.util.Calendar when;

    public WorkStatusItem() {
    }

    public WorkStatusItem(
           java.lang.String workflowTaskID,
           java.lang.String componentName,
           java.lang.String componentDescription,
           java.lang.String componentID,
           java.lang.String eventType,
           java.lang.String description,
           int escalationSequenceNumber,
           java.lang.String finishPath,
           java.util.Calendar when) {
           this.workflowTaskID = workflowTaskID;
           this.componentName = componentName;
           this.componentDescription = componentDescription;
           this.componentID = componentID;
           this.eventType = eventType;
           this.description = description;
           this.escalationSequenceNumber = escalationSequenceNumber;
           this.finishPath = finishPath;
           this.when = when;
    }


    /**
     * Gets the workflowTaskID value for this WorkStatusItem.
     * 
     * @return workflowTaskID
     */
    public java.lang.String getWorkflowTaskID() {
        return workflowTaskID;
    }


    /**
     * Sets the workflowTaskID value for this WorkStatusItem.
     * 
     * @param workflowTaskID
     */
    public void setWorkflowTaskID(java.lang.String workflowTaskID) {
        this.workflowTaskID = workflowTaskID;
    }


    /**
     * Gets the componentName value for this WorkStatusItem.
     * 
     * @return componentName
     */
    public java.lang.String getComponentName() {
        return componentName;
    }


    /**
     * Sets the componentName value for this WorkStatusItem.
     * 
     * @param componentName
     */
    public void setComponentName(java.lang.String componentName) {
        this.componentName = componentName;
    }


    /**
     * Gets the componentDescription value for this WorkStatusItem.
     * 
     * @return componentDescription
     */
    public java.lang.String getComponentDescription() {
        return componentDescription;
    }


    /**
     * Sets the componentDescription value for this WorkStatusItem.
     * 
     * @param componentDescription
     */
    public void setComponentDescription(java.lang.String componentDescription) {
        this.componentDescription = componentDescription;
    }


    /**
     * Gets the componentID value for this WorkStatusItem.
     * 
     * @return componentID
     */
    public java.lang.String getComponentID() {
        return componentID;
    }


    /**
     * Sets the componentID value for this WorkStatusItem.
     * 
     * @param componentID
     */
    public void setComponentID(java.lang.String componentID) {
        this.componentID = componentID;
    }


    /**
     * Gets the eventType value for this WorkStatusItem.
     * 
     * @return eventType
     */
    public java.lang.String getEventType() {
        return eventType;
    }


    /**
     * Sets the eventType value for this WorkStatusItem.
     * 
     * @param eventType
     */
    public void setEventType(java.lang.String eventType) {
        this.eventType = eventType;
    }


    /**
     * Gets the description value for this WorkStatusItem.
     * 
     * @return description
     */
    public java.lang.String getDescription() {
        return description;
    }


    /**
     * Sets the description value for this WorkStatusItem.
     * 
     * @param description
     */
    public void setDescription(java.lang.String description) {
        this.description = description;
    }


    /**
     * Gets the escalationSequenceNumber value for this WorkStatusItem.
     * 
     * @return escalationSequenceNumber
     */
    public int getEscalationSequenceNumber() {
        return escalationSequenceNumber;
    }


    /**
     * Sets the escalationSequenceNumber value for this WorkStatusItem.
     * 
     * @param escalationSequenceNumber
     */
    public void setEscalationSequenceNumber(int escalationSequenceNumber) {
        this.escalationSequenceNumber = escalationSequenceNumber;
    }


    /**
     * Gets the finishPath value for this WorkStatusItem.
     * 
     * @return finishPath
     */
    public java.lang.String getFinishPath() {
        return finishPath;
    }


    /**
     * Sets the finishPath value for this WorkStatusItem.
     * 
     * @param finishPath
     */
    public void setFinishPath(java.lang.String finishPath) {
        this.finishPath = finishPath;
    }


    /**
     * Gets the when value for this WorkStatusItem.
     * 
     * @return when
     */
    public java.util.Calendar getWhen() {
        return when;
    }


    /**
     * Sets the when value for this WorkStatusItem.
     * 
     * @param when
     */
    public void setWhen(java.util.Calendar when) {
        this.when = when;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof WorkStatusItem)) return false;
        WorkStatusItem other = (WorkStatusItem) obj;
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
            ((this.componentName==null && other.getComponentName()==null) || 
             (this.componentName!=null &&
              this.componentName.equals(other.getComponentName()))) &&
            ((this.componentDescription==null && other.getComponentDescription()==null) || 
             (this.componentDescription!=null &&
              this.componentDescription.equals(other.getComponentDescription()))) &&
            ((this.componentID==null && other.getComponentID()==null) || 
             (this.componentID!=null &&
              this.componentID.equals(other.getComponentID()))) &&
            ((this.eventType==null && other.getEventType()==null) || 
             (this.eventType!=null &&
              this.eventType.equals(other.getEventType()))) &&
            ((this.description==null && other.getDescription()==null) || 
             (this.description!=null &&
              this.description.equals(other.getDescription()))) &&
            this.escalationSequenceNumber == other.getEscalationSequenceNumber() &&
            ((this.finishPath==null && other.getFinishPath()==null) || 
             (this.finishPath!=null &&
              this.finishPath.equals(other.getFinishPath()))) &&
            ((this.when==null && other.getWhen()==null) || 
             (this.when!=null &&
              this.when.equals(other.getWhen())));
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
        if (getComponentName() != null) {
            _hashCode += getComponentName().hashCode();
        }
        if (getComponentDescription() != null) {
            _hashCode += getComponentDescription().hashCode();
        }
        if (getComponentID() != null) {
            _hashCode += getComponentID().hashCode();
        }
        if (getEventType() != null) {
            _hashCode += getEventType().hashCode();
        }
        if (getDescription() != null) {
            _hashCode += getDescription().hashCode();
        }
        _hashCode += getEscalationSequenceNumber();
        if (getFinishPath() != null) {
            _hashCode += getFinishPath().hashCode();
        }
        if (getWhen() != null) {
            _hashCode += getWhen().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(WorkStatusItem.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("www.claro.com.co", "WorkStatusItem"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("workflowTaskID");
        elemField.setXmlName(new javax.xml.namespace.QName("www.claro.com.co", "WorkflowTaskID"));
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
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("componentDescription");
        elemField.setXmlName(new javax.xml.namespace.QName("www.claro.com.co", "ComponentDescription"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("componentID");
        elemField.setXmlName(new javax.xml.namespace.QName("www.claro.com.co", "ComponentID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("eventType");
        elemField.setXmlName(new javax.xml.namespace.QName("www.claro.com.co", "EventType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("description");
        elemField.setXmlName(new javax.xml.namespace.QName("www.claro.com.co", "Description"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("escalationSequenceNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("www.claro.com.co", "EscalationSequenceNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("finishPath");
        elemField.setXmlName(new javax.xml.namespace.QName("www.claro.com.co", "FinishPath"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("when");
        elemField.setXmlName(new javax.xml.namespace.QName("www.claro.com.co", "When"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
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
