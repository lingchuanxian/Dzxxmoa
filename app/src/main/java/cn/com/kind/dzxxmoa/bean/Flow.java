package cn.com.kind.dzxxmoa.bean;

import java.io.Serializable;

public class Flow implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String WfFlowId;
	private String WfFlowVersion;
	private String CurActivityId;
	private String FlowId;
	private String FlowName;
	private String FlowVersion;
	private String WfIfSelectActivityUser;
	public String getWfFlowId() {
		return WfFlowId;
	}
	public void setWfFlowId(String wfFlowId) {
		WfFlowId = wfFlowId;
	}
	public String getWfFlowVersion() {
		return WfFlowVersion;
	}
	public void setWfFlowVersion(String wfFlowVersion) {
		WfFlowVersion = wfFlowVersion;
	}
	public String getCurActivityId() {
		return CurActivityId;
	}
	public void setCurActivityId(String curActivityId) {
		CurActivityId = curActivityId;
	}
	public String getFlowId() {
		return FlowId;
	}
	public void setFlowId(String flowId) {
		FlowId = flowId;
	}
	public String getFlowName() {
		return FlowName;
	}
	public void setFlowName(String flowName) {
		FlowName = flowName;
	}
	public String getFlowVersion() {
		return FlowVersion;
	}
	public void setFlowVersion(String flowVersion) {
		FlowVersion = flowVersion;
	}
	public String getWfIfSelectActivityUser() {
		return WfIfSelectActivityUser;
	}
	public void setWfIfSelectActivityUser(String wfIfSelectActivityUser) {
		WfIfSelectActivityUser = wfIfSelectActivityUser;
	}
	public Flow(String wfFlowId, String wfFlowVersion, String curActivityId,
			String flowId, String flowName, String flowVersion,
			String wfIfSelectActivityUser) {
		super();
		WfFlowId = wfFlowId;
		WfFlowVersion = wfFlowVersion;
		CurActivityId = curActivityId;
		FlowId = flowId;
		FlowName = flowName;
		FlowVersion = flowVersion;
		WfIfSelectActivityUser = wfIfSelectActivityUser;
	}
	public Flow() {
		super();
	}
	@Override
	public String toString() {
		return "Flow [WfFlowId=" + WfFlowId + ", WfFlowVersion="
				+ WfFlowVersion + ", CurActivityId=" + CurActivityId
				+ ", FlowId=" + FlowId + ", FlowName=" + FlowName
				+ ", FlowVersion=" + FlowVersion + ", WfIfSelectActivityUser="
				+ WfIfSelectActivityUser + "]";
	}
}
