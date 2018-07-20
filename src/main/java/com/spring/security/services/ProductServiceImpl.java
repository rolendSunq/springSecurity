package com.spring.security.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.security.dao.ProductDao;
import com.spring.security.vo.Category;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductDao productDao;
	
	@Override
	public Collection<Category> getCategories() {
		// Ch 5 @PostFilter
//		return productDao.getCategories();
		// Ch 5 @PreFilter
		Collection<Category> unfilteredCategories = productDao.getCategories();
		return productDao.filterCategories(unfilteredCategories);
	}

	@Override
	public Category getCategoryByName(String name) {
		return productDao.getCategoryByName(name);
	}

}
