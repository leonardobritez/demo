package com.example.demo.service;

import com.example.demo.entity.Phone;
import com.example.demo.entity.User;
import com.example.demo.repositoriy.PhoneRepository;

public class PhoneServiseImpl implements PhoneService {


    private PhoneRepository phoneRepository;


    @Override
    public Iterable<Phone> listAllPhones() {
        return phoneRepository.findAll();
    }

    @Override
    public Phone getPhoneById(Integer id) {
        return phoneRepository.findById(Long.valueOf(id)).get();
    }

    @Override
    public Phone savePhone(Phone phone) {
        return phoneRepository.save(phone);
    }

    @Override
    public void deletePhone(Integer id) {
        phoneRepository.deleteById(Long.valueOf(id));
    }


}
