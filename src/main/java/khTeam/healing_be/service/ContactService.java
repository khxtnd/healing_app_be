package khTeam.healing_be.service;



import khTeam.healing_be.entity.ContactEntity;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ContactService  {
    List<ContactEntity> findAll();

    ContactEntity getOne(Long id);

    void save(ContactEntity contactEntity);

    void delete(ContactEntity contactEntity);
}

