import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.Address;
import com.example.AddressController;
import com.example.AddressService;


public class AddressControllerTest {

    private AddressService addressService;
    private AddressController addressController;

    @BeforeEach
    public void setUp() {
    
        addressService = Mockito.mock(AddressService.class);
    
        addressController = new AddressController(addressService);
    }

    @Test
    public void testGetAddress_ValidCep() {
     
        Address mockAddress = new Address("Rua Exemplo", "Cidade Exemplo", "Estado Exemplo");
        when(addressService.getAddressByCep("12345678")).thenReturn(mockAddress);

 
        Address address = addressController.getAddress("12345678");

  
        verify(addressService).getAddressByCep("12345678");


        assertNotNull(address);
        assertEquals("Rua Exemplo", address.getStreet());
        assertEquals("Cidade Exemplo", address.getCity());
        assertEquals("Estado Exemplo", address.getState());
    }

    @Test
    public void testGetAddress_InvalidCep() {
  
        when(addressService.getAddressByCep("00000000")).thenReturn(null);

        Address address = addressController.getAddress("00000000");

   
        verify(addressService).getAddressByCep("00000000");

        assertNull(address);
    }
}

