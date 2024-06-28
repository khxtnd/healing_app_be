package khTeam.healing_be;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ContactServiceImpl implements ContactService{
    @Autowired
    private ContactRepository contactRepository;

    @Override
    public List<Contact> findAll() {
        return (List<Contact>)
                contactRepository.findAll();
    }
}
