package co.com.claro.www.speedtest;

public class ManageAPSearchingSoapProxy implements co.com.claro.www.speedtest.ManageAPSearchingSoap {
  private String _endpoint = null;
  private co.com.claro.www.speedtest.ManageAPSearchingSoap manageAPSearchingSoap = null;
  
  public ManageAPSearchingSoapProxy() {
    _initManageAPSearchingSoapProxy();
  }
  
  public ManageAPSearchingSoapProxy(String endpoint) {
    _endpoint = endpoint;
    _initManageAPSearchingSoapProxy();
  }
  
  private void _initManageAPSearchingSoapProxy() {
    try {
      manageAPSearchingSoap = (new co.com.claro.www.speedtest.ManageAPSearchingLocator()).getManageAPSearchingSoap();
      if (manageAPSearchingSoap != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)manageAPSearchingSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)manageAPSearchingSoap)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (manageAPSearchingSoap != null)
      ((javax.xml.rpc.Stub)manageAPSearchingSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public co.com.claro.www.speedtest.ManageAPSearchingSoap getManageAPSearchingSoap() {
    if (manageAPSearchingSoap == null)
      _initManageAPSearchingSoapProxy();
    return manageAPSearchingSoap;
  }
  
  public void noAction() throws java.rmi.RemoteException{
    if (manageAPSearchingSoap == null)
      _initManageAPSearchingSoapProxy();
    manageAPSearchingSoap.noAction();
  }
  
  public co.com.claro.www.speedtest.SearchAPByTextResult searchAPByText(java.lang.String textToSearch, int maxRows) throws java.rmi.RemoteException{
    if (manageAPSearchingSoap == null)
      _initManageAPSearchingSoapProxy();
    return manageAPSearchingSoap.searchAPByText(textToSearch, maxRows);
  }
  
  public co.com.claro.www.speedtest.SearchAPByBWResult searchAPByBW(java.lang.String downloadBWOperator, java.math.BigDecimal downloadBWValue, java.lang.String uploadBWOperator, java.math.BigDecimal uploadBWValue, java.lang.String generalOperator, int maxRows) throws java.rmi.RemoteException{
    if (manageAPSearchingSoap == null)
      _initManageAPSearchingSoapProxy();
    return manageAPSearchingSoap.searchAPByBW(downloadBWOperator, downloadBWValue, uploadBWOperator, uploadBWValue, generalOperator, maxRows);
  }
  
  public co.com.claro.www.speedtest.AddAPResult addAP(co.com.claro.www.speedtest.SearchAPResultObject[] AP, boolean allowUpdate) throws java.rmi.RemoteException{
    if (manageAPSearchingSoap == null)
      _initManageAPSearchingSoapProxy();
    return manageAPSearchingSoap.addAP(AP, allowUpdate);
  }
  
  public co.com.claro.www.speedtest.SearchLocationByTextResult searchLocationByText(java.lang.String textToSearch, int maxRows) throws java.rmi.RemoteException{
    if (manageAPSearchingSoap == null)
      _initManageAPSearchingSoapProxy();
    return manageAPSearchingSoap.searchLocationByText(textToSearch, maxRows);
  }
  
  public co.com.claro.www.speedtest.GetLocationByBeneficiaryCodeResult getLocationByBeneficiaryCode(java.lang.String beneficiaryCode) throws java.rmi.RemoteException{
    if (manageAPSearchingSoap == null)
      _initManageAPSearchingSoapProxy();
    return manageAPSearchingSoap.getLocationByBeneficiaryCode(beneficiaryCode);
  }
  
  public co.com.claro.www.speedtest.DisableAPsByBeneficiaryCodeResult disableAPsByBeneficiaryCode(java.lang.String beneficiaryCode, int apIDtoExclude) throws java.rmi.RemoteException{
    if (manageAPSearchingSoap == null)
      _initManageAPSearchingSoapProxy();
    return manageAPSearchingSoap.disableAPsByBeneficiaryCode(beneficiaryCode, apIDtoExclude);
  }
  
  public co.com.claro.www.speedtest.SearchAllAPsByTextResult searchAllAPsByText(java.lang.String textToSearch, int maxRows) throws java.rmi.RemoteException{
    if (manageAPSearchingSoap == null)
      _initManageAPSearchingSoapProxy();
    return manageAPSearchingSoap.searchAllAPsByText(textToSearch, maxRows);
  }
  
  public co.com.claro.www.speedtest.GetGroupsResult getGroups() throws java.rmi.RemoteException{
    if (manageAPSearchingSoap == null)
      _initManageAPSearchingSoapProxy();
    return manageAPSearchingSoap.getGroups();
  }
  
  
}