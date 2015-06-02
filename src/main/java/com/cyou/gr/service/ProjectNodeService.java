package com.cyou.gr.service;

import java.util.List;
import java.util.Map;

import com.cyou.gr.entity.ProNode;
import com.cyou.gr.entity.vo.ProNodeVo;

public interface ProjectNodeService {

	List<ProNode> selectProjNodeList(Integer projectId);

	ProNode selectProjectNodeRelatedById(Integer id);

	void updateProjectNode(ProNodeVo vo);

	boolean sendEmailToPersonService(Map<String, Object> map) throws Exception;

	List<ProNode> selectPjnListForCalendar();

}
