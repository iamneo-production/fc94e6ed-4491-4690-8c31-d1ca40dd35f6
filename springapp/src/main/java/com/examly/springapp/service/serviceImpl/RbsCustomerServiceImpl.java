package com.examly.springapp.service.serviceImpl;


import com.examly.springapp.service.RbsCustomerService;
import com.examly.springapp.repository.RbsCustomerRepository;


import org.springframework.beans.factory.annotation.Autowired;


import com.examly.springapp.exception.ResourceNotFoundException;


import com.examly.springapp.model.RbsCustomer;


import com.examly.springapp.payload.RbsCustomerDto;
import java.util.List;
import java.util.stream.Collectors;


import org.springframework.stereotype.Service;


@Service
public class RbsCustomerServiceImpl implements RbsCustomerService{


    @Autowired
    private RbsCustomerRepository customerRepo;
    
    


    @Override
    public RbsCustomerDto createCustomer(RbsCustomerDto customerDto) {
        RbsCustomer customer = this.dtoToCustomer(customerDto);
        RbsCustomer savedCustomer = this.customerRepo.save(customer);
        return this.customerToDto(savedCustomer);
    }


    @Override
    public RbsCustomerDto updateCustomer(RbsCustomerDto customerDto, Integer customerId) {
        RbsCustomer customer = this.customerRepo.findById(customerId).orElseThrow(()-> new ResourceNotFoundException("Customer", "Id", customerId));
        customer.setName(customerDto.getName());
        customer.setEmail(customerDto.getEmail());
        customer.setPhone(customerDto.getPhone());
        
        RbsCustomer updatedCustomer = this.customerRepo.save(customer);
        return this.customerToDto(updatedCustomer);
    }


    @Override
    public RbsCustomerDto getCustomerById(Integer customerId) {
        RbsCustomer customer = this.customerRepo.findById(customerId).orElseThrow(()-> new ResourceNotFoundException("Customer", "Id", customerId));
        return this.customerToDto(customer);
    }


    @Override
    public List<RbsCustomerDto> getAllCustomers() {
        List<RbsCustomer> customers = this.customerRepo.findAll();
        return customers.stream().map(this::customerToDto).collect(Collectors.toList());
    }


    @Override
    public void deleteCustomer(Integer customerId) {
        RbsCustomer customer = this.customerRepo.findById(customerId).orElseThrow(()-> new ResourceNotFoundException("Customer", "Id", customerId));
        this.customerRepo.delete(customer);
        
    }
    
    
    private RbsCustomer dtoToCustomer(RbsCustomerDto customerDto) {
        RbsCustomer customer = new RbsCustomer();
        customer.setCustomerId(customerDto.getCustomerId());
        customer.setName(customerDto.getName());
        customer.setEmail(customerDto.getEmail());
        customer.setPhone(customerDto.getPhone());
        // Set other properties as needed
        return customer;
    }


    private RbsCustomerDto customerToDto(RbsCustomer customer) {
        RbsCustomerDto customerDto = new RbsCustomerDto();
        customerDto.setCustomerId(customer.getCustomerId());
        customerDto.setName(customer.getName());
        customerDto.setEmail(customer.getEmail());
        customerDto.setPhone(customer.getPhone());
        // Set other properties as needed
        return customerDto;
    }


    
}
