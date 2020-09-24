package arcmop.blog.springbootest.configuracion.controladores;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class ControladorHolaMundo {

    @Autowired
    private SimpleDao simpleDao;

    @RequestMapping(value = "/sumar/{sum01}/{sum02}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Map saludar(@PathVariable("sum01") Integer sum01, @PathVariable("sum02") Integer sum02) {
        
        simpleDao.save(new Simple(Long.MIN_VALUE, sum01, sum02, sum01 + sum02));
        
        return Collections.singletonMap("resultado", String.valueOf(sum01 + sum02));
    }

    @GetMapping("/sumas")
    public List<Simple> retrieveAllStudents() {
        return simpleDao.findAll();
    }
    
}
