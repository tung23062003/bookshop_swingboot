package com.group7.bookshopwebsite.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class AdminController {

	@GetMapping("/admin/home")
	public String viewHomePage(Model model) {
		return "admin/index";
	}

	@GetMapping("/admin/users")
	public String viewUserPage(Model model) {
		return "admin/user";
	}

	@GetMapping("/admin/categories")
	public String viewCategoryPage(Model model) {
		return "admin/category";
	}

	@GetMapping("/admin/add-or-update-category")
	public String viewAddOrUpdatePage(Model model) {
		return "admin/category_add_or_update";
	}

	@GetMapping("/admin/books")
	public String viewBookPage(Model model) {
		return "admin/books";
	}

	@GetMapping("/admin/add-or-update-book")
	public String viewAddOrUpdateBook(Model model) {
		return "admin/books_add_or_update";
	}

	@GetMapping("/admin/orders")
	public String viewOrder(Model model) {
		return "admin/order";
	}

	@GetMapping("/admin/order-detail")
	public String viewOrderDetail(Model model) {
		return "admin/order_detail";
	}

	@GetMapping("/admin/contacts")
	public String viewContacts(Model model) {
		return "admin/contacts";
	}
	
	@GetMapping("/admin/contacts-response")
	public String viewContactsResponse(Model model) {
		return "admin/contact_response";
	}

	@GetMapping("/admin/statistics")
	public String viewStatistics(Model model) {
		return "admin/statistics";
	}

}
