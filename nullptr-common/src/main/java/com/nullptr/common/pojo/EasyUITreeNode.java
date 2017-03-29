package com.nullptr.common.pojo;

/**
 * 用于保存EasyUi里面的树结构的节点
 * 
 * @author Nullptr
 *
 */
public class EasyUITreeNode {
	
	//节点ID
	private long id;
	//节点显示文本
	private String text;
	//节点状态：'open' 或 'closed'，默认：'open'。如果为'closed'的时候，将不自动展开该节点(EasyUi)。
	private String state;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
