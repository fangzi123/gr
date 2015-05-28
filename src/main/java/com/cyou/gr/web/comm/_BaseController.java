package com.cyou.gr.web.comm;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import org.springframework.web.servlet.support.RequestContextUtils;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Locale;

public abstract class _BaseController extends MultiActionController {

	protected transient Logger log = LoggerFactory.getLogger(this.getClass());
	/**
	 * 候选日期模式
	 */
	private String[] candidateDatePatterns;

	/**
	 * @return
	 * @Description 创建ModelAndView实例
	 * @author
	 */
	protected ModelAndView createMAV() {
		return new ModelAndView();
	}

	/**
	 * @param viewName
	 * @return
	 * @Description 创建带有试图名称的ModelAndView实例
	 * @author
	 */
	protected ModelAndView createMAV(String viewName) {
		return new ModelAndView(viewName);
	}

	/**
	 * @param request
	 * @param clazz
	 *            绑定类
	 * @return
	 * @throws Exception
	 * @Description 通过请求参数绑定Model
	 * @author
	 */
	protected <T> T bindModel(HttpServletRequest request, Class<T> clazz)
			throws Exception {
		T object = (T) newCommandObject(clazz);
		bind(request, object);
		return object;
	}

	/**
	 * @param request
	 * @param name
	 *            参数名称
	 * @return
	 * @Description 从请求中获取String类型参数
	 * @author
	 */
	protected String findStringParameterValue(HttpServletRequest request,
			String name) {
		return WebUtils.findParameterValue(request, name);
	}

	protected Integer findIntegerParameterValue(HttpServletRequest request,
			String name) {
		String pv = WebUtils.findParameterValue(request, name);
		return StringUtils.isBlank(pv) ? null : Integer.parseInt(pv);
	}

	protected Boolean findBooleanParameterValue(HttpServletRequest request,
			String name) {
		String pv = WebUtils.findParameterValue(request, name);
		return StringUtils.isBlank(pv) ? null : Boolean.parseBoolean(pv);
	}

	protected Locale getLocal(HttpServletRequest request) {
		return RequestContextUtils.getLocale(request);
	}

	public void setCandidateDatePatterns(String[] candidateDatePatterns) {
		this.candidateDatePatterns = candidateDatePatterns;
	}
	
	protected void returnJson(HttpServletResponse response, String json)
            throws Exception {
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().print(json);
    }
}
