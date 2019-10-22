package com.example.tdhy.po;

import java.util.List;

public class NavigationVm extends Navigation {
	private List<Navigation> navigationChildren;

	public List<Navigation> getNavigationChildren() {
		return navigationChildren;
	}

	public void setNavigationChildren(List<Navigation> navigationChildren) {
		this.navigationChildren = navigationChildren;
	}

}