package cn.com.kind.dzxxmoa.bean;

import java.util.List;

/**
 * class description here
 *
 * @author ling_cx
 * @date 2017/8/11
 */

public class UtilBean {

	/**
	 * CreateId : a9f2edd2-5d2c-4f3d-918f-d2fa7fc18797
	 * CollectTypeId : c55cbb19-f328-47dc-93c6-b43db10c9053
	 * CollectTypeName : 阅件
	 * CollectDocNo : 20170003
	 * CollectSecretTypeId : c948ed71-c580-4206-9461-8d2b6fcf3196
	 * CollectSecretTypeName : 非密
	 * CollectFastTypeId : ade94f40-c8db-463c-b4f2-e0f2169551ea
	 * CollectFastTypeName : 急
	 * CollectDate : /Date(1502726400000)/
	 * SendDocNo : 3〔3〕3号
	 * Title : 关于印发《福建省安全生产监管系统推进安全生产监督检查随机抽查工作实施方案》的通知
	 * Remark : 2
	 * CollectFileTypeId : 294a2659-f931-4cf5-a8b8-72a5d9df1675
	 * CollectFileTypeName : 一般文件
	 * SendUnit : 222
	 * DocUpload : []
	 * ElseUpload : []
	 * Fuc : {}
	 * IsManage : 1
	 */

	private String CreateId;
	private String CollectTypeId;
	private String CollectTypeName;
	private String CollectDocNo;
	private String CollectSecretTypeId;
	private String CollectSecretTypeName;
	private String CollectFastTypeId;
	private String CollectFastTypeName;
	private String CollectDate;
	private String SendDocNo;
	private String Title;
	private String Remark;
	private String CollectFileTypeId;
	private String CollectFileTypeName;
	private String SendUnit;
	private FucBean Fuc;
	private String IsManage;
	private List<?> DocUpload;
	private List<?> ElseUpload;

	public String getCreateId() {
		return CreateId;
	}

	public void setCreateId(String CreateId) {
		this.CreateId = CreateId;
	}

	public String getCollectTypeId() {
		return CollectTypeId;
	}

	public void setCollectTypeId(String CollectTypeId) {
		this.CollectTypeId = CollectTypeId;
	}

	public String getCollectTypeName() {
		return CollectTypeName;
	}

	public void setCollectTypeName(String CollectTypeName) {
		this.CollectTypeName = CollectTypeName;
	}

	public String getCollectDocNo() {
		return CollectDocNo;
	}

	public void setCollectDocNo(String CollectDocNo) {
		this.CollectDocNo = CollectDocNo;
	}

	public String getCollectSecretTypeId() {
		return CollectSecretTypeId;
	}

	public void setCollectSecretTypeId(String CollectSecretTypeId) {
		this.CollectSecretTypeId = CollectSecretTypeId;
	}

	public String getCollectSecretTypeName() {
		return CollectSecretTypeName;
	}

	public void setCollectSecretTypeName(String CollectSecretTypeName) {
		this.CollectSecretTypeName = CollectSecretTypeName;
	}

	public String getCollectFastTypeId() {
		return CollectFastTypeId;
	}

	public void setCollectFastTypeId(String CollectFastTypeId) {
		this.CollectFastTypeId = CollectFastTypeId;
	}

	public String getCollectFastTypeName() {
		return CollectFastTypeName;
	}

	public void setCollectFastTypeName(String CollectFastTypeName) {
		this.CollectFastTypeName = CollectFastTypeName;
	}

	public String getCollectDate() {
		return CollectDate;
	}

	public void setCollectDate(String CollectDate) {
		this.CollectDate = CollectDate;
	}

	public String getSendDocNo() {
		return SendDocNo;
	}

	public void setSendDocNo(String SendDocNo) {
		this.SendDocNo = SendDocNo;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String Title) {
		this.Title = Title;
	}

	public String getRemark() {
		return Remark;
	}

	public void setRemark(String Remark) {
		this.Remark = Remark;
	}

	public String getCollectFileTypeId() {
		return CollectFileTypeId;
	}

	public void setCollectFileTypeId(String CollectFileTypeId) {
		this.CollectFileTypeId = CollectFileTypeId;
	}

	public String getCollectFileTypeName() {
		return CollectFileTypeName;
	}

	public void setCollectFileTypeName(String CollectFileTypeName) {
		this.CollectFileTypeName = CollectFileTypeName;
	}

	public String getSendUnit() {
		return SendUnit;
	}

	public void setSendUnit(String SendUnit) {
		this.SendUnit = SendUnit;
	}

	public FucBean getFuc() {
		return Fuc;
	}

	public void setFuc(FucBean Fuc) {
		this.Fuc = Fuc;
	}

	public String getIsManage() {
		return IsManage;
	}

	public void setIsManage(String IsManage) {
		this.IsManage = IsManage;
	}

	public List<?> getDocUpload() {
		return DocUpload;
	}

	public void setDocUpload(List<?> DocUpload) {
		this.DocUpload = DocUpload;
	}

	public List<?> getElseUpload() {
		return ElseUpload;
	}

	public void setElseUpload(List<?> ElseUpload) {
		this.ElseUpload = ElseUpload;
	}

	public static class FucBean {
	}
}
