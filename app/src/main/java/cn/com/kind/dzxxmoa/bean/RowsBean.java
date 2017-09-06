package cn.com.kind.dzxxmoa.bean;

import java.util.List;

/**
 * class description here
 *
 * @author ling_cx
 * @date 2017/8/11
 */

public class RowsBean<T> {
	private List<T> Rows;

	public List<T> getRows() {
		return Rows;
	}

	public void setRows(List<T> rows) {
		Rows = rows;
	}

	@Override
	public String toString() {
		return "RowsBean{" +
				"Rows=" + Rows +
				'}';
	}
}
