package com.examly.springapp.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.examly.springapp.payload.ApiResponse;


import com.examly.springapp.service.RbsCustomerService;


import com.examly.springapp.payload.RbsCustomerDto;


@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api/v1/customers")
public class RbsCustomerController {
    
    @Autowired
    private RbsCustomerService customerService;
    
    @PostMapping
    public ResponseEntity<RbsCustomerDto> createCustomer(@RequestBody RbsCustomerDto customerDto){
        RbsCustomerDto createCustomerDto = this.customerService.createCustomer(customerDto);
        return new ResponseEntity<>(createCustomerDto, HttpStatus.CREATED);
        
    }
    
    @PutMapping("/{customerId}")
    public ResponseEntity<RbsCustomerDto> updateCustomer(@RequestBody RbsCustomerDto customerDto, @PathVariable Integer customerId){
        
        RbsCustomerDto updatedCustomer = this.customerService.updateCustomer(customerDto, customerId);
        return ResponseEntity.ok(updatedCustomer);
        
    }
    
    @DeleteMapping("/{customerId}")
    public ResponseEntity<ApiResponse> deleteCustomer(@PathVariable ("customerId") Integer cid){
            this.customerService.deleteCustomer(cid);
            return new ResponseEntity<ApiResponse>(new ApiResponse(), HttpStatus.OK);
    }
    
    @GetMapping("/")
    public ResponseEntity<List<RbsCustomerDto>> getAllCustomers(){
        return ResponseEntity.ok(this.customerService.getAllCustomers());
    }
    
    @GetMapping("/{customerId}")
    public ResponseEntity<RbsCustomerDto> getSingleCustomer(@PathVariable Integer customerId){
        return ResponseEntity.ok(this.customerService.getCustomerById(customerId));
    }
    
}
