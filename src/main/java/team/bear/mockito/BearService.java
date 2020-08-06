package team.bear.mockito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BearService {
    @Autowired
    BearRepository bearRepository;

    Bear addBear(Bear bear){
        return bearRepository.save(bear);
    }

    List<Bear> findBearByName(String name){
        return bearRepository.findByName(name);
    }




}
