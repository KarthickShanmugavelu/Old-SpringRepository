/*
 * package com.luv2code.springdemo.rest;
 * 
 * import java.util.List;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.web.bind.annotation.DeleteMapping; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.PathVariable; import
 * org.springframework.web.bind.annotation.PostMapping; import
 * org.springframework.web.bind.annotation.PutMapping; import
 * org.springframework.web.bind.annotation.RequestBody; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RestController;
 * 
 * import com.luv2code.springdemo.entity.Customer; import
 * com.luv2code.springdemo.service.CustomerService;
 * 
 * @RestController
 * 
 * @RequestMapping("/api") public class CustomerRestController {
 * 
 * @Autowired CustomerService customerService;
 * 
 * @GetMapping("/customers") public List<Customer> getCustomers() {
 * 
 * return customerService.getCustomers();
 * 
 * }
 * 
 * @GetMapping("/customers/{customerId}") public Customer
 * getCustomerById(@PathVariable int customerId) {
 * 
 * Customer customer = customerService.getCustomer(customerId);
 * 
 * if (customerId < 0 || customerId > (customerService.getCustomers().size()))
 * throw new CustomerNotFoundException(
 * "Something wrong with the request. May be the request header, body or paramater"
 * );
 * 
 * if (customer == null) throw new CustomerNotFoundException("Customer id '" +
 * customerId + "' not found");
 * 
 * return customer; }
 * 
 * // add POST mapping for adding new customer
 * 
 * @PostMapping("/customers") public Customer addcustomer(@RequestBody Customer
 * theCustomer) {
 * 
 * theCustomer.setId(0);// overwrites the id if set in req body
 * customerService.saveCustomer(theCustomer);
 * 
 * return theCustomer; }
 * 
 * // add mapping for PUT - to update existing customers
 * 
 * @PutMapping("/customers") public Customer updateCustomer(@RequestBody
 * Customer theCustomer) {
 * 
 * customerService.saveCustomer(theCustomer); return theCustomer;
 * 
 * }
 * 
 * @DeleteMapping("/customers/{customerId}") public String
 * deleteCustomer(@PathVariable int customerId) {
 * 
 * if((customerService.getCustomer(customerId))==null) throw new
 * CustomerNotFoundException("Customer id '" + customerId + "' not found");
 * 
 * customerService.deleteCustomer(customerId); return
 * "Deleted customer id "+customerId; }
 * 
 * 
 * 
 * 
 * 
 * }
 */