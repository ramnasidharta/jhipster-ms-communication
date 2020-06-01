package com.leaf.server.web.rest;

import com.leaf.server.ServerApp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
/**
 * Test class for the HelloServerResource REST controller.
 *
 * @see HelloServerResource
 */
@SpringBootTest(classes = ServerApp.class)
public class HelloServerResourceIT {

    private MockMvc restMockMvc;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        HelloServerResource helloServerResource = new HelloServerResource();
        restMockMvc = MockMvcBuilders
            .standaloneSetup(helloServerResource)
            .build();
    }

    /**
     * Test hiClient
     */
    @Test
    public void testHiClient() throws Exception {
        restMockMvc.perform(get("/api/hello-server/hi-client"))
            .andExpect(status().isOk());
    }
}
