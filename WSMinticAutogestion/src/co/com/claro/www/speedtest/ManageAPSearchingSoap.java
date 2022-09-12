/**
 * ManageAPSearchingSoap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package co.com.claro.www.speedtest;

public interface ManageAPSearchingSoap extends java.rmi.Remote {
    public void noAction() throws java.rmi.RemoteException;
    public co.com.claro.www.speedtest.SearchAPByTextResult searchAPByText(java.lang.String textToSearch, int maxRows) throws java.rmi.RemoteException;
    public co.com.claro.www.speedtest.SearchAPByBWResult searchAPByBW(java.lang.String downloadBWOperator, java.math.BigDecimal downloadBWValue, java.lang.String uploadBWOperator, java.math.BigDecimal uploadBWValue, java.lang.String generalOperator, int maxRows) throws java.rmi.RemoteException;
    public co.com.claro.www.speedtest.AddAPResult addAP(co.com.claro.www.speedtest.SearchAPResultObject[] AP, boolean allowUpdate) throws java.rmi.RemoteException;
    public co.com.claro.www.speedtest.SearchLocationByTextResult searchLocationByText(java.lang.String textToSearch, int maxRows) throws java.rmi.RemoteException;
    public co.com.claro.www.speedtest.GetLocationByBeneficiaryCodeResult getLocationByBeneficiaryCode(java.lang.String beneficiaryCode) throws java.rmi.RemoteException;
    public co.com.claro.www.speedtest.DisableAPsByBeneficiaryCodeResult disableAPsByBeneficiaryCode(java.lang.String beneficiaryCode, int apIDtoExclude) throws java.rmi.RemoteException;
    public co.com.claro.www.speedtest.SearchAllAPsByTextResult searchAllAPsByText(java.lang.String textToSearch, int maxRows) throws java.rmi.RemoteException;
    public co.com.claro.www.speedtest.GetGroupsResult getGroups() throws java.rmi.RemoteException;
}
