package com.stackroute.controller;


import com.stackroute.configuration.CrudOperation;
import com.stackroute.configuration.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {

    @RequestMapping(value="/")
    public String greeting(ModelMap map)
    {
        return "index";

    }

    @RequestMapping(value="/loginaadmele")
    public ModelAndView log(HttpServletRequest request, HttpServletResponse response) {
        Person person = new Person();
     String username=request.getParameter("username");
     String password=request.getParameter("password");


        person.setName(request.getParameter("username"));
        person.setPassword(request.getParameter("password"));

         CrudOperation crudOperation = new CrudOperation();
         crudOperation.insertCustomer(username,password);

         String resultUsername= crudOperation.displayLoginInfo(username,password);

        ModelAndView mv = new ModelAndView();
        mv.setViewName("result");
        mv.addObject("result", "welcome " + resultUsername + " to Stackroute");

        return mv;

    }
}

