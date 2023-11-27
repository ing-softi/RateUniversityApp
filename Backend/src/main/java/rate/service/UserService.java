package rate.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rate.exception.RateAppException;
import rate.model.User;
import rate.repository.UserRepo;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public User get (Integer id){
        Optional<User> user=userRepo.findById(id);
        if(user.isPresent())
            return user.get();
        else throw new NoSuchElementException();
    }

}
