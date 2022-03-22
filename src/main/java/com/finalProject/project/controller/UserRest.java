package com.finalProject.project.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

import com.finalProject.project.controller.staticObjects.LoginForm;
import com.finalProject.project.dao.RolesCRUDRepository;
import com.finalProject.project.dao.UsersCRUDRepository;
import com.finalProject.project.entity.Role;
import com.finalProject.project.entity.User;




@RestController
@RequestMapping("user")
public class UserRest {
	private RolesCRUDRepository rolesRepository;
	private UsersCRUDRepository userRepository;
	
	
    public void addViewControllers(ViewControllerRegistry registry) {
     
        registry.addViewController("/inises").setViewName("login");
         
    }
	
	@RequestMapping(value="/addUser",method=RequestMethod.GET)
//	public ResponseEntity<User> crearUser() {
	public void crearUser() {
			User usu = new User();
//			usu.setId(1);
			usu.setEnabled(1);
			usu.setPassword("testPass");
			usu.setUser("test");
			
			Role rol = new Role();
			rol.setId(3);
			
			usu.setRole(rol);

			//No guardo el rol para que no sobreescriba la tabla
//			rolesRepository.save(rol);
			
			userRepository.save(usu);		
	}
	@RequestMapping(value = "/login", method = RequestMethod.GET)
  public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		
		return modelAndView;
  }
		
	
//	@RequestMapping(value = "/login", method = RequestMethod.GET)
//	public ModelAndView getLogginPage() {
//		ModelAndView modelAndView = new ModelAndView();
//		modelAndView.setViewName("login");
//		
//		return modelAndView;
//	}
	
	
	
//	@RequestMapping(value = "/login", method = RequestMethod.POST)
//	public ModelAndView postLoginData(
//			@RequestParam("username") String userName,
//			@RequestParam("password") String userPass) {
//		
//		ModelAndView modelAndView = new ModelAndView();
//		
//		modelAndView.addObject("userName", userName);
//		modelAndView.addObject("login", userRepository.getLogin(userName, userPass));
//		System.out.println(userRepository.getLogin(userName, userPass));
//		User usr = userRepository.getLogin(userName, userPass);
//		
//		if (usr != null) {
//			return new ModelAndView("redirect:/user/access");
//			
//		} else {
//			
//			modelAndView.setViewName("login");
//		}
//
//		
//		return modelAndView;
//	}
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView getHome() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("home");
		
		
		// Obtiene el objeto usuario generado por el auth
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		System.out.println(principal);
		
		return modelAndView;
		
	}
	
	@RequestMapping(value = "/access", method = RequestMethod.POST)
//	public ModelAndView access(@RequestParam LoginForm usu) {
	public ModelAndView access(
			@RequestParam("user") String userName,
			@RequestParam("pass") String userPass) {
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.addObject("userName", userName);
		modelAndView.addObject("login", userRepository.getLogin(userName, userPass));
		System.out.println(userRepository.getLogin(userName, userPass));
		User usr = userRepository.getLogin(userName, userPass);
		
		if (usr != null) {
			System.out.println(usr.getId());
			
			modelAndView.setViewName("home");
		} else {
			return new ModelAndView("redirect:/user/login");
//			modelAndView.setViewName("login");
		}
//		System.out.println(usr.getId());;
		
		return modelAndView;
	}
	
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView geteRegisterPage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("register");
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView postRegisterData(
			@RequestParam("user") String userName, 
			@RequestParam("pass") String userPass) {
		
		
		//Generates basic level Rol (lvl 3 => BasicUser)
		Role rol = new Role();
		rol.setId(3);
		
		User usu = new User();
		
		usu.setEnabled(1);
		usu.setPassword(userPass);
		usu.setUser(userName);
		usu.setRole(rol);
		
		userRepository.save(usu);	
		return new ModelAndView("redirect:/user/login");
	}
	
	@RequestMapping(value = "/userList", method = RequestMethod.GET)
	public ModelAndView listAllUsers() {
		ModelAndView modelAndView = new ModelAndView();
		
//		List<User> list = (List<User>) userRepository.getAllUsers();
//		list.add(userRepository.getAllUsers());
//		System.out.println(userRepository);
		
		Iterable<User> list = userRepository.findAll();
//		System.out.println(list.);
		
		
		
		List<User> list2 = (List<User>)list;
		
//		List<String> empList = new ArrayList<>();
//		empList.add("yokse");
//		empList.add("asdlkfj");
		
		modelAndView.setViewName("userList");
		modelAndView.addObject("lista", list2);
		
		
		

//		
//		for (int i = 0; i < list2.size(); i++) {
//			System.out.println(list2.get(i).getId());;
//		}
		

		
		
		
		
		return modelAndView;
	}
	
	
	@RequestMapping(value = "/updateUserData", method =RequestMethod.GET)
	public ModelAndView readUserData() {
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("updateUserData");
		
		
		
		
		return modelAndView;
		
	}
	
	@RequestMapping(value = "/updateUserData", method =RequestMethod.PUT)
	public void updateUserData() {
		
	}
	
	
	

	public UsersCRUDRepository getRepository() {
		return userRepository;
	}

	@Autowired
	public void setRepository(UsersCRUDRepository repository) {
		this.userRepository = repository;
	}

	public RolesCRUDRepository getRolesRepository() {
		return rolesRepository;
	}
	
	@Autowired
	public void setRolesRepository(RolesCRUDRepository rolesRepository) {
		this.rolesRepository = rolesRepository;
	}
}
