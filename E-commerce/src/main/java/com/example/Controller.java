package com.example;

import java.util.List;

//import org.hibernate.query.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {
	@Autowired
	Serve_cls ser;
	@GetMapping("/asc")
	public List<Model> ascending()
	{
		return ser.Ascending();
	}
	@GetMapping("/des")
	public List<Model> descending()
	{
		return ser.Descending();
	}
	
	@PostMapping("/create")
	public String create(@RequestBody Model m){
		ser.add(m);
		return "added";
		
	}
	@GetMapping("/get")
	public List<Model> get()
	{
		return ser.get();
	}
	@GetMapping("/page")
	public Page<Model> getall(@RequestParam int page,@RequestParam int size)
	{
		return ser.Pagination(page,size);
	}
	@GetMapping("/total")
	public List<Model> gg()
	{
		return ser.findAllWithTotal();
	}
	
}
	