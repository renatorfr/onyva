package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by renatorfr on 07/09/15.
 */

@Controller
public class GreetingController {

    @Autowired
    GreetingRepository repository;

    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value = "name", required = false, defaultValue = "World") String name, Model model) {
        int amount = 5;

        saveGreetings(amount);
        Greeting greeting = repository.findOne((long) Math.ceil(Math.random() * amount));

        model.addAttribute("name", greeting.getContent());
        return "greeting";
    }

    private void saveGreetings(int amount) {
        for(int i = 1; i <= amount; i++) {
            repository.save(new Greeting(i, "Bla bla " + i));
        }
    }
}
