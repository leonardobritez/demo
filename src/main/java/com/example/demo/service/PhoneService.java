package com.example.demo.service;

import com.example.demo.entity.Phone;
import org.springframework.stereotype.Service;

@Service
public interface PhoneService {
    Iterable<Phone> listAllPhones();

    Phone getPhoneById(Integer id);

    Phone savePhone(Phone phone);

    void deletePhone(Integer id);

}
