package nus.iss.paf.addressform.controller;

import java.util.List;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import nus.iss.paf.addressform.model.Form;
import nus.iss.paf.addressform.repository.FormRepo;


@Controller
@RequestMapping("/")
public class AddressFormController {

    private Logger logger = LoggerFactory.getLogger(AddressFormController.class);

    @Autowired
    private FormRepo repo;

    @GetMapping("/")
    public String showForm() {
        return "index";
    }

    @PostMapping(path = "/form", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String showForm(Model model, @RequestBody MultiValueMap<String,String> payload){
    
        Form f = Form.create(payload);
        logger.info("Address created >>>>> " + f.toString());
        if (repo.getFormByEmail(f.getEmail()).isEmpty()){
            if(repo.setForms(f)){
                logger.info("Contact added to database");
            } else {
                logger.info("Contact already exists in database");  
            }
        }

        List<Form> formList = repo.getFormList();
        logger.info("Addresslist created >>> " + formList.toString());

        model.addAttribute(formList);
        return "form";
    }

}
