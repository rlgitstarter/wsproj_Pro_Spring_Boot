package com.habuma.contacts.web;

import com.habuma.contacts.domain_model.Contact;
import com.habuma.contacts.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/")
public class ContactController {

    private ContactRepository contactRepo;

    // Constructor
    @Autowired
    public ContactController(ContactRepository contactRepo) {
        this.contactRepo = contactRepo;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String home(Map<String,Object> model) {
        List<Contact> contacts = contactRepo.findAll();
        model.put("contacts", contacts);
        return "home";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String submit(Contact contact) {
        contactRepo.save(contact);
        return "redirect:/";
    }
}
