package cn.com.kind.dzxxmoa.bean;

import java.util.List;

/**
 * Created by lcx on 2017/4/11.
 */

public class VersionBean {
    /**
     * version : V1.0
     * flag : 0
     * upload : [{"Uuid":"0e2592ca-d28c-4b3d-b797-cdcbe0f28941","Enclname":"UploadFiles/2016/08/24/AppManage/20160824161402_37273a6e-24cf-4033-aee7-9b24820f7a2b.apk","Encltext":"AJJ_MOA.apk","Enclext":".apk","Enclsize":3346636,"Moduletype":null,"Encltype":"1","Remark":null}]
     */

    private String version;
    private String flag;
    private String content;
    private List<Upload> upload;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public List<Upload> getUpload() {
        return upload;
    }

    public void setUpload(List<Upload> upload) {
        this.upload = upload;
    }

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "VersionBean{" +
				"version='" + version + '\'' +
				", flag='" + flag + '\'' +
				", content='" + content + '\'' +
				", upload=" + upload +
				'}';
	}
}
