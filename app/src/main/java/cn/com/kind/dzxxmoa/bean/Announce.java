package cn.com.kind.dzxxmoa.bean;

/**
 * Created by Administrator on 2017/9/4 0004.
 */

public class Announce {


    /**
     * create_date : /Date(1504490117000)/
     * create_id : 5371955d-6262-4f7e-89e5-b7741ad93a20
     * create_user_id : 00000000-0000-0000-0000-000000000001
     * create_user_name : 管理员
     * create_user_orgid : 00000000-0000-0000-1000-000000000000
     * create_user_orgname : 福建省电子信息集团
     * create_user_deptid : 000000000000000000000000000000000004
     * create_user_deptname : 技术处
     * title : Test201709040955
     * issue_date : /Date(1504454400000)/
     * is_top : 0
     * scope_id : 1
     * read_id :
     */

    private String create_date;
    private String create_id;
    private String create_user_id;
    private String create_user_name;
    private String create_user_orgid;
    private String create_user_orgname;
    private String create_user_deptid;
    private String create_user_deptname;
    private String title;
    private String issue_date;
    private int is_top;
    private int scope_id;
    private String read_id;

    public String getCreate_date() {
        return create_date;
    }

    public void setCreate_date(String create_date) {
        this.create_date = create_date;
    }

    public String getCreate_id() {
        return create_id;
    }

    public void setCreate_id(String create_id) {
        this.create_id = create_id;
    }

    public String getCreate_user_id() {
        return create_user_id;
    }

    public void setCreate_user_id(String create_user_id) {
        this.create_user_id = create_user_id;
    }

    public String getCreate_user_name() {
        return create_user_name;
    }

    public void setCreate_user_name(String create_user_name) {
        this.create_user_name = create_user_name;
    }

    public String getCreate_user_orgid() {
        return create_user_orgid;
    }

    public void setCreate_user_orgid(String create_user_orgid) {
        this.create_user_orgid = create_user_orgid;
    }

    public String getCreate_user_orgname() {
        return create_user_orgname;
    }

    public void setCreate_user_orgname(String create_user_orgname) {
        this.create_user_orgname = create_user_orgname;
    }

    public String getCreate_user_deptid() {
        return create_user_deptid;
    }

    public void setCreate_user_deptid(String create_user_deptid) {
        this.create_user_deptid = create_user_deptid;
    }

    public String getCreate_user_deptname() {
        return create_user_deptname;
    }

    public void setCreate_user_deptname(String create_user_deptname) {
        this.create_user_deptname = create_user_deptname;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIssue_date() {
        return issue_date;
    }

    public void setIssue_date(String issue_date) {
        this.issue_date = issue_date;
    }

    public int getIs_top() {
        return is_top;
    }

    public void setIs_top(int is_top) {
        this.is_top = is_top;
    }

    public int getScope_id() {
        return scope_id;
    }

    public void setScope_id(int scope_id) {
        this.scope_id = scope_id;
    }

    public String getRead_id() {
        return read_id;
    }

    public void setRead_id(String read_id) {
        this.read_id = read_id;
    }

    @Override
    public String toString() {
        return "Announce{" +
                "create_date='" + create_date + '\'' +
                ", create_id='" + create_id + '\'' +
                ", create_user_id='" + create_user_id + '\'' +
                ", create_user_name='" + create_user_name + '\'' +
                ", create_user_orgid='" + create_user_orgid + '\'' +
                ", create_user_orgname='" + create_user_orgname + '\'' +
                ", create_user_deptid='" + create_user_deptid + '\'' +
                ", create_user_deptname='" + create_user_deptname + '\'' +
                ", title='" + title + '\'' +
                ", issue_date='" + issue_date + '\'' +
                ", is_top=" + is_top +
                ", scope_id=" + scope_id +
                ", read_id='" + read_id + '\'' +
                '}';
    }
}
