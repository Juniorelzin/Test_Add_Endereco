package com.example;

public class AddressServiceImpl implements AddressService {
    // Simulação de um serviço externo (aqui poderia ser uma chamada HTTP)
    @Override
    public Address getAddressByCep(String cep) {
        // Em um caso real, você faria uma chamada para um serviço externo aqui
        // Vamos simular um retorno para um CEP específico
        if ("12345678".equals(cep)) {
            return new Address("Rua Exemplo", "Cidade Exemplo", "Estado Exemplo");
        }
        return null; // ou lançar uma exceção
    }
}
