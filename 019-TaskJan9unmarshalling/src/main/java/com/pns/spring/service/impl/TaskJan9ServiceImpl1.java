package com.pns.spring.service.impl;

import com.pns.spring.model.ReqValAdd;
import com.pns.spring.service.TaskJan9Service;

public class TaskJan9ServiceImpl1 implements TaskJan9Service{

	@Override
	public ReqValAdd getReqValAdd(ReqValAdd reqValAdd) {
		System.out.println("TaskJan9ServiceImpl1.getReqValAdd()");
		return reqValAdd;
	}
	
}
