package cn.com.kind.dzxxmoa.bean;

/**
 * 主页菜单的bean
 * @author ling_cx
 * @date 2017/8/7.
 */
public class MenuBean {
	private String name;
	private int imgId;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getImgId() {
		return imgId;
	}

	public void setImgId(int imgId) {
		this.imgId = imgId;
	}

	public MenuBean() {
	}

	public MenuBean(String name, int imgId) {
		this.name = name;
		this.imgId = imgId;
	}
}
