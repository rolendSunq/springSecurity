package com.spring.security.vo;

public class Category extends BaseModelObject {
	private String name;
	private boolean customersOnly;
	
	public Category(String name, boolean customersOnly) {
		super();

		this.name = name;
		this.customersOnly = customersOnly;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the customersOnly
	 */
	public boolean isCustomersOnly() {
		return customersOnly;
	}

	@Override
	public String toString() {
		return new StringBuffer().append("Category [name=").append(name)
				.append(", customersOnly=").append(customersOnly)
				.append("]").toString();
	}
	
}
