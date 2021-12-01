package com.assignment.metadataapi.controllers;

import com.assignment.metadataapi.YamlConfig;
import com.assignment.metadataapi.model.Metadata;
import com.assignment.metadataapi.repository.MetadataDaoImpl;
import net.minidev.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = YamlConfig.class)
public class MetadataControllerTest {
    @Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc;

    @Mock
    MetadataController metadataController;

    @Mock
    MetadataDaoImpl metadataDao;

    @Before
    public void setUp(){
        DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(this.wac);
        this.mockMvc = builder.build();
    }

    @Test
    public void addMetadata() throws Exception {
        MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.post("/v1/metadata")
                        .contentType("application/x-yaml")
                        .content(getMetadataInYaml());
        this.mockMvc.perform(builder)
                .andExpect(MockMvcResultMatchers.status()
                        .isCreated())
                .andDo(MockMvcResultHandlers.print());
    }
    public String getMetadataInYaml () {
        return "title: Valid App 4\n" +
                "version: 0.0.1\n" +
                "maintainers:\n" +
                "- name: firstmaintainer app1\n" +
                "  email: firstmaintainer@hotmail.com\n" +
                "- name: secondmaintainer app1\n" +
                "  email: secondmaintainer@gmail.com\n" +
                "company: Random Inc.\n" +
                "website: https://website.com\n" +
                "source: https://github.com/random/repo\n" +
                "license: Apache-2.0\n" +
                "description: |\n" +
                " ### Interesting Title\n" +
                " Some application content, and description";
    }

    @Test
    public void getAllMetadata() throws Exception {
        Map<String, Metadata> json = new HashMap<>();
        Metadata metaData = new Metadata();
        metaData.setTitle("Valid App 1");
        metaData.setVersion("1.0.0");
        json.put("Valid App 1", metaData);
        Mockito.when(metadataDao.getAllMetadata()).thenReturn(json);
        mockMvc.perform(MockMvcRequestBuilders.get("/v1/metadata"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void getMetadata() throws Exception {

        Metadata metaData = new Metadata();
        metaData.setTitle("Valid App 1");
        metaData.setVersion("1.0.0");

        Mockito.when(metadataDao.getMetadata("Valid App 1")).thenReturn(metaData);
        mockMvc.perform(MockMvcRequestBuilders.get("/v1/metadata/Valid App 1"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void deleteMetadata() throws Exception {
        Map<String, Metadata> json = new HashMap<>();
        Metadata metaData = new Metadata();
        metaData.setTitle("Valid App 1");
        metaData.setVersion("1.0.0");
        json.put("Valid App 1", metaData);

        mockMvc.perform(MockMvcRequestBuilders.get("/v1/metadata/Valid App 1"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }


    @Test
    public void updateResource() throws Exception{


        mockMvc.perform(MockMvcRequestBuilders.put("/v1/metadata")
                        .contentType("application/x-yaml")
                        .content(getMetadataInYaml()))
                .andExpect(MockMvcResultMatchers.status().isAccepted());
    }

}
