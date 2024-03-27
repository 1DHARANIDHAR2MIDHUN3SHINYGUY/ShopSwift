package com.example;

import java.util.List;


//import org.hibernate.query.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import org.springframework.stereotype.Service;

@Service
public class Serve_cls {
	@Autowired
	Repo r;
	public List<Model> Ascending()
	{
		return r.findAll(Sort.by(Sort.Direction.ASC,"price"));
	}
	public List<Model> Descending(){
		return r.findAll(Sort.by(Sort.Direction.DESC,"price"));
	}
	public Page<Model> Pagination(int page,int size)
	{
		PageRequest pr = PageRequest.of(page, size);
		return r.findAll(pr);
	}
	public String add(Model m)
	{
		r.save(m);
		return "Saved";
	}
	public List<Model> get()
	{
		return r.findAll();
	}
	public List<Model> findAllWithTotal()
	{
		List<Model> product=r.findAllWithTotal();
		product.forEach(Model::gettotal);
		return product;
		
	}
}