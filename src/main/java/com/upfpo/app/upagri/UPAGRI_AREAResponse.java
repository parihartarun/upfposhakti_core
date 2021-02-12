/**
 * UPAGRI_AREAResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.upfpo.app.upagri;

public class UPAGRI_AREAResponse  implements java.io.Serializable {
    private com.upfpo.app.upagri.UPAGRI_AREAResponseUPAGRI_AREAResult UPAGRI_AREAResult;

    public UPAGRI_AREAResponse() {
    }

    public UPAGRI_AREAResponse(
           com.upfpo.app.upagri.UPAGRI_AREAResponseUPAGRI_AREAResult UPAGRI_AREAResult) {
           this.UPAGRI_AREAResult = UPAGRI_AREAResult;
    }


    /**
     * Gets the UPAGRI_AREAResult value for this UPAGRI_AREAResponse.
     * 
     * @return UPAGRI_AREAResult
     */
    public com.upfpo.app.upagri.UPAGRI_AREAResponseUPAGRI_AREAResult getUPAGRI_AREAResult() {
        return UPAGRI_AREAResult;
    }


    /**
     * Sets the UPAGRI_AREAResult value for this UPAGRI_AREAResponse.
     * 
     * @param UPAGRI_AREAResult
     */
    public void setUPAGRI_AREAResult(com.upfpo.app.upagri.UPAGRI_AREAResponseUPAGRI_AREAResult UPAGRI_AREAResult) {
        this.UPAGRI_AREAResult = UPAGRI_AREAResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof UPAGRI_AREAResponse)) return false;
        UPAGRI_AREAResponse other = (UPAGRI_AREAResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.UPAGRI_AREAResult==null && other.getUPAGRI_AREAResult()==null) || 
             (this.UPAGRI_AREAResult!=null &&
              this.UPAGRI_AREAResult.equals(other.getUPAGRI_AREAResult())));
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
        if (getUPAGRI_AREAResult() != null) {
            _hashCode += getUPAGRI_AREAResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(UPAGRI_AREAResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">UPAGRI_AREAResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("UPAGRI_AREAResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "UPAGRI_AREAResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>UPAGRI_AREAResponse>UPAGRI_AREAResult"));
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
