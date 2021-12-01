package com.assignment.metadataapi.repository;

import com.assignment.metadataapi.model.Metadata;
import com.assignment.metadataapi.utility.EmailAddressValidator;
import net.minidev.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Map;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
public class MetadataDaoImplTest {
    private MockMvc mockMvc;

    @Mock
    MetadataDaoImpl metadataDao;

    @Before
    public void setUp(){
        mockMvc = MockMvcBuilders.standaloneSetup(metadataDao).build();
    }

    @Test
    public void addMetadata() throws Exception{
        Metadata metaData = new Metadata();
        metaData.setTitle("Valid App 1");
        metaData.setVersion("1.0.0");

        metadataDao.addMetadata(metaData);
        Map<String, Metadata> result = metadataDao.getAllMetadata();
        assertNotNull(result);
    }

    @Test
    public void getAllMetadata() throws Exception{

        Map<String, Metadata> result = metadataDao.getAllMetadata();
        assertNotNull(result);
    }
    @Test
    public void updateMetadata() throws Exception{
        Metadata metaData = new Metadata();
        metaData.setTitle("Valid App 1");
        metaData.setVersion("2.0.0");

        metadataDao.updateMetadata(metaData);
        Map<String, Metadata> result = metadataDao.getAllMetadata();
        assertNotNull(result);
    }
    @Test
    public void deleteMetadata() throws Exception{

        metadataDao.deleteMetadata("Valid App 1");
        Metadata result = metadataDao.getMetadata("Valid App 1");
        assertNull(result);
    }
}
