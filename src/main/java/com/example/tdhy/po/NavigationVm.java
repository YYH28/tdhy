package com.example.tdhy.po;

import java.util.List;

/*多个数据集中在一个中，只要传输一个，不在需要传输多个*/
public class NavigationVm extends Navigation {
	private List<Navigation> navigationChildren;

	public List<Navigation> getNavigationChildren() {
		return navigationChildren;
	}

	public void setNavigationChildren(List<Navigation> navigationChildren) {
		this.navigationChildren = navigationChildren;
	}

}
