package cn.com.kind.dzxxmoa.bean;

import java.io.Serializable;

/**
 * 分页信息
 *
 * @author ling_cx
 * @date 2017/8/11
 */

public class PageBean<T> implements Serializable{
	private int PageIndex;
	private int PageSize;
	private int Total;
	private int PageCount;
	private T Datas;

	public int getPageIndex() {
		return PageIndex;
	}

	public void setPageIndex(int pageIndex) {
		PageIndex = pageIndex;
	}

	public int getPageSize() {
		return PageSize;
	}

	public void setPageSize(int pageSize) {
		PageSize = pageSize;
	}

	public int getTotal() {
		return Total;
	}

	public void setTotal(int total) {
		Total = total;
	}

	public int getPageCount() {
		return PageCount;
	}

	public void setPageCount(int pageCount) {
		PageCount = pageCount;
	}

	public T getDatas() {
		return Datas;
	}

	public void setDatas(T datas) {
		Datas = datas;
	}

	@Override
	public String toString() {
		return "PageBean{" +
				"PageIndex=" + PageIndex +
				", PageSize=" + PageSize +
				", Total=" + Total +
				", PageCount=" + PageCount +
				", Datas=" + Datas +
				'}';
	}
}
