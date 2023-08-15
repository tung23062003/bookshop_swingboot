package com.group7.bookshopwebsite.controller;

<<<<<<< HEAD
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

	@GetMapping("/no-auth/about")
	public String viewOrderDetail(Model model) {
		return "user/about";
	}

	@GetMapping("/no-auth/blog-details")
	public String viewBlogDetail(Model model) {
		return "user/blog-details";
	}

	@GetMapping("/no-auth/blogs")
	public String viewBlogs(Model model) {
		return "user/blog-details";
	}

	@GetMapping("/user/cart")
	public String viewCart(Model model) {
		return "user/cart";
	}

	@GetMapping("/user/checkout")
	public String viewCheckOut(Model model) {
		return "user/checkout";
	}

	@GetMapping("/no-auth/contact")
	public String viewContact(Model model) {
		return "user/contact";
	}

	@GetMapping("/no-auth/404")
	public String viewError404(Model model) {
		return "user/error404";
	}

	@GetMapping("/no-auth/faqs")
	public String viewFAQ(Model model) {
		return "user/faq";
	}

	@GetMapping("/no-auth/home")
	public String viewHome(Model model) {
		return "user/index";
	}

	@GetMapping("/user/my-account")
	public String viewMyAccount(Model model) {
		return "user/my-account";
	}

	@GetMapping("/no-auth/shop-grid")
	public String viewShopGrid(Model model) {
		return "no-auth/shop-grid";
	}

	@GetMapping("/no-auth/single-product")
	public String viewSingleProduct(Model model) {
		return "user/single-product";
	}

	@GetMapping("/no-auth/wish-list")
	public String viewWishList(Model model) {
		return "user/wishlist";
	}

=======
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
@AllArgsConstructor
@Controller
public class UserController {

>>>>>>> e515bdc9a7d1e99d69b8dc9701f4b60d8765487b
}
