package khTeam.healing_be.service.impl;

import khTeam.healing_be.entity.ContactEntity;
import khTeam.healing_be.repository.ContactRepository;
import khTeam.healing_be.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Override
    public List<ContactEntity> findAll() {
        return contactRepository.findAll();
    }
}
