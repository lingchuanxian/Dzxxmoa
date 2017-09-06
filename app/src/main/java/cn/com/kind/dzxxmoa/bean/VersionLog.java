package cn.com.kind.dzxxmoa.bean;

/**
 * APP系统更新日志
 *
 * @author ling_cx
 * @date 2017/8/11
 */

public class VersionLog {
	private String create_id;
	private String create_date;
	private String version;
	private String content;
	private int rn;

	public String getCreate_id() {
		return create_id;
	}

	public void setCreate_id(String create_id) {
		this.create_id = create_id;
	}

	public String getCreate_date() {
		return create_date;
	}

	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getRn() {
		return rn;
	}

	public void setRn(int rn) {
		this.rn = rn;
	}

	@Override
	public String toString() {
		return "VersionLog{" +
				"create_id='" + create_id + '\'' +
				", create_date='" + create_date + '\'' +
				", version='" + version + '\'' +
				", content='" + content + '\'' +
				", rn=" + rn +
				'}';
	}
}
