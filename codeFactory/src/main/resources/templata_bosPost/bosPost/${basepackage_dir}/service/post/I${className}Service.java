<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
package cn.huchao.service.post;

import java.util.Map;

import cn.huchao.bean.BosException;
import cn.huchao.bean.OutParams;

/**
 * @author huchao
 * @<#if now??>${now?string('yyyy-MM-dd')}</#if>
 * @description
 *  ${huchao1}的业务接口
 */
public interface I${className}Service {
	/**
	 * @description
	 *	增加${huchao1}
	 * @param beanIn
	 * @return
	 * @throws BosException
	 * @<#if now??>${now?string('yyyy-MM-dd')}</#if>
	 * @author huchao
	 */
	public OutParams add${className}(Map<String, Object> beanIn) throws BosException;
	/**
	 * @description
	 *	根据条件查询${huchao1}
	 * @param beanIn
	 * @return
	 * @throws BosException
	 * @<#if now??>${now?string('yyyy-MM-dd')}</#if>
	 * @author huchao
	 */
	public OutParams query${className}ByCond(Map<String, Object> beanIn) throws BosException;
	/**
	 * @description
	 *	根据${huchao1}Id修改${huchao1}
	 * @param beanIn
	 * @return
	 * @throws BosException
	 * @<#if now??>${now?string('yyyy-MM-dd')}</#if>
	 * @author huchao
	 */
	public OutParams updateBy${className}Id(Map<String, Object> beanIn) throws BosException;
	/**
	 * @description 根据Id删除${huchao1}
	 * @param beanIn
	 * @return
	 * @throws BosException
	 * @<#if now??>${now?string('yyyy-MM-dd')}</#if>
	 * @author huchao
	 */
	public OutParams deleteById(Map<String, Object> beanIn) throws BosException;
}
