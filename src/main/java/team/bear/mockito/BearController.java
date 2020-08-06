package team.bear.mockito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class BearController {

    @Autowired
    BearService bearService;

    @RequestMapping(method = RequestMethod.POST,value = "/bear")
    ResponseEntity<Bear> addRoar(@RequestParam Map<String,String> query){
        String name = query.getOrDefault("name",null);
        String roar = query.getOrDefault("roar",null);
        Bear bear = new Bear();
        bear.setName(name);
        bear.setRoar(roar);
        bearService.addBear(bear);
        return ResponseEntity.ok(bear);
    }

    @RequestMapping(method = RequestMethod.GET,value = "/bear")
    ResponseEntity<List> findRoarByName(@RequestParam Map<String,String> query){
        String name = query.getOrDefault("name",null);
        return ResponseEntity.ok(bearService.findBearByName(name));
    }


}
