package org.tony.spring.validate.form.input.example;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/****
 * Create a PersonForm object
 * @author Tony
 *
 */

/***
 * @Size(min=2, max=30) will only allow names between 2 and 30 characters long
 * @NotNull won’t allow a null value, which is what Spring MVC generates if the entry is empty
 * @Min(18) won’t allow if the age is less than 18
 *
 */
public class PersonForm {
	
	@Size(min=2,max=30)
	private String name;
	
	@NotNull
	@Min(18)
	private Integer age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "PersonForm(Name:" + this.name + ", Age:" + this.age + ")";
	}
}
