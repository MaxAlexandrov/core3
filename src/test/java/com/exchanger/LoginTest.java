package com.exchanger;

import com.exchanger.controller.RegistrationController;
import com.exchanger.controller.MainController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoginTest {

    @Autowired
    private MainController mainController;

    @Autowired
    private RegistrationController registrationController;

    @Test
    public void testControllers()throws Exception{
        assertThat(mainController).isNotNull();
        assertThat(registrationController).isNotNull();
    }
}
