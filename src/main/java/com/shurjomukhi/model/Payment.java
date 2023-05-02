package com.shurjomukhi.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;

/**
 * Shurjopay payment information to make a payment
 *
 * @author Al - Amin
 * @since 2022-12-05
 */
@Data @Accessors(chain = true)
@SuperBuilder
@AllArgsConstructor @NoArgsConstructor
public class Payment{

	/** Client IP from where shurjoPay payment is initiated. */
	@JsonProperty("client_ip")
	@Builder.Default
	protected String clientIp = "127.0.0.1";
	
	/** Payment amount in currency. shurjoPay supports only BDT and USD. */
	protected String currency;
	
	/** ShurjoPay's status message. */
	protected String message;
	
	/** Customer defined order id. */
	@JsonProperty("order_id")
	@JsonAlias("customer_order_id")
	private String customerOrderId;

	/** Customer's full name who want to pay by shurjoPay. */
	@JsonProperty("customer_name")
	@JsonAlias("name")
	protected String customerName;

	/** Customer's address. */
	@JsonProperty("customer_address")
	@JsonAlias("address")
	protected String customerAddress;

	/** Customer's contact number. */
	@JsonProperty("customer_phone")
	protected String customerPhone;

	/** Customer's city where he/she lives in. */
	@JsonProperty("customer_city")
	@JsonAlias("city")
	protected String customerCity;
	
	/** Customer's valid email address. */
	@JsonProperty("customer_email")
	@JsonAlias("email")
	protected String customerEmail;
		
	/** Shipping address for E-commerce shipping transaction. */
	@JsonProperty("shipping_address")
	protected String shippingAddress;
	
	/** Shipping city for E-commerce shipping transaction. */
	@JsonProperty("shipping_city")
	protected String shippingCity;
	
	/** Shipping country for E-commerce shipping transaction. */
	@JsonProperty("shipping_country")
	protected String shippingCountry;
	
	/** Name of the person who will be received E-commerce shipping product. */
	@JsonProperty("received_person_name")
	protected String shippingReceiverName;
	
	/** Contact number of the person who will be received E-commerce shipping product. */
	@JsonProperty("shipping_phone_number")
	protected String shippingPhone;
}
