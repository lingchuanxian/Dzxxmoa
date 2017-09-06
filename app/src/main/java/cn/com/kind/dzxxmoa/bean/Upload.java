package cn.com.kind.dzxxmoa.bean;

public class Upload {
	private String Uuid;
	private String Enclname;
	private String Encltext;
	private String Enclext;
	private String Enclsize;
	private String Moduletype;
	private String Encltype;
	private String Remark;
	public String getUuid() {
		return Uuid;
	}
	public void setUuid(String uuid) {
		Uuid = uuid;
	}
	public String getEnclname() {
		return Enclname;
	}
	public void setEnclname(String enclname) {
		Enclname = enclname;
	}
	public String getEncltext() {
		return Encltext;
	}
	public void setEncltext(String encltext) {
		Encltext = encltext;
	}
	public String getEnclext() {
		return Enclext;
	}
	public void setEnclext(String enclext) {
		Enclext = enclext;
	}
	public String getEnclsize() {
		return Enclsize;
	}
	public void setEnclsize(String enclsize) {
		Enclsize = enclsize;
	}
	public String getModuletype() {
		return Moduletype;
	}
	public void setModuletype(String moduletype) {
		Moduletype = moduletype;
	}
	public String getEncltype() {
		return Encltype;
	}
	public void setEncltype(String encltype) {
		Encltype = encltype;
	}
	public String getRemark() {
		return Remark;
	}
	public void setRemark(String remark) {
		Remark = remark;
	}
	public Upload(String uuid, String enclname, String encltext,
			String enclext, String enclsize, String moduletype,
			String encltype, String remark) {
		super();
		Uuid = uuid;
		Enclname = enclname;
		Encltext = encltext;
		Enclext = enclext;
		Enclsize = enclsize;
		Moduletype = moduletype;
		Encltype = encltype;
		Remark = remark;
	}
	public Upload() {
		super();
	}
	@Override
	public String toString() {
		return "Upload [Uuid=" + Uuid + ", Enclname=" + Enclname
				+ ", Encltext=" + Encltext + ", Enclext=" + Enclext
				+ ", Enclsize=" + Enclsize + ", Moduletype=" + Moduletype
				+ ", Encltype=" + Encltype + ", Remark=" + Remark + "]";
	}
	
}
