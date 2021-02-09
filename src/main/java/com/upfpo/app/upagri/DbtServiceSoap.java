/**
 * DbtServiceSoap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.upfpo.app.upagri;

public interface DbtServiceSoap extends java.rmi.Remote {
    public com.upfpo.app.upagri.DBTDATAResponseDBTDATAResult DBTDATA(java.lang.String SCHEME_CODE) throws java.rmi.RemoteException;
    public com.upfpo.app.upagri.UPAGRIResponseUPAGRIResult UPAGRI(java.lang.String REG_NO) throws java.rmi.RemoteException;
    public com.upfpo.app.upagri.UPAGRI_AREAResponseUPAGRI_AREAResult UPAGRI_AREA(java.lang.String REG_NO) throws java.rmi.RemoteException;
}
