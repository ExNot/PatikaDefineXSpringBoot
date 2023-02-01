package com.example.enesbaskale;

import com.example.enesbaskale.data.entity.EmployeeEntity;
import com.example.enesbaskale.data.repository.EmployeeRepository;
import com.example.enesbaskale.test.TestCrud;
import io.jsonwebtoken.lang.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PatikaDefineXSpringBootApplicationTests implements TestCrud {

    @Autowired
    EmployeeRepository employeeRepository;




/*    @Test
    void contextLoads() { ?????????????
    }*/

    //CREATE Test
    @Test
    @Override
    public void testCreate() {
        EmployeeEntity employeeEntity = EmployeeEntity
                .builder()
                .firstName("Enes Test")
                .lastName("Baskale Test")
                .emailId("enesbaskale@gmail.com")
                .build();
        employeeRepository.save(employeeEntity);

        //nesne null ise assertionError hatası göndersin
        //1.Kayda göre verileri getir.
        assertNotNull(employeeRepository.findById(1L).get());
    }

    //LIST TEST
    @Test
    @Override
    public void testList() {
        List<EmployeeEntity> list = (List<EmployeeEntity>) employeeRepository.findAll(); /// CAST yapmadan devam etti hata almadı

        //eğer 0dan büyükse liste vardır
        assertThat(list).size().isGreaterThan(0);
    }

    //FindById Test
    @Test
    @Override
    public void testFindById() {

        EmployeeEntity employeeEntity = employeeRepository.findById(1L).get();

        //Enes test adında kayıt var mı yok mu?
        assertEquals("Enes Test", employeeEntity.getFirstName());

    }

    //Update Test
    @Test
    @Override
    public void testUpdate() {

        EmployeeEntity employeeEntity = employeeRepository.findById(1L).get();
        employeeEntity.setFirstName("Enes 78 Test");
        employeeRepository.save(employeeEntity);

        //Eşit değilse bir sorun olmayacak ama eşitse exception fırlatsın
        assertNotEquals("Enes Test", employeeRepository.findById(1L).get().getFirstName());

    }


    //Delete
    @Test
    @Override
    public void testDelete() {

        employeeRepository.deleteById(1L);

        //isFalse
        assertThat(employeeRepository.existsById(1L)).isFalse();

    }
}
