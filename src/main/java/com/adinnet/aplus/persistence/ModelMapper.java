/**
 * 
 */
package com.adinnet.aplus.persistence;

import org.springframework.stereotype.Repository;

import com.adinnet.aplus.model.Model;
import com.adinnet.framework.mybatis.BaseMapper;

/**
 * @author zhurui
 *
 */
@Repository
public interface ModelMapper extends BaseMapper<Model> {

}
