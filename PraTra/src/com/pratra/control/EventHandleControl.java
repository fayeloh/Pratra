package com.pratra.control;

import java.util.List;

import com.pratra.biz.EventHandleBiz;
import com.pratra.entity.WriUser;

/**
 * @ 事务控制层
 * 
 * @mvc模式中的control类
 */
public class EventHandleControl {

	private EventHandleBiz eventHandleBiz;

	public EventHandleControl() {
		eventHandleBiz = new EventHandleBiz();
	}

	public WriUser insert(WriUser wriUser) {
		return eventHandleBiz.insert(wriUser);
	}

	// public List<WriUser> getChart(WriUser wriUser){ //表格
	// return eventHandleBiz.getChart(wriUser);
	// }
	public String[] getTitle() { // 表头
		return eventHandleBiz.getTitle();
	}
}
