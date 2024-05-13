package visite.project.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.web.client.RestTemplate;
import visite.project.dto.LaboratoireDTO;
import visite.project.jwt.request.AuthenticationRequest;
import visite.project.jwt.response.AuthenticationResponse;
import visite.project.repository.LaboratoireRepository;
import visite.project.service.LaboratoireService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class LaboratoireControllerTest {


    //@LocalServerPort
    private static int port=8088;

    @Autowired
    private LaboratoireRepository laboratoireRepository;

    @Autowired
    private LaboratoireService laboratoireService;

    private static HttpHeaders headers;
    @Autowired
    private TestRestTemplate restTemplate;
    private final ObjectMapper objectMapper = new ObjectMapper();
    @BeforeAll
    public static void init() {
        headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<AuthenticationRequest> request = new HttpEntity<>(new AuthenticationRequest("adil333@gmail.com", "ADIL123456"), headers);
        ResponseEntity<AuthenticationResponse> response = restTemplate.postForEntity("http://localhost:"+ port +"/api/v1/auth/authenticate", request, AuthenticationResponse.class);
        headers.setBearerAuth(response.getBody().getAccessToken());
    }
    private String createURLWithPort() {
        return "http://localhost:" + port + "/api/laboratoire";
    }

    @Test
    @Sql(statements = "INSERT INTO laboratoire(id, nom) VALUES (9999, 'Lab1')", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(statements = "DELETE FROM laboratoire WHERE id=9999", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void testLaboratoirList() {
        HttpEntity<String> entity = new HttpEntity<>(null, headers);

        ResponseEntity<List<LaboratoireDTO>> response = restTemplate.exchange(
                createURLWithPort()+ "/findall", HttpMethod.GET, entity, new ParameterizedTypeReference<>() {
                });
        System.out.println("logging this to see the output "+response.getBody());
        List<LaboratoireDTO> orderList = response.getBody();
        assert orderList != null;
        assertEquals(response.getStatusCodeValue(), 200);
        assertEquals(orderList.size(), laboratoireService.findAll().size());
        assertEquals(orderList.size(), laboratoireRepository.findAll().size());

    }

    @Test
    @Sql(scripts = "/sql/cleanup.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void creatLaboTest() throws Exception {
        LaboratoireDTO laboratoireDTO = new LaboratoireDTO();
        laboratoireDTO.setNom("Lab1");
        laboratoireDTO.setId(9999L);
        laboratoireDTO.setEmail("labo@gmail.com");
        HttpEntity<String> entity = new HttpEntity<>(objectMapper.writeValueAsString(laboratoireDTO), headers);
        ResponseEntity<LaboratoireDTO> response = restTemplate.exchange(
                createURLWithPort() + "/create", HttpMethod.POST, entity, LaboratoireDTO.class);
        LaboratoireDTO laboratoireDTO1 = response.getBody();
        assert laboratoireDTO1 != null;
        assertEquals(response.getStatusCodeValue(), 200);
        assertEquals(laboratoireDTO1.getNom(), laboratoireDTO.getNom());
        assertEquals(laboratoireDTO1.getEmail(), laboratoireDTO.getEmail());
    }

}
