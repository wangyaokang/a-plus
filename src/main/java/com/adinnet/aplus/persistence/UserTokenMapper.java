/**
 * 
 */
package com.adinnet.aplus.persistence;

import org.springframework.stereotype.Repository;

import com.adinnet.aplus.model.UserToken;
import com.adinnet.framework.mybatis.BaseMapper;

/**
 * @author zhurui
 *
 */
@Repository
public interface UserTokenMapper extends BaseMapper<UserToken> {

}
