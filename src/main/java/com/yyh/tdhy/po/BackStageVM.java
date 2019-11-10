package com.yyh.tdhy.po;

import java.util.List;

public class BackStageVM extends BackMenu {
	private List<BackMenu> backMenuChildren;

	public List<BackMenu> getBackMenuChildren() {
		return backMenuChildren;
	}

	public void setBackMenuChildren(List<BackMenu> backMenuChildren) {
		this.backMenuChildren = backMenuChildren;
	}

}
