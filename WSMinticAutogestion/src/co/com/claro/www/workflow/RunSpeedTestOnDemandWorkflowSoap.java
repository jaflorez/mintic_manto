/**
 * RunSpeedTestOnDemandWorkflowSoap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package co.com.claro.www.workflow;

public interface RunSpeedTestOnDemandWorkflowSoap extends java.rmi.Remote {
    public java.lang.String execute(int[] APListIDs, java.lang.String userEmail) throws java.rmi.RemoteException;
    public co.com.claro.www.workflow.TrackingIDAndProcessID executeAndReturnPID(int[] APListIDs, java.lang.String userEmail) throws java.rmi.RemoteException;
    public boolean checkTimeoutsAndEscalations() throws java.rmi.RemoteException;
    public co.com.claro.www.workflow.WorkStatus trackStatus(java.lang.String workflowTrackingId) throws java.rmi.RemoteException;
    public co.com.claro.www.workflow.WorkflowTaskResult[] getCurrentWorkflowTasks(java.lang.String workflowTrackingId) throws java.rmi.RemoteException;
    public java.lang.String[] getCurrentWorkflowTaskIDs(java.lang.String workflowTrackingId) throws java.rmi.RemoteException;
    public boolean checkAutoStart() throws java.rmi.RemoteException;
}
