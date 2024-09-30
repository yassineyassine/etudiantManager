package net.youssfi.observabilityspringgrafana.controller;


import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import net.youssfi.observabilityspringgrafana.entities.Etudiant;
import net.youssfi.observabilityspringgrafana.repository.EtudiantRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;



@SpringBootTest
@AutoConfigureMockMvc
public class EtudiantControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EtudiantRepository mesEtudiantService;

    @Test
    void testCreateNewTajilProduct() {

    }

    @Test
    void testDeleteTajilProductById() {

    }

    @SuppressWarnings("null")
    @Test
    void testGetAllEtudiants() throws Exception {
        //Inisiator Data
        UUID id = UUID.randomUUID();
        Etudiant tajilProducts =
                new Etudiant(1L, "yassine", "kharroubi", "ya@gmail.com", 1000);
        List<Etudiant> productList = Arrays.asList(tajilProducts);

        // Set expectations on the mock service
        when(mesEtudiantService.findAll()).thenReturn(productList);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/etudiants")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value("1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("yassine"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].lastname").value("kharroubi"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].email").value("ya@gmail.com"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].cin").value(1000));
    }

    @Test
    void testGetTajilProductById() {

    }

    @Test
    void testUpdateTajilProductById() {

    }
}

