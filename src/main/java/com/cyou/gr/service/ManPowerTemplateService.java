package com.cyou.gr.service;

import java.util.List;

import com.cyou.gr.entity.ManpowerTemplate;

public interface ManPowerTemplateService {

	List<ManpowerTemplate> selectManpowerTemplatesByprocNodeId(Integer procNodeId);

}
