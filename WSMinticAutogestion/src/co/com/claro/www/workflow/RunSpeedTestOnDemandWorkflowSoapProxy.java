package co.com.claro.www.workflow;

public class RunSpeedTestOnDemandWorkflowSoapProxy implements co.com.claro.www.workflow.RunSpeedTestOnDemandWorkflowSoap {
  private String _endpoint = null;
  private co.com.claro.www.workflow.RunSpeedTestOnDemandWorkflowSoap runSpeedTestOnDemandWorkflowSoap = null;
  
  public RunSpeedTestOnDemandWorkflowSoapProxy() {
    _initRunSpeedTestOnDemandWorkflowSoapProxy();
  }
  
  public RunSpeedTestOnDemandWorkflowSoapProxy(String endpoint) {
    _endpoint = endpoint;
    _initRunSpeedTestOnDemandWorkflowSoapProxy();
  }
  
  private void _initRunSpeedTestOnDemandWorkflowSoapProxy() {
    try {
      runSpeedTestOnDemandWorkflowSoap = (new co.com.claro.www.workflow.RunSpeedTestOnDemandWorkflowLocator()).getRunSpeedTestOnDemandWorkflowSoap();
      if (runSpeedTestOnDemandWorkflowSoap != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)runSpeedTestOnDemandWorkflowSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)runSpeedTestOnDemandWorkflowSoap)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (runSpeedTestOnDemandWorkflowSoap != null)
      ((javax.xml.rpc.Stub)runSpeedTestOnDemandWorkflowSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public co.com.claro.www.workflow.RunSpeedTestOnDemandWorkflowSoap getRunSpeedTestOnDemandWorkflowSoap() {
    if (runSpeedTestOnDemandWorkflowSoap == null)
      _initRunSpeedTestOnDemandWorkflowSoapProxy();
    return runSpeedTestOnDemandWorkflowSoap;
  }
  
  public java.lang.String execute(int[] APListIDs, java.lang.String userEmail) throws java.rmi.RemoteException{
    if (runSpeedTestOnDemandWorkflowSoap == null)
      _initRunSpeedTestOnDemandWorkflowSoapProxy();
    return runSpeedTestOnDemandWorkflowSoap.execute(APListIDs, userEmail);
  }
  
  public co.com.claro.www.workflow.TrackingIDAndProcessID executeAndReturnPID(int[] APListIDs, java.lang.String userEmail) throws java.rmi.RemoteException{
    if (runSpeedTestOnDemandWorkflowSoap == null)
      _initRunSpeedTestOnDemandWorkflowSoapProxy();
    return runSpeedTestOnDemandWorkflowSoap.executeAndReturnPID(APListIDs, userEmail);
  }
  
  public boolean checkTimeoutsAndEscalations() throws java.rmi.RemoteException{
    if (runSpeedTestOnDemandWorkflowSoap == null)
      _initRunSpeedTestOnDemandWorkflowSoapProxy();
    return runSpeedTestOnDemandWorkflowSoap.checkTimeoutsAndEscalations();
  }
  
  public co.com.claro.www.workflow.WorkStatus trackStatus(java.lang.String workflowTrackingId) throws java.rmi.RemoteException{
    if (runSpeedTestOnDemandWorkflowSoap == null)
      _initRunSpeedTestOnDemandWorkflowSoapProxy();
    return runSpeedTestOnDemandWorkflowSoap.trackStatus(workflowTrackingId);
  }
  
  public co.com.claro.www.workflow.WorkflowTaskResult[] getCurrentWorkflowTasks(java.lang.String workflowTrackingId) throws java.rmi.RemoteException{
    if (runSpeedTestOnDemandWorkflowSoap == null)
      _initRunSpeedTestOnDemandWorkflowSoapProxy();
    return runSpeedTestOnDemandWorkflowSoap.getCurrentWorkflowTasks(workflowTrackingId);
  }
  
  public java.lang.String[] getCurrentWorkflowTaskIDs(java.lang.String workflowTrackingId) throws java.rmi.RemoteException{
    if (runSpeedTestOnDemandWorkflowSoap == null)
      _initRunSpeedTestOnDemandWorkflowSoapProxy();
    return runSpeedTestOnDemandWorkflowSoap.getCurrentWorkflowTaskIDs(workflowTrackingId);
  }
  
  public boolean checkAutoStart() throws java.rmi.RemoteException{
    if (runSpeedTestOnDemandWorkflowSoap == null)
      _initRunSpeedTestOnDemandWorkflowSoapProxy();
    return runSpeedTestOnDemandWorkflowSoap.checkAutoStart();
  }
  
  
}