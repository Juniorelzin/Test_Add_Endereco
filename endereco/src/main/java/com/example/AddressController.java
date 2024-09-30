package com.example;

public class AddressController {
    private AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    public Address getAddress(String cep) {
        return addressService.getAddressByCep(cep);
    }
}
