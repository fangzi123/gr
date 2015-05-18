package com.cyou.gr.service;

import java.util.List;

import com.cyou.gr.entity.FeeTemplate;

public interface FeeTemplateService {

	List<FeeTemplate> selectFeeTemplatesByprocNodeId(Integer id);

}
