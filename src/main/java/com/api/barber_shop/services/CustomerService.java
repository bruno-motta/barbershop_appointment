package com.api.barber_shop.services;

import com.api.barber_shop.dtos.CustomerRequestDto;
import com.api.barber_shop.dtos.CustomerResponseDto;
import com.api.barber_shop.entities.CustomerEntity;
import com.api.barber_shop.mappers.CustomerMapper;
import com.api.barber_shop.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;


@RequiredArgsConstructor
@Service
public class CustomerService {

     private final CustomerRepository customerRepository;

    public CustomerResponseDto saveCustomer(CustomerRequestDto customerRequest){
        if(customerRepository.findByEmailCustomer(customerRequest.emailCustomer()).isPresent()){
            throw new RuntimeException("E-mail já cadastrado, tente outro!");
        }

        if(customerRepository.findByTelephoneCustomer(customerRequest.telephoneCustomer()).isPresent()){
            throw new RuntimeException("Telefone já cadastro, tente outro!");
        }

        CustomerEntity entity = CustomerMapper.toEntity(customerRequest);
        entity.setDateTimeResgistration(LocalDateTime.now());
        CustomerEntity saveCustomer = customerRepository.save(entity);

        return CustomerMapper.toResponse(saveCustomer);
    }

    public CustomerResponseDto searchCustomerId(UUID id){
        CustomerEntity searchId = customerRepository.findById(id).orElseThrow(
                () -> new RuntimeException("ID não encontrado")
        );

        return CustomerMapper.toResponse(searchId);
    }

    public CustomerResponseDto searchCustomerEmail(String email){
        CustomerEntity getEmail = customerRepository.findByEmailCustomer(email).orElseThrow(
                () -> new RuntimeException("E-mail não encontrado.")
        );

        return CustomerMapper.toResponse(getEmail);
    }

    public CustomerResponseDto searchCustomerTelephone(String telephone){
        CustomerEntity getTelephone = customerRepository.findByTelephoneCustomer(telephone).orElseThrow(
                () -> new RuntimeException("Telefone já cadastrado.")
        );

        return CustomerMapper.toResponse(getTelephone);
    }


    public CustomerResponseDto updateCustomer(UUID id, CustomerRequestDto customerRequest){
        CustomerEntity entity = customerRepository.findById(id).orElseThrow(
                () -> new RuntimeException("ID não encontrado.")
        );

        Optional<CustomerEntity> existingEmail = customerRepository.findByEmailCustomer(customerRequest.emailCustomer());
        if (existingEmail.isPresent() && !existingEmail.get().getId().equals(id)){
            throw new RuntimeException("E-mail já cadastrado.");
        }

        Optional<CustomerEntity> existingTelephone = customerRepository.findByTelephoneCustomer(customerRequest.telephoneCustomer());
        if(existingTelephone.isPresent() && !existingTelephone.get().getId().equals(id)){
            throw new RuntimeException("Telefone já cadastrado");
        }

        entity.setNameCustomer(customerRequest.nameCustomer());
        entity.setEmailCustomer(customerRequest.emailCustomer());
        entity.setTelephoneCustomer(customerRequest.telephoneCustomer());

        CustomerEntity update = customerRepository.save(entity);
        return CustomerMapper.toResponse(update);

    }

    public void deteleCustomer(UUID id){
        CustomerEntity deleteEntity = customerRepository.findById(id).orElseThrow(
                () -> new RuntimeException("ID não encontrado, não foi possivél deletar o usuario!")
        );
        customerRepository.deleteById(id);
    }






}
