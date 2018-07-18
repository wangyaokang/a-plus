/**
 * 
 */
package com.adinnet.aplus.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.adinnet.aplus.model.Material;
import com.adinnet.framework.web.BaseController;

/**
 * @author zhurui
 *
 */
@Controller
@RequestMapping("/material")
public class MaterialController extends BaseController<Material> {

}
