package com.assignment.metadataapi.utility;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
public class EmailAddressValidatorTest {
    private MockMvc mockMvc;

    @Mock
    EmailAddressValidator emailAddressValidator;

    @Before
    public void setUp(){
        mockMvc = MockMvcBuilders.standaloneSetup(emailAddressValidator).build();
    }

    @Test
    public void testUsingStrictRegex() {
        String emailAddress = "username@domain.com";
        String regexPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        assertTrue(EmailAddressValidator.validateEmailAddress(emailAddress));
    }
}
