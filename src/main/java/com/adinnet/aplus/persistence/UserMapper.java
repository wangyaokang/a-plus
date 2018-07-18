/**
 * 
 */
package com.adinnet.aplus.persistence;

import org.springframework.stereotype.Repository;

import com.adinnet.aplus.model.User;
import com.adinnet.framework.mybatis.BaseMapper;

/**
 * @author zhurui
 *
 */
@Repository
public interface UserMapper extends BaseMapper<User> {

}
