/**
 * 
 */
package com.adinnet.aplus.persistence;

import org.springframework.stereotype.Repository;

import com.adinnet.aplus.model.Item;
import com.adinnet.framework.mybatis.BaseMapper;

/**
 * @author zhurui
 *
 */
@Repository
public interface ItemMapper extends BaseMapper<Item> {

}
