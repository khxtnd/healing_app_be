package khTeam.healing_be.controller;


import java.util.List;

import jakarta.validation.Valid;
import khTeam.healing_be.entity.ContactEntity;
import khTeam.healing_be.service.ContactService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
@RequestMapping("/api")
public class RestApiController {
    public static Logger logger = LoggerFactory.getLogger(RestApiController.class);

    @Autowired
    private ContactService contactService;

    @RequestMapping(value = "/contact/", method = RequestMethod.GET)
    public ResponseEntity<List<ContactEntity>> listAllContact(){
        List<ContactEntity> listContact= contactService.findAll();
        if(listContact.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<ContactEntity>>(listContact, HttpStatus.OK);
    }

    @RequestMapping(value = "/contact/{id}", method = RequestMethod.GET)
    public ContactEntity findContact(@PathVariable("id") long id) {
        ContactEntity contact= contactService.getOne(id);
        if(contact == null) {
            ResponseEntity.notFound().build();
        }
        return contact;
    }

    @RequestMapping(value = "/contact/t", method = RequestMethod.POST)
    public ResponseEntity<ContactEntity> saveContact(@Valid @RequestBody ContactEntity contact) {
         contactService.save(contact);
        return ResponseEntity.ok().build();

    }

//    @RequestMapping(value = "/contact/", method = RequestMethod.PUT)
//    public ResponseEntity<ContactEntity> updateContact(@PathVariable(value = "id") Long contactId,
//                                                 @Valid @RequestBody ContactEntity contactForm) {
//        ContactEntity contact = contactService.getOne(contactId);
//        if(contact == null) {
//            return ResponseEntity.notFound().build();
//        }
//        contact.setName(contactForm.getName());
//        contact.setAge(contactForm.getAge());
//
//        void updatedContact = contactService.save(contact);
//        return ResponseEntity.ok(updatedContact);
//    }

    @RequestMapping(value = "/contact/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<ContactEntity> deleteContact(@PathVariable(value = "id") Long id) {
        ContactEntity contact = contactService.getOne(id);
        if(contact == null) {
            return ResponseEntity.notFound().build();
        }

        contactService.delete(contact);
        return ResponseEntity.ok().build();
    }
}


