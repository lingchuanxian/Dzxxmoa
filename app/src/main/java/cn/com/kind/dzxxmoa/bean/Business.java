package cn.com.kind.dzxxmoa.bean;

import java.io.Serializable;
import java.util.List;

public class Business implements Serializable{

	private String CreateId;
	private String WfStartFlag;
	/**
	 * CollectTypeId : 77326bc2-2b56-4fe2-9cf7-04af8ca7c43b
	 * CollectTypeName : 办件
	 * CollectDocNo : 20170014
	 * CollectSecretTypeId : c948ed71-c580-4206-9461-8d2b6fcf3196
	 * CollectSecretTypeName : 非密
	 * CollectFastTypeId : df33c40c-a8a3-4e99-899c-01dc4733ef07
	 * CollectFastTypeName : 一般
	 * CollectDate : /Date(1504627200000)/
	 * SendDocNo : 456〔25〕25号
	 * Title : 测试收文201709061141
	 * Remark : 测试
	 * CollectFileTypeId : 294a2659-f931-4cf5-a8b8-72a5d9df1675
	 * CollectFileTypeName : 一般文件
	 * SendUnit : 发改委
	 * DocUpload : [{"Uuid":"2784cd6d-375a-43d4-b7f8-e5fe50e841fb","Enclname":"UploadFiles//2017/09/06/20170906114200_bc15be03-4163-41b9-93b2-3370223c094e.txt","Encltext":"新建文本文档.txt","Enclext":"","Enclsize":327,"Moduletype":null,"Encltype":"2","Remark":"","CreateUserid":"","CreateDeptid":""}]
	 * ElseUpload : []
	 * Fuc : {"wf_c_3_12":"true"}
	 * IsManage :
	 */

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
	private String Fuc;
	private String IsManage;
	private List<FileUpload> DocUpload;
	private List<FileUpload> ElseUpload;

	public String getCreateId() {
		return CreateId;
	}
	public void setCreateId(String createId) {
		CreateId = createId;
	}
	public String getWfStartFlag() {
		return WfStartFlag;
	}
	public void setWfStartFlag(String wfStartFlag) {
		WfStartFlag = wfStartFlag;
	}
	public Business(String createId, String wfStartFlag) {
		super();
		CreateId = createId;
		WfStartFlag = wfStartFlag;
	}
	public Business() {
		super();
	}
	@Override
	public String toString() {
		return "Business [CreateId=" + CreateId + ", WfStartFlag="
				+ WfStartFlag + "]";
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

	public String getFuc() {
		return Fuc;
	}

	public void setFuc(String Fuc) {
		this.Fuc = Fuc;
	}

	public String getIsManage() {
		return IsManage;
	}

	public void setIsManage(String IsManage) {
		this.IsManage = IsManage;
	}

	public List<FileUpload> getDocUpload() {
		return DocUpload;
	}

	public void setDocUpload(List<FileUpload> DocUpload) {
		this.DocUpload = DocUpload;
	}

	public List<FileUpload> getElseUpload() {
		return ElseUpload;
	}

	public void setElseUpload(List<FileUpload> ElseUpload) {
		this.ElseUpload = ElseUpload;
	}

}
