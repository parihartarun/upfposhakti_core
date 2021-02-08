/**
 * UPAGRIResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.upfpo.app.upagri;

public class UPAGRIResponse  implements java.io.Serializable {
    private com.upfpo.app.upagri.UPAGRIResponseUPAGRIResult UPAGRIResult;

    public UPAGRIResponse() {
    }

    public UPAGRIResponse(
           com.upfpo.app.upagri.UPAGRIResponseUPAGRIResult UPAGRIResult) {
           this.UPAGRIResult = UPAGRIResult;
    }


    /**
     * Gets the UPAGRIResult value for this UPAGRIResponse.
     * 
     * @return UPAGRIResult
     */
    public com.upfpo.app.upagri.UPAGRIResponseUPAGRIResult getUPAGRIResult() {
        return UPAGRIResult;
    }


    /**
     * Sets the UPAGRIResult value for this UPAGRIResponse.
     * 
     * @param UPAGRIResult
     */
    public void setUPAGRIResult(com.upfpo.app.upagri.UPAGRIResponseUPAGRIResult UPAGRIResult) {
        this.UPAGRIResult = UPAGRIResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof UPAGRIResponse)) return false;
        UPAGRIResponse other = (UPAGRIResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.UPAGRIResult==null && other.getUPAGRIResult()==null) || 
             (this.UPAGRIResult!=null &&
              this.UPAGRIResult.equals(other.getUPAGRIResult())));
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
        if (getUPAGRIResult() != null) {
            _hashCode += getUPAGRIResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(UPAGRIResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">UPAGRIResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("UPAGRIResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "UPAGRIResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>UPAGRIResponse>UPAGRIResult"));
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
