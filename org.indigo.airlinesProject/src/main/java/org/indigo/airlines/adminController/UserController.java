package org.indigo.airlines.adminController;

import org.indigo.airlines.adminService.AdminService;
import org.indigo.airlines.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController//make use of RESTAPI
@RequestMapping("/api/user")
public class UserController 
{
	@Autowired
	private AdminService adminService;
	
	//Create an api add details in db
	//to take input from postman in the form of java object
		@PostMapping("/addUsers")
		public ResponseEntity<String> addUser(@RequestBody UserDTO userDTO)
		{
			System.out.println(userDTO);
			int userid=adminService.addUser(userDTO);
			return ResponseEntity.status(HttpStatus.CREATED).body("User Id is "+userid);
			
		}
	//show log in successfull if username and password matches then
		@GetMapping("/userLogIn/{name}/{password}")
		public ResponseEntity<String> userLogIn(@PathVariable("name") String userName, @PathVariable("password") int password)
		{
			UserDTO dto = adminService.userLogIn(userName, password);
			if (dto!=null)
			{
				return ResponseEntity.status(HttpStatus.ACCEPTED).body("Login successful");
			}
			else
			{
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("failed to login");
			}
			
		}
}
