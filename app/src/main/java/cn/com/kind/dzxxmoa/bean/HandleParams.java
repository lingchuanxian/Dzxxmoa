package cn.com.kind.dzxxmoa.bean;

import java.io.Serializable;

/**
 * class description here
 *
 * @author ling_cx
 * @date 2017/9/6
 */

public class HandleParams implements Serializable{
	private Flow flow;
	private Business business;
	public Flow getFlow() {
		return flow;
	}
	public void setFlow(Flow flow) {
		this.flow = flow;
	}
	public Business getBusiness() {
		return business;
	}
	public void setBusiness(Business business) {
		this.business = business;
	}
	public HandleParams(Flow flow, Business business) {
		super();
		this.flow = flow;
		this.business = business;
	}
	public HandleParams() {
		super();
	}
	@Override
	public String toString() {
		return "ParaInfo2 [flow=" + flow.toString() + ", business=" + business.toString() + "]";
	}
}
