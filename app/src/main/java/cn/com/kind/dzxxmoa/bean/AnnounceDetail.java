package cn.com.kind.dzxxmoa.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/9/6 0006.
 */

public class AnnounceDetail {


    /**
     * CreateId : c2e8864c-587f-444b-8dd5-1cda961b0d6f
     * Title : 高级测试
     * AppName : 管理员
     * AppDept : 技术处
     * ApplyDate : /Date(1504627200000)/
     * ScopeId : 1
     * IsTop : 0
     * Comment : 十大歌手发的说三道四水电费是非得失 胜多负少发生的水电费设定设定防守打法
     * Upload : [{"Uuid":"741c39b0-868e-48e9-b411-c62b9d9fd73b","Enclname":"UploadFiles/2017/09/06/Announce/20170906085639_aafe07ff-30c3-4b73-91d9-e0aed66d950d.xls","Encltext":"福建省电子信息集团综合办公平台开发任务分配表.xls","Enclext":".xls","Enclsize":14336,"Moduletype":null,"Encltype":"1","Remark":null,"CreateUserid":"","CreateDeptid":""},{"Uuid":"982fd307-65ac-42e2-a51e-0f28a76c14b8","Enclname":"UploadFiles/2017/09/06/Announce/20170906085647_1e2ade22-7976-4036-ac2b-24819984ad86.doc","Encltext":"Android开发命名规范(1).doc","Enclext":".doc","Enclsize":94720,"Moduletype":null,"Encltype":"1","Remark":null,"CreateUserid":"","CreateDeptid":""}]
     * Fuc : {}
     * Receivers : []
     * Readers : [{"CreateId":"d4987d2f-2b82-4152-8dcf-da2e670e92cb","ReceId":"00000000-0000-0000-0000-000000000001","ReceName":"管理员","ReceDeptid":"000000000000000000000000000000000004","ReceDeptname":"技术处","ReceOrgid":"00000000-0000-0000-1000-000000000000","ReceOrgname":"福建省电子信息集团","ReceInfoid":"c2e8864c-587f-444b-8dd5-1cda961b0d6f","Info_Deal":null,"ReceDate":"/Date(1483200000000)/"}]
     */

    private String CreateId;
    private String Title;
    private String AppName;
    private String AppDept;
    private String ApplyDate;
    private int ScopeId;
    private int IsTop;
    private String Comment;
    private FucBean Fuc;
    private List<FileUpload> Upload;
    private List<Receivers> Receivers;
    private List<Readers> Readers;

    public String getCreateId() {
        return CreateId;
    }

    public void setCreateId(String CreateId) {
        this.CreateId = CreateId;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public String getAppName() {
        return AppName;
    }

    public void setAppName(String AppName) {
        this.AppName = AppName;
    }

    public String getAppDept() {
        return AppDept;
    }

    public void setAppDept(String AppDept) {
        this.AppDept = AppDept;
    }

    public String getApplyDate() {
        return ApplyDate;
    }

    public void setApplyDate(String ApplyDate) {
        this.ApplyDate = ApplyDate;
    }

    public int getScopeId() {
        return ScopeId;
    }

    public void setScopeId(int ScopeId) {
        this.ScopeId = ScopeId;
    }

    public int getIsTop() {
        return IsTop;
    }

    public void setIsTop(int IsTop) {
        this.IsTop = IsTop;
    }

    public String getComment() {
        return Comment;
    }

    public void setComment(String Comment) {
        this.Comment = Comment;
    }

    public FucBean getFuc() {
        return Fuc;
    }

    public void setFuc(FucBean Fuc) {
        this.Fuc = Fuc;
    }

    public List<FileUpload> getUpload() {
        return Upload;
    }

    public void setUpload(List<FileUpload> Upload) {
        this.Upload = Upload;
    }

    public List<Receivers> getReceivers() {
        return Receivers;
    }

    public void setReceivers(List<Receivers> Receivers) {
        this.Receivers = Receivers;
    }

    public List<Readers> getReaders() {
        return Readers;
    }

    public void setReaders(List<Readers> Readers) {
        this.Readers = Readers;
    }

    public static class FucBean {
    }

}
