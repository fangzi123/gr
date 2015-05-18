package com.cyou.gr.service;

import java.util.List;

import com.cyou.gr.entity.CheckbillTemplate;

public interface CheckbillTemplateService {

	List<CheckbillTemplate> selectCheckbillTsByProcNodeId(Integer id);

}
