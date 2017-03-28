package com.nullptr.common.pojo;

import java.util.List;

/**
 * 用于封装EasyUi中DataGrid控件的返回值
 * 
 * @author Nullptr
 *
 */
public class EasyUiDataGridResult {
	//
	private long total;
	//
	private List<?> rows;

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public List<?> getRows() {
		return rows;
	}

	public void setRows(List<?> rows) {
		this.rows = rows;
	}

}
