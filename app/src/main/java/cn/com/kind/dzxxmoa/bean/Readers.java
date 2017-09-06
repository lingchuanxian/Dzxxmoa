package cn.com.kind.dzxxmoa.bean;

/**
 * Created by Administrator on 2017/9/5 0005.
 */

public class Readers {


    /**
     * CreateId : dabc5cc5-1d5c-4ff9-9f2b-bb44a804b750
     * ReceId : 00000000-0000-0000-0000-000000000001
     * ReceName : 管理员
     * ReceDeptid : 000000000000000000000000000000000004
     * ReceDeptname : 技术处
     * ReceOrgid : 00000000-0000-0000-1000-000000000000
     * ReceOrgname : 福建省电子信息集团
     * ReceInfoid : c143f64f-2505-4460-89a8-b2fc8690867b
     * Info_Deal : null
     * ReceDate : /Date(1483200000000)/
     */

    private String CreateId;
    private String ReceId;
    private String ReceName;
    private String ReceDeptid;
    private String ReceDeptname;
    private String ReceOrgid;
    private String ReceOrgname;
    private String ReceInfoid;
    private Object Info_Deal;
    private String ReceDate;

    public String getCreateId() {
        return CreateId;
    }

    public void setCreateId(String CreateId) {
        this.CreateId = CreateId;
    }

    public String getReceId() {
        return ReceId;
    }

    public void setReceId(String ReceId) {
        this.ReceId = ReceId;
    }

    public String getReceName() {
        return ReceName;
    }

    public void setReceName(String ReceName) {
        this.ReceName = ReceName;
    }

    public String getReceDeptid() {
        return ReceDeptid;
    }

    public void setReceDeptid(String ReceDeptid) {
        this.ReceDeptid = ReceDeptid;
    }

    public String getReceDeptname() {
        return ReceDeptname;
    }

    public void setReceDeptname(String ReceDeptname) {
        this.ReceDeptname = ReceDeptname;
    }

    public String getReceOrgid() {
        return ReceOrgid;
    }

    public void setReceOrgid(String ReceOrgid) {
        this.ReceOrgid = ReceOrgid;
    }

    public String getReceOrgname() {
        return ReceOrgname;
    }

    public void setReceOrgname(String ReceOrgname) {
        this.ReceOrgname = ReceOrgname;
    }

    public String getReceInfoid() {
        return ReceInfoid;
    }

    public void setReceInfoid(String ReceInfoid) {
        this.ReceInfoid = ReceInfoid;
    }

    public Object getInfo_Deal() {
        return Info_Deal;
    }

    public void setInfo_Deal(Object Info_Deal) {
        this.Info_Deal = Info_Deal;
    }

    public String getReceDate() {
        return ReceDate;
    }

    public void setReceDate(String ReceDate) {
        this.ReceDate = ReceDate;
    }

    @Override
    public String toString() {
        return "Readers{" +
                "CreateId='" + CreateId + '\'' +
                ", ReceId='" + ReceId + '\'' +
                ", ReceName='" + ReceName + '\'' +
                ", ReceDeptid='" + ReceDeptid + '\'' +
                ", ReceDeptname='" + ReceDeptname + '\'' +
                ", ReceOrgid='" + ReceOrgid + '\'' +
                ", ReceOrgname='" + ReceOrgname + '\'' +
                ", ReceInfoid='" + ReceInfoid + '\'' +
                ", Info_Deal=" + Info_Deal +
                ", ReceDate='" + ReceDate + '\'' +
                '}';
    }
}
