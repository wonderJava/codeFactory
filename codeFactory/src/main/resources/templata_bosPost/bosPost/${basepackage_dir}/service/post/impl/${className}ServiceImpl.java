<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 

<#assign classNameFirstLower = table.classNameFirstLower> 
<#macro mapperEl value>${r"#{"}${value}}</#macro>
<#macro namespace>${className}.</#macro>

package ${basepackage}.service.post.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections.MapUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ${basepackage}.bean.BosException;
import ${basepackage}.bean.OutParams;
import ${basepackage}.constants.ComConstants;
import ${basepackage}.dao.impl.BaseDaoImpl;
import ${basepackage}.service.post.I${className}Service;
import ${basepackage}.util.MapUtil;
import ${basepackage}.util.PageUtil;

/**
 * @author huchao
 * @<#if now??>${now?string('yyyy-MM-dd')}</#if>
 * @description ${huchao1}的Service
 */
@Service
@Transactional
public class ${className}ServiceImpl implements I${className}Service {
	@Resource
	private BaseDaoImpl baseDao;

	public BaseDaoImpl getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDaoImpl baseDao) {
		this.baseDao = baseDao;
	}

	/**
	 * 添加${huchao1}
	 */
	public OutParams add${className}(Map<String, Object> beanIn) {
		// 重新封装参数，需要哪些参数显示出来
		String[] strArr = new String[] {<#list table.notPkColumns as column>"${column.columnNameFirstLower}"<#if column_has_next>,</#if></#list> };
		Map<String, Object> params = MapUtil.getMapFromMapByArray(beanIn, strArr);
		//
		OutParams outParams = new OutParams();
		int num = 0 ;
		if (MapUtils.isNotEmpty(params)) {
			num= getBaseDao().insert("${className}Mapper.insert${className}", params);
		}
		if (num != 1) {
			outParams.setReturnCode(ComConstants.FAIL);
			outParams.setReturnMsg("添加失败");
		} else {
			outParams.setReturnCode(ComConstants.SUCCESS);
		}
		return outParams;
	}

	/**
	 * 条件查询${huchao1}，可选分页展示，或者不分页展示（无pageFlag或者pageFlag为false）
	 * 
	 * @throws BosException
	 */
	public OutParams query${className}ByCond(Map<String, Object> beanIn) {
		// 重新封装参数，需要哪些参数显示出来
		String[] strArr = new String[] {<#list table.notPkColumns as column>"${column.columnNameFirstLower}"<#if column_has_next>,</#if></#list>};
		Map<String, Object> params = MapUtil.getMapFromMapByArray(beanIn, strArr);
		// 添加分页信息
		Map<String, Object> pageCond = PageUtil.getPageCondByArr(beanIn,
				new String[] { "pageFlag", "page", "pageSize" });
		params.putAll(pageCond);
		//
		OutParams outParams = new OutParams();
		List<Map<String, Object>> ${classNameLower}MapList = getBaseDao().queryForList("${className}Mapper.query${className}ByCond", params,
				Map.class);
		// 如果查询失败，会报异常，所以返回码不会是成功
		outParams.setReturnCode(ComConstants.SUCCESS);
		outParams.setBean(${classNameLower}MapList);
		return outParams;
	}
	/**
	 * 根据${className}Id修改${huchao1}的数据
	 */
	public OutParams updateBy${className}Id(Map<String, Object> beanIn) throws BosException {
		// 重新封装参数，需要哪些参数显示出来
		String[] strArr = new String[] {<#list table.columns as column>"${column.columnNameFirstLower}"<#if column_has_next>,</#if></#list>};
		Map<String, Object> params = MapUtil.getMapFromMapByArray(beanIn, strArr);
		//
		OutParams outParams = new OutParams();
		int num = getBaseDao().update("${className}Mapper.updateBy${className}Id", params);
		if (num<1) {
			throw new BosException("修改数据失败");
		}
		// 如果修改失败，会报异常，所以返回码不会是成功
		outParams.setReturnCode(ComConstants.SUCCESS);
		return outParams;
	}
	/**
	 * 根据Id删除${huchao1}
	 */
	public OutParams deleteById(Map<String, Object> beanIn) throws BosException {
		// 重新封装参数，需要哪些参数显示出来
		String[] strArr = new String[] {<#list table.columns as column>"${column.columnNameFirstLower}"<#if column_has_next>,</#if></#list>};
		Map<String, Object> params = MapUtil.getMapFromMapByArray(beanIn, strArr);
		//
		OutParams outParams = new OutParams();
		int num = 0;
		if (MapUtils.isNotEmpty(params)) {
			num = getBaseDao().delete("${className}Mapper.deleteById", params);
		}
		if (num < 1) {
			throw new BosException("删除数据失败");
		}
		// 如果删除失败，会报异常，所以返回码不会是成功
		outParams.setReturnCode(ComConstants.SUCCESS);
		return outParams;
	}
}
