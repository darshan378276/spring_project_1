package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.model.LoginDetails;
import com.model.Shop;

@Controller
@RequestMapping(value="/control1")
public class SpringController1 {

	@RequestMapping(value="/one", method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView method1() {
		return new ModelAndView("hellopage","message","messageText1");
	}
	
	@RequestMapping(value="/two")
	public @ResponseBody LoginDetails method2() {
		LoginDetails ld = new LoginDetails();
		ld.setUsername("darshanUser");
		ld.setPassword("darshanPassword");
		return ld;
	}
	
	//   http://localhost:8080/SpringMVC/Page.html
	@RequestMapping(value="/three")
	public @ResponseBody String method3() {
		return "[{\"display\": \"HTMLL Tutorial\",\"url\": \"https://www.w3schools.com/js/default.asp\"}]";
	}
	
	@RequestMapping(value={"/method0","/method0/otherURL"})
	@ResponseBody
	public String method0(){
		return "method0";
	}
	
	@RequestMapping(value="/four", headers={"Upgrade-Insecure-Requests=1","Upgrade-Insecure-Requests=1"})
	@ResponseBody
	public String method5(){
		return "four";
	}
	
	// http://localhost:8080/SpringMVC/rest/control1/method7/10
	@RequestMapping(value="/method7/{id}")
	@ResponseBody
	public String method7(@PathVariable("id") int id){
		return "method7 with id="+id;
	}
	
	// http://localhost:8080/SpringMVC/rest/control1/method7/10
	@RequestMapping(value="/method8/{id:[\\d]+}/{name}")
	@ResponseBody
	public String method8(@PathVariable("id") long id, @PathVariable("name") String name){
		return "method8 with id= "+id+" and name="+name;
	}
	
	@RequestMapping(value="/method9")
	@ResponseBody
	public String method9(@RequestParam("id") int id){
		return "method9 with id= "+id;
	}
	
	// http://localhost:8080/SpringMVC/rest/control1
	@RequestMapping()
	@ResponseBody
	public String defaultMethod(){
		return "default method";
	}
	
	// http://localhost:8080/SpringMVC/rest/control1/rfrf
	@RequestMapping("*")
	@ResponseBody
	public String fallbackMethod(){
		return "fallback method";
	}
	
	// http://localhost:8080/SpringMVC/rest/control1/five/one
	@RequestMapping(value = "/five/{name}", method = RequestMethod.GET)
	public @ResponseBody
	Shop getShopInJSON(@PathVariable String name) {

		Shop shop = new Shop();
		shop.setName(name);
		shop.setStaffName(new String[] { "mkyong1", "mkyong2" });

		return shop;

	}
}
