package org.example;

import static org.junit.Assert.assertTrue;

import org.example.service.TransactionalService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class AppTest {

    @Autowired
    TransactionalService transactionalService;

    @Test
    public void contextLoads() {
        //transactionalService.updateA();
        transactionalService.updateD();
    }

}
