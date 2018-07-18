/**
 * 
 */
package com.adinnet.framework.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.adinnet.framework.entity.AutoIdEntity;
import com.adinnet.framework.mybatis.BaseMapper;
import com.adinnet.framework.page.PageBounds;
import com.adinnet.framework.page.Paginator;
import com.adinnet.framework.service.BaseService;

/**
 * Service的CRUD基类
 * 
 * @author bocar
 *
 */
public abstract class BaseServcieImpl<T> implements BaseService<T> {
	
	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	protected BaseMapper<T> mapper;

	/* (non-Javadoc)
	 * @see com.adinnet.framework.service.BaseService#get(java.lang.Long)
	 */
	@Override
	public T get(Long id) {
		if (id == null) {
			return null;
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		return get(map);
	}

	/* (non-Javadoc)
	 * @see com.adinnet.framework.service.BaseService#get(java.lang.Long)
	 */
	@Override
	public T get(Map<String, Object> map) {
		if (map == null || map.isEmpty()) {
			return null;
		}
		return mapper.get(map);
	}

	/* (non-Javadoc)
	 * @see com.adinnet.framework.service.BaseService#query()
	 */
	@Override
	public List<T> query() {
		return mapper.query();
	}

	/* (non-Javadoc)
	 * @see com.adinnet.framework.service.BaseService#query(com.adinnet.framework.page.Paginator)
	 */
	@Override
	public List<T> query(Paginator page) {
		return mapper.query(PageBounds.wrap(page));
	}

	/* (non-Javadoc)
	 * @see com.adinnet.framework.service.BaseService#query(java.util.Map)
	 */
	@Override
	public List<T> query(Map<String, Object> map) {
		if (map == null || map.isEmpty()) {
			return query();
		}
		return mapper.queryByMap(map);
	}

	/* (non-Javadoc)
	 * @see com.adinnet.framework.service.BaseService#query(java.util.Map, com.adinnet.framework.page.Paginator)
	 */
	@Override
	public List<T> query(Map<String, Object> map, Paginator page) {
		if (map == null || map.isEmpty()) {
			return query(page);
		}
		return mapper.queryByMap(map, PageBounds.wrap(page));
	}

	/* (non-Javadoc)
	 * @see com.adinnet.framework.service.BaseService#insert(java.lang.Object)
	 */
	@Override
	public void insert(T entity) {
		if (entity == null) {
			return;
		}
		mapper.insert(entity);
	}

	/* (non-Javadoc)
	 * @see com.adinnet.framework.service.BaseService#update(java.lang.Object)
	 */
	@Override
	public void update(T entity) {
		if (entity == null) {
			return;
		}
		mapper.update(entity);
	}

	/* (non-Javadoc)
	 * @see com.adinnet.framework.service.BaseService#save(java.lang.Object)
	 */
	@Override
	public void save(T entity) {
		if (!(entity instanceof AutoIdEntity)) {
			return;
		}
		AutoIdEntity baseEntity = (AutoIdEntity) entity;
		if (baseEntity.getId() == null || baseEntity.getId() == 0) {
			insert(entity);
		} else {
			update(entity);
		}
	}

	/* (non-Javadoc)
	 * @see com.adinnet.framework.service.BaseService#delete(java.lang.Long)
	 */
	@Override
	public void delete(T entity) {
		if (entity == null) {
			return;
		}
		mapper.delete(entity);
	}

}
