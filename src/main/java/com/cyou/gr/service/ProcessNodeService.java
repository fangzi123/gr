package com.cyou.gr.service;

import java.util.List;

import com.cyou.gr.entity.ProcessNode;
import com.cyou.gr.entity.vo.ProcessNodeVo;

public interface ProcessNodeService {

	List<ProcessNode> selectProcNodeListByProcId(Integer procId);


	void updownSort(Integer upSort, Integer upId, Integer downSort,
			Integer downId);

	void saveOrUpdateProcessNode(ProcessNodeVo obj);


	ProcessNode selectProcNodeById(Integer id);

}
