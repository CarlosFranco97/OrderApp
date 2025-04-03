package com.example.OrderApp.controllers;

import com.example.OrderApp.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("address")
public class AddressController {
    @Autowired
    AddressService service;


}
