package org.hardcrystal.mvcHtml5Angular.mvc.jdbc;

import org.hardcrystal.mvcHtml5Angular.mvc.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class JDBCController {

    @Autowired
    JDBCExample jdbcExample;

    @RequestMapping(value = "/jdbcQueryAllUsers", method = RequestMethod.GET)
    public ModelAndView jdbcSelectAllUsers(){
        System.out.println("JDBCController: jdbcSelectAllUsers() is called");
        List<User> users = JDBCExample.
    }
}
