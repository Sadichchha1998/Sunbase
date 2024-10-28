package com.sunbase.model;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;

@NotEmpty(message = "first name should be not Empty and not null! ")
	@NotNull
	@JsonProperty("first_name")
	private String first_name;
 
	@NotNull
	@NotEmpty(message = "Last name should be not Empty and not null! ")
	@JsonProperty("last_name")
	private String last_name;
 
	@NotNull
	@NotEmpty(message = "Last name should be not Empty and not null!")
	private String street;
 
	@NotNull
	@NotEmpty(message = "Last name should be not Empty and not null!")
	private String address;
 
	@NotNull
	@NotEmpty(message = "Last name should be not Empty and not null!")
	private String city;
 
	@NotNull
	@NotEmpty(message = "Last name should be not Empty and not null!")
	private String state;
	@Email(message = "please write email format and not null!")
	private String email;
	@NotNull
	@NotEmpty(message = "Last name should be not Empty and not null!")
	private String phone;
}
