package com.example.demo.service;

import com.example.demo.entity.Phone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhoneService {

    @Autowired
    private PhoneRepository phoneRepository;

    public Phone savePhone(Phone phone) {
        return phoneRepository.save(phone);
    }

    // Otros métodos de servicio según sea necesario
}
