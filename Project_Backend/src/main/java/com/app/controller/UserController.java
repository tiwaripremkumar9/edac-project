package com.app.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.dtos.FoodCart;
import com.app.dtos.FoodList;
import com.app.dtos.LoginRequest;
import com.app.dtos.RestaurantsList;
import com.app.dtos.UserDTO;
import com.app.pojos.Foods;
import com.app.pojos.Payment;
import com.app.pojos.Restaurant;
import com.app.pojos.User;
import com.app.service.ICartService;
import com.app.service.IFoodService;
import com.app.service.IPaymentService;
import com.app.service.IRestaurantService;
import com.app.service.IUserService;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins ="http://localhost:3000")
public class UserController {
	@Autowired
	private IUserService userService;
	@Autowired
	private IRestaurantService restService;
	@Autowired
	private ICartService cartService;
	@Autowired
	private IFoodService foodService;
	@Autowired
	private IPaymentService payService;
	
	public UserController() {
		System.out.println("in ctr of "+getClass().getName());
	}
	@PostMapping("/register")
	public ResponseEntity<?> createNewUser(@RequestBody User newUser){
		System.out.println("in create new user"+ newUser);
		return new ResponseEntity<>(userService.createNewUser(newUser),HttpStatus.CREATED);
	}
	@GetMapping("/logout")
	public ResponseEntity<?> userLogout(HttpSession session, Model map, HttpServletRequest request, HttpServletResponse resp ) {
		System.out.println("in UserLogout");
		map.addAttribute("details", session.getAttribute("user_details"));
		session.invalidate();
		resp.setHeader("refresh", "3;url="+request.getContextPath());
		return new ResponseEntity<>(HttpStatus.OK);		
	}

	@PostMapping("/login")
  public ResponseEntity<?> authenticateUser (@RequestBody LoginRequest request)
  { 
	User user = userService.authenticateUser(request.getEmail(),request.getPassword());
	
	if(user!=null) {
		System.out.println("user logged in is "+user); 
		return new ResponseEntity<>(user, HttpStatus.OK);
	}else {
		Restaurant rest = restService.authenticateRest(request.getEmail(),request.getPassword()); 
	System.out.println("rest logged in is "+rest); 
	return new ResponseEntity<>(rest, HttpStatus.OK);
	}
  }
	@GetMapping("/search/restaurant/{name}")
  public ResponseEntity<?> findByRestaurantName(@PathVariable String name){
	  System.out.println("in find by name"+ name);
	  List<Restaurant> restList=restService.findByName(name);
	  if(restList.size()==0) {
		  return new ResponseEntity<>(new RestaurantsList(restList), HttpStatus.NO_CONTENT);
	  }
	return ResponseEntity.ok(new RestaurantsList(restList));
  }
	@GetMapping("/search/foods/{name}")
	  public ResponseEntity<?> findFoodByName(@PathVariable String name){
		  System.out.println("in find food  by name"+ name);
		  List<Foods> foodList=userService.findByName(name);
		  if(foodList.size()==0) {
			  return new ResponseEntity<>(new FoodList(foodList), HttpStatus.NO_CONTENT);
		  }
		return ResponseEntity.ok(new FoodList(foodList));
	  }
	@GetMapping("/search/foods_category")
	  public ResponseEntity<?> findFoodByCategory(@RequestParam(name="Category") String category){
		  System.out.println("in find food  by name"+ category);
		  List<Foods> foodList=foodService.findByCategory(category);
		  if(foodList.size()==0) {
			  return new ResponseEntity<>(new FoodList(foodList), HttpStatus.NO_CONTENT);
		  }
		return ResponseEntity.ok(new FoodList(foodList));
	  }

	  @PutMapping("/{userId}")
	  public ResponseEntity<?> updateUserDetails(@PathVariable int userId, @RequestBody UserDTO userDTO){
		  System.out.println("in update details: "+userId+" "+userDTO);
		  return new ResponseEntity<>(userService.updateUserDetails(userId, userDTO),HttpStatus.OK);
	  }  
 @GetMapping("/cart/{userId}")
	  public ResponseEntity<?> getFoodCart(){
		  return ResponseEntity.ok(cartService.getFoodInCart());
	  }
	  @GetMapping("/Cart/addFood/{foodId}")
	    public List<FoodCart> addProductToCart(@PathVariable("foodId") int foodId ) {
		  System.out.println("in user contoleer add food method");
		  System.out.println(foodService.findById(foodId).get());
	      cartService.addFood(foodId);
	        return cartService.getFoodInCart();
	    }
	  @GetMapping("/shoppingCart/removeFood/{foodId}")
	    public ResponseEntity<?> removeProductFromCart(@PathVariable("foodId") int foodId) {
	        cartService.removeProduct(foodId);
	        return ResponseEntity.ok(cartService.getFoodInCart());
	    }
		
		@PostMapping("/{userId}")
		public ResponseEntity<?> addAddressOfUser(@PathVariable int userId, @RequestParam(name = "add") String address) {
			System.out.println(" in add address of user method of controller  "+userId+"  "+address);
			userService.addAddress(userId, address);
			return new ResponseEntity<>(userService.addAddress(userId, address), HttpStatus.ACCEPTED);
			
		}
@PostMapping("/add_payment/{userId}/{orderId}")
	  public ResponseEntity<?> addPayment(@PathVariable("userId") int userId,@PathVariable("orderId") int orderId, @RequestBody Payment pay){
		  payService.addPayment(userId, orderId,pay);
		  return new ResponseEntity<>(payService.addPayment(userId, orderId,pay),HttpStatus.CREATED); 
	  }

}
