package cn.com.kind.dzxxmoa.bean;

import java.util.List;

/**
 * class description here
 *
 * @author ling_cx
 * @date 2017/9/5
 */

public class CollectDocDetail {

	/**
	 * CreateId : 78a6885b-bc7b-406c-8a79-eeb2f023f4fb
	 * CollectTypeId : c55cbb19-f328-47dc-93c6-b43db10c9053
	 * CollectTypeName : 阅件
	 * CollectDocNo : 20170004
	 * CollectSecretTypeId : c948ed71-c580-4206-9461-8d2b6fcf3196
	 * CollectSecretTypeName : 非密
	 * CollectFastTypeId : df33c40c-a8a3-4e99-899c-01dc4733ef07
	 * CollectFastTypeName : 一般
	 * CollectDate : /Date(1502726400000)/
	 * SendDocNo : 22〔5〕5号
	 * Title : 转发国家安全监管总局办公厅关于印发《职业卫生技术服务机构检测工作规范》的通知
	 * Remark : 1
	 * CollectFileTypeId : 294a2659-f931-4cf5-a8b8-72a5d9df1675
	 * CollectFileTypeName : 一般文件
	 * SendUnit : 发改委
	 * DocUpload : [{"Uuid":"776b86d1-8733-46bd-be63-506aab9c2b3f","Enclname":"UploadFiles//2017/08/15/20170815151528_ff5059b6-06a6-4cf1-9bc7-588fde98bffc.doc","Encltext":"word_normal.doc","Enclext":".doc","Enclsize":22016,"Moduletype":null,"Encltype":"1","Remark":null,"CreateUserid":"","CreateDeptid":""}]
	 * ElseUpload : [{"Uuid":"a8214f61-c6d8-47d9-9028-33a1a46e2e0a","Enclname":"UploadFiles//2017/08/15/20170815151533_eff0e60e-67a9-415a-bed3-8c850b04a5aa.doc","Encltext":"word_normal_top003.doc","Enclext":".doc","Enclsize":23040,"Moduletype":null,"Encltype":"2","Remark":null,"CreateUserid":"","CreateDeptid":""},{"Uuid":"9a8a48f0-9e46-4e48-9c7b-2d8adca028bf","Enclname":"UploadFiles//2017/08/15/20170815151538_59674434-0cf8-4e84-b69c-a2980c23616c.doc","Encltext":"用户需求说明书-综合办公平台@20170707.doc","Enclext":".doc","Enclsize":3516416,"Moduletype":null,"Encltype":"2","Remark":null,"CreateUserid":"","CreateDeptid":""}]
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
	private List<FileUpload> DocUpload;
	private List<FileUpload> ElseUpload;

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

	public static class FucBean {
	}
}
