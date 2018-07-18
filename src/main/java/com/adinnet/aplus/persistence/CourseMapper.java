/**
 * 
 */
package com.adinnet.aplus.persistence;

import org.springframework.stereotype.Repository;

import com.adinnet.aplus.model.Course;
import com.adinnet.framework.mybatis.BaseMapper;

/**
 * @author zhurui
 *
 */
@Repository
public interface CourseMapper extends BaseMapper<Course> {

}
