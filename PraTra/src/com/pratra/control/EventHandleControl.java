package com.pratra.control;

import java.util.List;

import com.pratra.biz.EventHandleBiz;
import com.pratra.entity.WriUser;

/**
 * @ ������Ʋ�
 * 
 * @mvcģʽ�е�control��
 */
public class EventHandleControl {

	private EventHandleBiz eventHandleBiz;

	public EventHandleControl() {
		eventHandleBiz = new EventHandleBiz();
	}

	public WriUser insert(WriUser wriUser) {
		return eventHandleBiz.insert(wriUser);
	}

	// public List<WriUser> getChart(WriUser wriUser){ //���
	// return eventHandleBiz.getChart(wriUser);
	// }
	public String[] getTitle() { // ��ͷ
		return eventHandleBiz.getTitle();
	}
}
