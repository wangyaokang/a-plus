/**
 * 
 */
package com.adinnet.aplus.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.adinnet.aplus.model.Teacher;
import com.adinnet.framework.web.BaseController;

/**
 * @author zhurui
 *
 */
@Controller
@RequestMapping("/teacher")
public class TeacherController extends BaseController<Teacher> {

}
