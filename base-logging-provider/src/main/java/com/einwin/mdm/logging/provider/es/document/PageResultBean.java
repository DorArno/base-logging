package com.einwin.mdm.logging.provider.es.document;

import java.util.List;

/**
* @author:gaoyb
* @version 创建时间：2016年9月13日 下午9:28:38
* 分页返回结果bean
*/

public class PageResultBean {
	
    private List<?> list;
    
    
    private long totalCount;

	/**
	 * @return the list
	 */
	public List<?> getList() {
		return list;
	}

	/**
	 * @param list the list to set
	 */
	public void setList(List<?> list) {
		this.list = list;
	}

	/**
	 * @return the totalCount
	 */
	public long getTotalCount() {
		return totalCount;
	}

	/**
	 * @param totalCount the totalCount to set
	 */
	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}

	
}
