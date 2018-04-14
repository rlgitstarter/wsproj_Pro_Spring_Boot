import com.apress.spring.domain_model.Journal;
import com.apress.spring.repository.JournalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/* @Controller, which is a marker for the Spring MVC engine so this class is treated as web controller.*/
@Controller
public class JournalController {
    /* The @Autowired annotation will instantiate the JournalRepository variable repo, so it can be used
    in the index method.*/
    @Autowired
    JournalRepository repo;

    /* For Use as a Service */
    @RequestMapping(value="/journal", produces = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody
    List<Journal> getJournal(){
        return repo.findAll();
    }

    /*  @RequestMapping annotation: Makes this method the handler for every request in the default route /. */
    @RequestMapping("/")
    /* There is a Model class parameter that will be created, and it will add an attribute named journal
    with a value that is the result of calling the JournalRepository interface, repo.findAll() method.*/
    public String index(Model model) {
        model.addAttribute("journal", repo.findAll());
        return "index";
    }
}
