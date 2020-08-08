package team.bear.mockito;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BearControllerTest {

    @MockBean
    private BearService bearService;

    @BeforeEach
    void setup(){
        //init mock
        List<Bear> bears = new ArrayList<>();
        Bear bear = new Bear();
        bear.setName("kie");
        bear.setRoar("Wowww");
        bears.add(bear);

        Mockito.when(bearService.findBearByName("kie")).thenReturn(bears);
    }

    @Autowired
    private MockMvc mvc;

    @Test
    void testFindBearByNameMock() throws Exception{
        mvc.perform(MockMvcRequestBuilders.get("/bear?name=kie").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("[{\"name\":\"kie\",\"roar\":\"Wowww\"}]"));
    }

}
