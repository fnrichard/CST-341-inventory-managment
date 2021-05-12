/*
	@Author Alex J. Zoller
*/
package com.gcu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller 
public class MainLandingController {
	
	@RequestMapping("/") 
    public String home(){
        return "MainLanding"; 
    }  
	
	
	

}
