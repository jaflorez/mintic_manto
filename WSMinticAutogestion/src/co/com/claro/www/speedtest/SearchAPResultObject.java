/**
 * SearchAPResultObject.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package co.com.claro.www.speedtest;

public class SearchAPResultObject  implements java.io.Serializable {
    private int ap_id;

    private java.lang.String ap_hostname;

    private java.lang.String ap_ip;

    private java.lang.String ap_type;

    private java.lang.String ap_model;

    private java.math.BigDecimal bw_download;

    private java.math.BigDecimal bw_upload;

    private boolean satellite;

    private boolean enabled;

    private int location_id;

    private java.lang.String location_name;

    private int department_id;

    private java.lang.String department_name;

    private int town_id;

    private java.lang.String town_name;

    private co.com.claro.www.speedtest.KeyValueDataType[] groups;

    private java.lang.String location_code;

    private java.lang.String department_code;

    private java.lang.String town_code;

    private int institution_id;

    private java.lang.String institution_name;

    private java.lang.String institution_code;

    private java.lang.String institution_type_name;

    private java.lang.String location_beneficiary;

    private int enrollment;

    private boolean terceros;

    private java.lang.String account_number;

    private int beam_id;

    private java.lang.String mintic_id;

    private java.util.Calendar date_created;

    private java.util.Calendar date_modified;

    private java.lang.String modified_by;

    public SearchAPResultObject() {
    }

    public SearchAPResultObject(
           int ap_id,
           java.lang.String ap_hostname,
           java.lang.String ap_ip,
           java.lang.String ap_type,
           java.lang.String ap_model,
           java.math.BigDecimal bw_download,
           java.math.BigDecimal bw_upload,
           boolean satellite,
           boolean enabled,
           int location_id,
           java.lang.String location_name,
           int department_id,
           java.lang.String department_name,
           int town_id,
           java.lang.String town_name,
           co.com.claro.www.speedtest.KeyValueDataType[] groups,
           java.lang.String location_code,
           java.lang.String department_code,
           java.lang.String town_code,
           int institution_id,
           java.lang.String institution_name,
           java.lang.String institution_code,
           java.lang.String institution_type_name,
           java.lang.String location_beneficiary,
           int enrollment,
           boolean terceros,
           java.lang.String account_number,
           int beam_id,
           java.lang.String mintic_id,
           java.util.Calendar date_created,
           java.util.Calendar date_modified,
           java.lang.String modified_by) {
           this.ap_id = ap_id;
           this.ap_hostname = ap_hostname;
           this.ap_ip = ap_ip;
           this.ap_type = ap_type;
           this.ap_model = ap_model;
           this.bw_download = bw_download;
           this.bw_upload = bw_upload;
           this.satellite = satellite;
           this.enabled = enabled;
           this.location_id = location_id;
           this.location_name = location_name;
           this.department_id = department_id;
           this.department_name = department_name;
           this.town_id = town_id;
           this.town_name = town_name;
           this.groups = groups;
           this.location_code = location_code;
           this.department_code = department_code;
           this.town_code = town_code;
           this.institution_id = institution_id;
           this.institution_name = institution_name;
           this.institution_code = institution_code;
           this.institution_type_name = institution_type_name;
           this.location_beneficiary = location_beneficiary;
           this.enrollment = enrollment;
           this.terceros = terceros;
           this.account_number = account_number;
           this.beam_id = beam_id;
           this.mintic_id = mintic_id;
           this.date_created = date_created;
           this.date_modified = date_modified;
           this.modified_by = modified_by;
    }


    /**
     * Gets the ap_id value for this SearchAPResultObject.
     * 
     * @return ap_id
     */
    public int getAp_id() {
        return ap_id;
    }


    /**
     * Sets the ap_id value for this SearchAPResultObject.
     * 
     * @param ap_id
     */
    public void setAp_id(int ap_id) {
        this.ap_id = ap_id;
    }


    /**
     * Gets the ap_hostname value for this SearchAPResultObject.
     * 
     * @return ap_hostname
     */
    public java.lang.String getAp_hostname() {
        return ap_hostname;
    }


    /**
     * Sets the ap_hostname value for this SearchAPResultObject.
     * 
     * @param ap_hostname
     */
    public void setAp_hostname(java.lang.String ap_hostname) {
        this.ap_hostname = ap_hostname;
    }


    /**
     * Gets the ap_ip value for this SearchAPResultObject.
     * 
     * @return ap_ip
     */
    public java.lang.String getAp_ip() {
        return ap_ip;
    }


    /**
     * Sets the ap_ip value for this SearchAPResultObject.
     * 
     * @param ap_ip
     */
    public void setAp_ip(java.lang.String ap_ip) {
        this.ap_ip = ap_ip;
    }


    /**
     * Gets the ap_type value for this SearchAPResultObject.
     * 
     * @return ap_type
     */
    public java.lang.String getAp_type() {
        return ap_type;
    }


    /**
     * Sets the ap_type value for this SearchAPResultObject.
     * 
     * @param ap_type
     */
    public void setAp_type(java.lang.String ap_type) {
        this.ap_type = ap_type;
    }


    /**
     * Gets the ap_model value for this SearchAPResultObject.
     * 
     * @return ap_model
     */
    public java.lang.String getAp_model() {
        return ap_model;
    }


    /**
     * Sets the ap_model value for this SearchAPResultObject.
     * 
     * @param ap_model
     */
    public void setAp_model(java.lang.String ap_model) {
        this.ap_model = ap_model;
    }


    /**
     * Gets the bw_download value for this SearchAPResultObject.
     * 
     * @return bw_download
     */
    public java.math.BigDecimal getBw_download() {
        return bw_download;
    }


    /**
     * Sets the bw_download value for this SearchAPResultObject.
     * 
     * @param bw_download
     */
    public void setBw_download(java.math.BigDecimal bw_download) {
        this.bw_download = bw_download;
    }


    /**
     * Gets the bw_upload value for this SearchAPResultObject.
     * 
     * @return bw_upload
     */
    public java.math.BigDecimal getBw_upload() {
        return bw_upload;
    }


    /**
     * Sets the bw_upload value for this SearchAPResultObject.
     * 
     * @param bw_upload
     */
    public void setBw_upload(java.math.BigDecimal bw_upload) {
        this.bw_upload = bw_upload;
    }


    /**
     * Gets the satellite value for this SearchAPResultObject.
     * 
     * @return satellite
     */
    public boolean isSatellite() {
        return satellite;
    }


    /**
     * Sets the satellite value for this SearchAPResultObject.
     * 
     * @param satellite
     */
    public void setSatellite(boolean satellite) {
        this.satellite = satellite;
    }


    /**
     * Gets the enabled value for this SearchAPResultObject.
     * 
     * @return enabled
     */
    public boolean isEnabled() {
        return enabled;
    }


    /**
     * Sets the enabled value for this SearchAPResultObject.
     * 
     * @param enabled
     */
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }


    /**
     * Gets the location_id value for this SearchAPResultObject.
     * 
     * @return location_id
     */
    public int getLocation_id() {
        return location_id;
    }


    /**
     * Sets the location_id value for this SearchAPResultObject.
     * 
     * @param location_id
     */
    public void setLocation_id(int location_id) {
        this.location_id = location_id;
    }


    /**
     * Gets the location_name value for this SearchAPResultObject.
     * 
     * @return location_name
     */
    public java.lang.String getLocation_name() {
        return location_name;
    }


    /**
     * Sets the location_name value for this SearchAPResultObject.
     * 
     * @param location_name
     */
    public void setLocation_name(java.lang.String location_name) {
        this.location_name = location_name;
    }


    /**
     * Gets the department_id value for this SearchAPResultObject.
     * 
     * @return department_id
     */
    public int getDepartment_id() {
        return department_id;
    }


    /**
     * Sets the department_id value for this SearchAPResultObject.
     * 
     * @param department_id
     */
    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }


    /**
     * Gets the department_name value for this SearchAPResultObject.
     * 
     * @return department_name
     */
    public java.lang.String getDepartment_name() {
        return department_name;
    }


    /**
     * Sets the department_name value for this SearchAPResultObject.
     * 
     * @param department_name
     */
    public void setDepartment_name(java.lang.String department_name) {
        this.department_name = department_name;
    }


    /**
     * Gets the town_id value for this SearchAPResultObject.
     * 
     * @return town_id
     */
    public int getTown_id() {
        return town_id;
    }


    /**
     * Sets the town_id value for this SearchAPResultObject.
     * 
     * @param town_id
     */
    public void setTown_id(int town_id) {
        this.town_id = town_id;
    }


    /**
     * Gets the town_name value for this SearchAPResultObject.
     * 
     * @return town_name
     */
    public java.lang.String getTown_name() {
        return town_name;
    }


    /**
     * Sets the town_name value for this SearchAPResultObject.
     * 
     * @param town_name
     */
    public void setTown_name(java.lang.String town_name) {
        this.town_name = town_name;
    }


    /**
     * Gets the groups value for this SearchAPResultObject.
     * 
     * @return groups
     */
    public co.com.claro.www.speedtest.KeyValueDataType[] getGroups() {
        return groups;
    }


    /**
     * Sets the groups value for this SearchAPResultObject.
     * 
     * @param groups
     */
    public void setGroups(co.com.claro.www.speedtest.KeyValueDataType[] groups) {
        this.groups = groups;
    }


    /**
     * Gets the location_code value for this SearchAPResultObject.
     * 
     * @return location_code
     */
    public java.lang.String getLocation_code() {
        return location_code;
    }


    /**
     * Sets the location_code value for this SearchAPResultObject.
     * 
     * @param location_code
     */
    public void setLocation_code(java.lang.String location_code) {
        this.location_code = location_code;
    }


    /**
     * Gets the department_code value for this SearchAPResultObject.
     * 
     * @return department_code
     */
    public java.lang.String getDepartment_code() {
        return department_code;
    }


    /**
     * Sets the department_code value for this SearchAPResultObject.
     * 
     * @param department_code
     */
    public void setDepartment_code(java.lang.String department_code) {
        this.department_code = department_code;
    }


    /**
     * Gets the town_code value for this SearchAPResultObject.
     * 
     * @return town_code
     */
    public java.lang.String getTown_code() {
        return town_code;
    }


    /**
     * Sets the town_code value for this SearchAPResultObject.
     * 
     * @param town_code
     */
    public void setTown_code(java.lang.String town_code) {
        this.town_code = town_code;
    }


    /**
     * Gets the institution_id value for this SearchAPResultObject.
     * 
     * @return institution_id
     */
    public int getInstitution_id() {
        return institution_id;
    }


    /**
     * Sets the institution_id value for this SearchAPResultObject.
     * 
     * @param institution_id
     */
    public void setInstitution_id(int institution_id) {
        this.institution_id = institution_id;
    }


    /**
     * Gets the institution_name value for this SearchAPResultObject.
     * 
     * @return institution_name
     */
    public java.lang.String getInstitution_name() {
        return institution_name;
    }


    /**
     * Sets the institution_name value for this SearchAPResultObject.
     * 
     * @param institution_name
     */
    public void setInstitution_name(java.lang.String institution_name) {
        this.institution_name = institution_name;
    }


    /**
     * Gets the institution_code value for this SearchAPResultObject.
     * 
     * @return institution_code
     */
    public java.lang.String getInstitution_code() {
        return institution_code;
    }


    /**
     * Sets the institution_code value for this SearchAPResultObject.
     * 
     * @param institution_code
     */
    public void setInstitution_code(java.lang.String institution_code) {
        this.institution_code = institution_code;
    }


    /**
     * Gets the institution_type_name value for this SearchAPResultObject.
     * 
     * @return institution_type_name
     */
    public java.lang.String getInstitution_type_name() {
        return institution_type_name;
    }


    /**
     * Sets the institution_type_name value for this SearchAPResultObject.
     * 
     * @param institution_type_name
     */
    public void setInstitution_type_name(java.lang.String institution_type_name) {
        this.institution_type_name = institution_type_name;
    }


    /**
     * Gets the location_beneficiary value for this SearchAPResultObject.
     * 
     * @return location_beneficiary
     */
    public java.lang.String getLocation_beneficiary() {
        return location_beneficiary;
    }


    /**
     * Sets the location_beneficiary value for this SearchAPResultObject.
     * 
     * @param location_beneficiary
     */
    public void setLocation_beneficiary(java.lang.String location_beneficiary) {
        this.location_beneficiary = location_beneficiary;
    }


    /**
     * Gets the enrollment value for this SearchAPResultObject.
     * 
     * @return enrollment
     */
    public int getEnrollment() {
        return enrollment;
    }


    /**
     * Sets the enrollment value for this SearchAPResultObject.
     * 
     * @param enrollment
     */
    public void setEnrollment(int enrollment) {
        this.enrollment = enrollment;
    }


    /**
     * Gets the terceros value for this SearchAPResultObject.
     * 
     * @return terceros
     */
    public boolean isTerceros() {
        return terceros;
    }


    /**
     * Sets the terceros value for this SearchAPResultObject.
     * 
     * @param terceros
     */
    public void setTerceros(boolean terceros) {
        this.terceros = terceros;
    }


    /**
     * Gets the account_number value for this SearchAPResultObject.
     * 
     * @return account_number
     */
    public java.lang.String getAccount_number() {
        return account_number;
    }


    /**
     * Sets the account_number value for this SearchAPResultObject.
     * 
     * @param account_number
     */
    public void setAccount_number(java.lang.String account_number) {
        this.account_number = account_number;
    }


    /**
     * Gets the beam_id value for this SearchAPResultObject.
     * 
     * @return beam_id
     */
    public int getBeam_id() {
        return beam_id;
    }


    /**
     * Sets the beam_id value for this SearchAPResultObject.
     * 
     * @param beam_id
     */
    public void setBeam_id(int beam_id) {
        this.beam_id = beam_id;
    }


    /**
     * Gets the mintic_id value for this SearchAPResultObject.
     * 
     * @return mintic_id
     */
    public java.lang.String getMintic_id() {
        return mintic_id;
    }


    /**
     * Sets the mintic_id value for this SearchAPResultObject.
     * 
     * @param mintic_id
     */
    public void setMintic_id(java.lang.String mintic_id) {
        this.mintic_id = mintic_id;
    }


    /**
     * Gets the date_created value for this SearchAPResultObject.
     * 
     * @return date_created
     */
    public java.util.Calendar getDate_created() {
        return date_created;
    }


    /**
     * Sets the date_created value for this SearchAPResultObject.
     * 
     * @param date_created
     */
    public void setDate_created(java.util.Calendar date_created) {
        this.date_created = date_created;
    }


    /**
     * Gets the date_modified value for this SearchAPResultObject.
     * 
     * @return date_modified
     */
    public java.util.Calendar getDate_modified() {
        return date_modified;
    }


    /**
     * Sets the date_modified value for this SearchAPResultObject.
     * 
     * @param date_modified
     */
    public void setDate_modified(java.util.Calendar date_modified) {
        this.date_modified = date_modified;
    }


    /**
     * Gets the modified_by value for this SearchAPResultObject.
     * 
     * @return modified_by
     */
    public java.lang.String getModified_by() {
        return modified_by;
    }


    /**
     * Sets the modified_by value for this SearchAPResultObject.
     * 
     * @param modified_by
     */
    public void setModified_by(java.lang.String modified_by) {
        this.modified_by = modified_by;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SearchAPResultObject)) return false;
        SearchAPResultObject other = (SearchAPResultObject) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.ap_id == other.getAp_id() &&
            ((this.ap_hostname==null && other.getAp_hostname()==null) || 
             (this.ap_hostname!=null &&
              this.ap_hostname.equals(other.getAp_hostname()))) &&
            ((this.ap_ip==null && other.getAp_ip()==null) || 
             (this.ap_ip!=null &&
              this.ap_ip.equals(other.getAp_ip()))) &&
            ((this.ap_type==null && other.getAp_type()==null) || 
             (this.ap_type!=null &&
              this.ap_type.equals(other.getAp_type()))) &&
            ((this.ap_model==null && other.getAp_model()==null) || 
             (this.ap_model!=null &&
              this.ap_model.equals(other.getAp_model()))) &&
            ((this.bw_download==null && other.getBw_download()==null) || 
             (this.bw_download!=null &&
              this.bw_download.equals(other.getBw_download()))) &&
            ((this.bw_upload==null && other.getBw_upload()==null) || 
             (this.bw_upload!=null &&
              this.bw_upload.equals(other.getBw_upload()))) &&
            this.satellite == other.isSatellite() &&
            this.enabled == other.isEnabled() &&
            this.location_id == other.getLocation_id() &&
            ((this.location_name==null && other.getLocation_name()==null) || 
             (this.location_name!=null &&
              this.location_name.equals(other.getLocation_name()))) &&
            this.department_id == other.getDepartment_id() &&
            ((this.department_name==null && other.getDepartment_name()==null) || 
             (this.department_name!=null &&
              this.department_name.equals(other.getDepartment_name()))) &&
            this.town_id == other.getTown_id() &&
            ((this.town_name==null && other.getTown_name()==null) || 
             (this.town_name!=null &&
              this.town_name.equals(other.getTown_name()))) &&
            ((this.groups==null && other.getGroups()==null) || 
             (this.groups!=null &&
              java.util.Arrays.equals(this.groups, other.getGroups()))) &&
            ((this.location_code==null && other.getLocation_code()==null) || 
             (this.location_code!=null &&
              this.location_code.equals(other.getLocation_code()))) &&
            ((this.department_code==null && other.getDepartment_code()==null) || 
             (this.department_code!=null &&
              this.department_code.equals(other.getDepartment_code()))) &&
            ((this.town_code==null && other.getTown_code()==null) || 
             (this.town_code!=null &&
              this.town_code.equals(other.getTown_code()))) &&
            this.institution_id == other.getInstitution_id() &&
            ((this.institution_name==null && other.getInstitution_name()==null) || 
             (this.institution_name!=null &&
              this.institution_name.equals(other.getInstitution_name()))) &&
            ((this.institution_code==null && other.getInstitution_code()==null) || 
             (this.institution_code!=null &&
              this.institution_code.equals(other.getInstitution_code()))) &&
            ((this.institution_type_name==null && other.getInstitution_type_name()==null) || 
             (this.institution_type_name!=null &&
              this.institution_type_name.equals(other.getInstitution_type_name()))) &&
            ((this.location_beneficiary==null && other.getLocation_beneficiary()==null) || 
             (this.location_beneficiary!=null &&
              this.location_beneficiary.equals(other.getLocation_beneficiary()))) &&
            this.enrollment == other.getEnrollment() &&
            this.terceros == other.isTerceros() &&
            ((this.account_number==null && other.getAccount_number()==null) || 
             (this.account_number!=null &&
              this.account_number.equals(other.getAccount_number()))) &&
            this.beam_id == other.getBeam_id() &&
            ((this.mintic_id==null && other.getMintic_id()==null) || 
             (this.mintic_id!=null &&
              this.mintic_id.equals(other.getMintic_id()))) &&
            ((this.date_created==null && other.getDate_created()==null) || 
             (this.date_created!=null &&
              this.date_created.equals(other.getDate_created()))) &&
            ((this.date_modified==null && other.getDate_modified()==null) || 
             (this.date_modified!=null &&
              this.date_modified.equals(other.getDate_modified()))) &&
            ((this.modified_by==null && other.getModified_by()==null) || 
             (this.modified_by!=null &&
              this.modified_by.equals(other.getModified_by())));
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
        _hashCode += getAp_id();
        if (getAp_hostname() != null) {
            _hashCode += getAp_hostname().hashCode();
        }
        if (getAp_ip() != null) {
            _hashCode += getAp_ip().hashCode();
        }
        if (getAp_type() != null) {
            _hashCode += getAp_type().hashCode();
        }
        if (getAp_model() != null) {
            _hashCode += getAp_model().hashCode();
        }
        if (getBw_download() != null) {
            _hashCode += getBw_download().hashCode();
        }
        if (getBw_upload() != null) {
            _hashCode += getBw_upload().hashCode();
        }
        _hashCode += (isSatellite() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isEnabled() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += getLocation_id();
        if (getLocation_name() != null) {
            _hashCode += getLocation_name().hashCode();
        }
        _hashCode += getDepartment_id();
        if (getDepartment_name() != null) {
            _hashCode += getDepartment_name().hashCode();
        }
        _hashCode += getTown_id();
        if (getTown_name() != null) {
            _hashCode += getTown_name().hashCode();
        }
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
        if (getLocation_code() != null) {
            _hashCode += getLocation_code().hashCode();
        }
        if (getDepartment_code() != null) {
            _hashCode += getDepartment_code().hashCode();
        }
        if (getTown_code() != null) {
            _hashCode += getTown_code().hashCode();
        }
        _hashCode += getInstitution_id();
        if (getInstitution_name() != null) {
            _hashCode += getInstitution_name().hashCode();
        }
        if (getInstitution_code() != null) {
            _hashCode += getInstitution_code().hashCode();
        }
        if (getInstitution_type_name() != null) {
            _hashCode += getInstitution_type_name().hashCode();
        }
        if (getLocation_beneficiary() != null) {
            _hashCode += getLocation_beneficiary().hashCode();
        }
        _hashCode += getEnrollment();
        _hashCode += (isTerceros() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getAccount_number() != null) {
            _hashCode += getAccount_number().hashCode();
        }
        _hashCode += getBeam_id();
        if (getMintic_id() != null) {
            _hashCode += getMintic_id().hashCode();
        }
        if (getDate_created() != null) {
            _hashCode += getDate_created().hashCode();
        }
        if (getDate_modified() != null) {
            _hashCode += getDate_modified().hashCode();
        }
        if (getModified_by() != null) {
            _hashCode += getModified_by().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SearchAPResultObject.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("www.claro.com.co", "SearchAPResultObject"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ap_id");
        elemField.setXmlName(new javax.xml.namespace.QName("www.claro.com.co", "ap_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ap_hostname");
        elemField.setXmlName(new javax.xml.namespace.QName("www.claro.com.co", "ap_hostname"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ap_ip");
        elemField.setXmlName(new javax.xml.namespace.QName("www.claro.com.co", "ap_ip"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ap_type");
        elemField.setXmlName(new javax.xml.namespace.QName("www.claro.com.co", "ap_type"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ap_model");
        elemField.setXmlName(new javax.xml.namespace.QName("www.claro.com.co", "ap_model"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bw_download");
        elemField.setXmlName(new javax.xml.namespace.QName("www.claro.com.co", "bw_download"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bw_upload");
        elemField.setXmlName(new javax.xml.namespace.QName("www.claro.com.co", "bw_upload"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("satellite");
        elemField.setXmlName(new javax.xml.namespace.QName("www.claro.com.co", "satellite"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("enabled");
        elemField.setXmlName(new javax.xml.namespace.QName("www.claro.com.co", "enabled"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("location_id");
        elemField.setXmlName(new javax.xml.namespace.QName("www.claro.com.co", "location_id"));
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
        elemField.setFieldName("department_id");
        elemField.setXmlName(new javax.xml.namespace.QName("www.claro.com.co", "department_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("department_name");
        elemField.setXmlName(new javax.xml.namespace.QName("www.claro.com.co", "department_name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("town_id");
        elemField.setXmlName(new javax.xml.namespace.QName("www.claro.com.co", "town_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("town_name");
        elemField.setXmlName(new javax.xml.namespace.QName("www.claro.com.co", "town_name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("groups");
        elemField.setXmlName(new javax.xml.namespace.QName("www.claro.com.co", "groups"));
        elemField.setXmlType(new javax.xml.namespace.QName("www.claro.com.co", "KeyValueDataType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("www.claro.com.co", "KeyValueDataType"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("location_code");
        elemField.setXmlName(new javax.xml.namespace.QName("www.claro.com.co", "location_code"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("department_code");
        elemField.setXmlName(new javax.xml.namespace.QName("www.claro.com.co", "department_code"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("town_code");
        elemField.setXmlName(new javax.xml.namespace.QName("www.claro.com.co", "town_code"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("institution_id");
        elemField.setXmlName(new javax.xml.namespace.QName("www.claro.com.co", "institution_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("institution_name");
        elemField.setXmlName(new javax.xml.namespace.QName("www.claro.com.co", "institution_name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("institution_code");
        elemField.setXmlName(new javax.xml.namespace.QName("www.claro.com.co", "institution_code"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("institution_type_name");
        elemField.setXmlName(new javax.xml.namespace.QName("www.claro.com.co", "institution_type_name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("location_beneficiary");
        elemField.setXmlName(new javax.xml.namespace.QName("www.claro.com.co", "location_beneficiary"));
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
        elemField.setFieldName("terceros");
        elemField.setXmlName(new javax.xml.namespace.QName("www.claro.com.co", "terceros"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("account_number");
        elemField.setXmlName(new javax.xml.namespace.QName("www.claro.com.co", "account_number"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("beam_id");
        elemField.setXmlName(new javax.xml.namespace.QName("www.claro.com.co", "beam_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mintic_id");
        elemField.setXmlName(new javax.xml.namespace.QName("www.claro.com.co", "mintic_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("date_created");
        elemField.setXmlName(new javax.xml.namespace.QName("www.claro.com.co", "date_created"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("date_modified");
        elemField.setXmlName(new javax.xml.namespace.QName("www.claro.com.co", "date_modified"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("modified_by");
        elemField.setXmlName(new javax.xml.namespace.QName("www.claro.com.co", "modified_by"));
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
