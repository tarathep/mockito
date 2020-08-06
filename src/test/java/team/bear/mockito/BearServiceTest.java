package team.bear.mockito;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BearServiceTest {
    @Mock
    BearRepository bearRepository;

    @InjectMocks
    BearService bearService;

    @Test
    void testItShouldReturnRoarFromBear(){
        //init mock
        List<Bear> bears = new ArrayList<>();
        Bear bear = new Bear();
        bear.setName("kie");
        bear.setRoar("Wowww");
        bears.add(bear);

        when(bearRepository.findByName("kie")).thenReturn(bears);


        //test
        List<Bear> actual = bearService.findBearByName("kie");
        assertEquals("Wowww",actual.get(0).getRoar());

        verify(bearRepository,times(1)).findByName("kie");
    }

    @Test
    void testItShouldAddBear(){
        //init mock
        Bear bear = new Bear();
        bear.setName("kie");
        bear.setRoar("Wowww");

        when(bearRepository.save(bear)).thenReturn(bear);


        //test
        Bear actual = bearService.addBear(bear);
        assertEquals("Wowww",actual.getRoar());

        verify(bearRepository,times(1)).save(bear);
    }



}
