package cn.com.kind.dzxxmoa.bean;

/**
 * Created by Administrator on 2017/9/6 0006.
 */

public class InfoShow {


    /**
     * create_id : e2c0a0c6-a754-43cc-bf80-d854f96ee85e
     * title : test1
     * issue_date : /Date(1504627200000)/
     * create_user_name : 管理员
     * info_catagory_name : 公开1
     */

    private String create_id;
    private String title;
    private String issue_date;
    private String create_user_name;
    private String info_catagory_name;

    public String getCreate_id() {
        return create_id;
    }

    public void setCreate_id(String create_id) {
        this.create_id = create_id;
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

    public String getCreate_user_name() {
        return create_user_name;
    }

    public void setCreate_user_name(String create_user_name) {
        this.create_user_name = create_user_name;
    }

    public String getInfo_catagory_name() {
        return info_catagory_name;
    }

    public void setInfo_catagory_name(String info_catagory_name) {
        this.info_catagory_name = info_catagory_name;
    }

    @Override
    public String toString() {
        return "InfoShow{" +
                "create_id='" + create_id + '\'' +
                ", title='" + title + '\'' +
                ", issue_date='" + issue_date + '\'' +
                ", create_user_name='" + create_user_name + '\'' +
                ", info_catagory_name='" + info_catagory_name + '\'' +
                '}';
    }
}
