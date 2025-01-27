﻿# ![image](https://user-images.githubusercontent.com/57352037/155895117-523cfb9e-d895-47bf-a962-2bcdda49ad66.png) Java plugin

Official shurjoPay Java plugin for merchants or service providers to connect with [**_shurjoPay_**](https://shurjopay.com.bd) Payment Gateway ``` v2.1 ``` developed and maintained by [_**ShurjoMukhi Limited**_](https://shurjomukhi.com.bd).

This plugin can be used with any java application or framework (e.g. Spring).
Also it makes easy for developers to integrate with shurjoPay ``` v2.1 ``` with calling three methods only:

1. **makePayment**: create and send payment request
1. **verifyPayment**: verify payment status at shurjoPay
1. **paymentStatus**: Check payment details and status

Also reduces many of the things that you had to do manually:

- Handles http requests and errors.
- JSON serialization and deserialization.
- Authentication during initiating and verifying of payments.
## Audience
This document is intended for the technical personnel of merchants and service providers who wants to integrate our online payment gateway using java plugin provided by _**shurjoMukhi Limited**_.
# How to use this shurjoPay plugin
To integrate the shurjoPay Payment Gateway in your Java project do the following tasks sequentially.
#### Step 1: Add dependency into your java or spring project
**Maven**
```xml
<dependency>
    <groupId>bd.com.shurjomukhi</groupId>
    <artifactId>sp-plugin-java</artifactId>
    <version>0.1.0</version>
</dependency>
```
**Gradle**
```gradle
implementation 'bd.com.shurjomukhi:sp-plugin-java:0.1.0'
```
**Download Jar**<br>
Go to [Maven central](https://central.sonatype.dev/artifact/bd.com.shurjomukhi/sp-plugin-java/0.1.0/overview) and download the latest version.<br>

> _Attention:_ shurjoMukhi offers [separate plugin](https://github.com/shurjopay-plugins/sp-plugin-spring) to integrate with any _Spring Application_.

#### Step 2: Create shurjopay.properties inside project resource path.
Properties file contains four fields ```SP_USER, SP_PASS, SHURJOPAY_API, SP_CALLBACK``` to configure shurjoPay. Configure logging using these params ```  SPLOG_PATH, SPLOG_FILE. ```
```properties
#merchant username and password provided by shurjoPay author
SP_USER = <merchant_username>
SP_PASS = <merchant_password>

#shurjoPay API's base path for sandbox
SHURJOPAY_API = https://sandbox.shurjopayment.com/api

#callback URL is used for cancel payment or success payment
SP_CALLBACK = https://sandbox.shurjopayment.com/response

#shurjoPay plug-in log file location
SPLOG_PATH= /var/log
SPLOG_FILE = sp-java-plugin.log
```
- See and copy this ready [_shurjopay.properties_](https://github.com/shurjopay-plugins/sp-plugin-java/blob/main/src/test/resources/shurjopay.properties.sample).
- Add ```logback-classic``` dependency in your application to get log messages generated by this plugin to track shurjoPay errors only (optional).

#### Step 3: After that, you can initiate payment request to shurjoPay using below code example.
 ```java 
	// Initialize shurjopay
	Shurjopay shurjopay = new Shurjopay();

	// Prepare payment request to initiate payment
	PaymentReq request = new PaymentReq();
	request.setPrefix("sp");
	request.setAmount(10.00);
	request.setCustomerOrderId("sp315689");
	request.setCurrency("BDT");
	request.setCustomerName("Dummy");
	request.setCustomerAddress("Dhaka");
	request.setCustomerPhone("01766666666");
	request.setCustomerCity("Dhaka");
	request.setCustomerPostCode("1212");
	request.setCustomerEmail("dummy@gmail.com");

	// Calls first method to initiate a payment
	shurjopay.makePayment(request);
 ```
- Returns [_PaymentRes_](https://github.com/shurjopay-plugins/sp-plugin-java/blob/main/src/main/java/com/shurjomukhi/model/PaymentRes.java) corresponding this [_JSON_](https://github.com/shurjopay-plugins/sp-plugin-java/blob/main/src/test/resources/sample-msg/payment-res.json)

#### Step 4: Payment verification can be done after each transaction with shurjopay transaction id. 
 ```java
	shurjopay.verifyPayment(:=spTxnId)
 ```
- Returns [_VerifiedPayment_](https://github.com/shurjopay-plugins/sp-plugin-java/blob/main/src/main/java/com/shurjomukhi/model/VerifiedPayment.java) corresponding this [_JSON_](https://github.com/shurjopay-plugins/sp-plugin-java/blob/main/src/test/resources/sample-msg/verification-res.json)
#### Congrats! Now you are ready to use the java plugin to seamlessly integrate with shurjoPay to make your payment system easy and smooth.

# Want to see shurjoPay in action?
Run the JUnit test to see shurjopay plugin in action. These tests will run on selenium browser and will provide the complete experience. Just download source and run the command ```mvnw.cmd test``` in Windows and ```./mvnw test``` in Linux from plugin root path.
## References
1. [Spring example application](https://github.com/shurjopay-plugins/sp-plugin-usage-examples/tree/dev/spring-app-java-plugin) and [Java example application](https://github.com/shurjopay-plugins/sp-plugin-usage-examples/tree/dev/java-app-java-plugin) showing usage of the java plugin.
2. [Sample applications and projects](https://github.com/shurjopay-plugins/sp-plugin-usage-examples) in many different languages and frameworks showing shurjopay integration.
3. [shurjoPay Postman site](https://documenter.getpostman.com/view/6335853/U16dS8ig) illustrating the request and response flow using the sandbox system.
4. [shurjopay Plugins](https://github.com/shurjopay-plugins) home page on github
## License
This code is under the [MIT open source License](https://github.com/shurjopay-plugins/sp-plugin-java/blob/develop/LICENSE).
#### Please [contact](https://shurjopay.com.bd/#contacts) with shurjoPay team for more detail!
<hr>
Copyright ©️2022 shurjoMukhi Limited.
