/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.module.web.rest;

import org.module.sysadmin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author achmadsy
 */
@Controller
public class HRRestTest {
    
    @Autowired
    UserService userService;
    
    @RequestMapping(value = "/service/HR/getTest", method = RequestMethod.POST)
    public ResponseEntity<String> getTest(@RequestBody String test) {
        return new ResponseEntity<String>(test, HttpStatus.CREATED);
    }
    
    @RequestMapping(value = "/service/HR/getPassword", method = RequestMethod.POST)
    public ResponseEntity<String> getPassword(@RequestBody String test) {
        String pass = userService.getUserByLoginNames(test).getUsrPassword();
        return new ResponseEntity<String>(pass, HttpStatus.CREATED);
    }
}
