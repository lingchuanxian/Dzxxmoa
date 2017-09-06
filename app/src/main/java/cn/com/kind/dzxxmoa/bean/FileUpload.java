package cn.com.kind.dzxxmoa.bean;

/**
 * Created by Administrator on 2017/9/5 0005.
 */

public class FileUpload {


    /**
     * Uuid : 470351ab-38de-489c-959f-f2d48e067be2
     * Enclname : UploadFiles/2017/09/05/Announce/20170905165249_ae16c9d2-f226-417f-a244-1ec41675d184.doc
     * Encltext : 移动OA系统接口.doc
     * Enclext : .doc
     * Enclsize : 1953280
     * Moduletype : null
     * Encltype : 1
     * Remark : null
     * CreateUserid :
     * CreateDeptid :
     */

    private String Uuid;
    private String Enclname;
    private String Encltext;
    private String Enclext;
    private int Enclsize;
    private Object Moduletype;
    private String Encltype;
    private Object Remark;
    private String CreateUserid;
    private String CreateDeptid;

    public String getUuid() {
        return Uuid;
    }

    public void setUuid(String Uuid) {
        this.Uuid = Uuid;
    }

    public String getEnclname() {
        return Enclname;
    }

    public void setEnclname(String Enclname) {
        this.Enclname = Enclname;
    }

    public String getEncltext() {
        return Encltext;
    }

    public void setEncltext(String Encltext) {
        this.Encltext = Encltext;
    }

    public String getEnclext() {
        return Enclext;
    }

    public void setEnclext(String Enclext) {
        this.Enclext = Enclext;
    }

    public int getEnclsize() {
        return Enclsize;
    }

    public void setEnclsize(int Enclsize) {
        this.Enclsize = Enclsize;
    }

    public Object getModuletype() {
        return Moduletype;
    }

    public void setModuletype(Object Moduletype) {
        this.Moduletype = Moduletype;
    }

    public String getEncltype() {
        return Encltype;
    }

    public void setEncltype(String Encltype) {
        this.Encltype = Encltype;
    }

    public Object getRemark() {
        return Remark;
    }

    public void setRemark(Object Remark) {
        this.Remark = Remark;
    }

    public String getCreateUserid() {
        return CreateUserid;
    }

    public void setCreateUserid(String CreateUserid) {
        this.CreateUserid = CreateUserid;
    }

    public String getCreateDeptid() {
        return CreateDeptid;
    }

    public void setCreateDeptid(String CreateDeptid) {
        this.CreateDeptid = CreateDeptid;
    }


    @Override
    public String toString() {
        return "FileUpload{" +
                "Uuid='" + Uuid + '\'' +
                ", Enclname='" + Enclname + '\'' +
                ", Encltext='" + Encltext + '\'' +
                ", Enclext='" + Enclext + '\'' +
                ", Enclsize=" + Enclsize +
                ", Moduletype=" + Moduletype +
                ", Encltype='" + Encltype + '\'' +
                ", Remark=" + Remark +
                ", CreateUserid='" + CreateUserid + '\'' +
                ", CreateDeptid='" + CreateDeptid + '\'' +
                '}';
    }
}
