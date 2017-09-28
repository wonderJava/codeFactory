<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.action;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ${basepackage}.bean.BosException;
import ${basepackage}.bean.OutParams;
import ${basepackage}.constants.ComConstants;
import ${basepackage}.service.post.I${className}Service;
import ${basepackage}.util.JsonUtil;
import ${basepackage}.util.ListUtil;
import ${basepackage}.util.MapUtil;

/**
 * @author huchao
 * @version 1.0
 * @description ${huchao_1}的增删改查
 *  
 */
@Controller
@RequestMapping("/${classNameLower}/")
public class ${className}Action {
	@Resource
	private I${className}Service ${classNameLower}Service;
	Logger logger = LoggerFactory.getLogger(${className}Action.class);

	public I${className}Service get${className}Service() {
		return ${classNameLower}Service;
	}

	public void set${className}Service(I${className}Service ${classNameLower}Service) {
		this.${classNameLower}Service = ${classNameLower}Service;
	}

	/**
	 * @description 增加${huchao_1}
	 * @return
	 * @<#if now??>${now?string('yyyy-MM-dd')}</#if>
	 * @author huchao
	 */
	@RequestMapping("add.action")
	@ResponseBody
	public String add(HttpServletResponse response, HttpServletRequest request) {
		// String ${classNameLower}Id =
		// StringUtil.clearBlank(request.getAttribute("${classNameLower}Id"));
		// 获取参数值，
		Map<String, Object> params = ListUtil.getMapFromReq(request.getParameterMap());
		OutParams outParams = new OutParams();
		try {
			outParams = ${classNameLower}Service.add${className}(params);
		} catch (Exception e) {
			outParams.setReturnCode(ComConstants.FAIL);
			outParams.setReturnMsg("添加${huchao_1}错误");
			logger.error("添加${huchao_1}错误", e);
		}
		return JsonUtil.convertObject2Json(outParams);
	}

	/**
	 * @description 查询所有的${huchao_1}信息
	 * @param response
	 * @param request
	 * @return
	 * @<#if now??>${now?string('yyyy-MM-dd')}</#if>
	 * @author huchao
	 */
	@RequestMapping("queryAll.action")
	@ResponseBody
	public String queryAll(HttpServletResponse response, HttpServletRequest request) {
		// 获取参数值，
		Map<String, Object> params = MapUtil.getMapFromReq(request.getParameterMap());
		// params.put("pageFlag", "true");
		OutParams outParams = new OutParams();
		try {
			outParams = ${classNameLower}Service.query${className}ByCond(params);
		} catch (BosException e) {
			outParams.setReturnCode(ComConstants.FAIL);
			outParams.setReturnMsg("查询${huchao_1}错误");
			logger.error("queryAll查询${huchao_1}信息失败", e);
		}
		return JsonUtil.convertObject2Json(outParams);
	}
	/**
	 * @description
	 *	修改${huchao_1}数据
	 * @param response
	 * @param request
	 * @return
	 * @<#if now??>${now?string('yyyy-MM-dd')}</#if>
	 * @author huchao
	 */
	@RequestMapping("update${className}.action")
	@ResponseBody
	public String update(HttpServletResponse response, HttpServletRequest request) {
		Map<String, Object> params = MapUtil.getMapFromReq(request.getParameterMap());
		OutParams outParams = new OutParams();
		try {
			outParams=${classNameLower}Service.updateBy${className}Id(params);
		} catch (Exception e) {
			outParams.setReturnCode(ComConstants.FAIL);
			outParams.setReturnMsg("修改${huchao_1}错误");
			logger.error("修改${huchao_1}信息失败", e);
		}
		return JsonUtil.convertObject2Json(outParams);
	}
	/**
	 * @description
	 *	删除${huchao_1}数据
	 * @param response
	 * @param request
	 * @return
	 *@<#if now??>${now?string('yyyy-MM-dd')}</#if>
	 *@author huchao
	 */
	@RequestMapping("delete${className}.action")
	@ResponseBody
	public String delete(HttpServletResponse response, HttpServletRequest request) {
		Map<String, Object> params = MapUtil.getMapFromReq(request.getParameterMap());
		OutParams outParams = new OutParams();
		try {
			outParams=${classNameLower}Service.deleteById(params);
		} catch (Exception e) {
			outParams.setReturnCode(ComConstants.FAIL);
			outParams.setReturnMsg("删除${huchao_1}错误");
			logger.error("删除${huchao_1}信息失败", e);
		}
		return JsonUtil.convertObject2Json(outParams);
	}
}