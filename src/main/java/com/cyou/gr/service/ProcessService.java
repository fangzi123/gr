package com.cyou.gr.service;

import java.util.List;

import com.cyou.gr.entity.Process;

public interface ProcessService {

	List<Process> selectProcessList();

	void saveOrUpdateProcess(Process p);

	void updownSort(Integer upSort, Integer upId, Integer downSort,
			Integer downId);

	Process selectProcessById(Integer procId);

}
