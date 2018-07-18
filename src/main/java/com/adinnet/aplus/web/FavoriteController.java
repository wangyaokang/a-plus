/**
 * 
 */
package com.adinnet.aplus.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.adinnet.aplus.model.Favorite;
import com.adinnet.framework.web.BaseController;

/**
 * @author zhurui
 *
 */
@Controller
@RequestMapping("/favorite")
public class FavoriteController extends BaseController<Favorite> {

}
