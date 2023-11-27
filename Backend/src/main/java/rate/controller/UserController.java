package rate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rate.exception.RateAppException;
import rate.model.User;
import rate.service.UserService;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable Integer id){
        try{
            User user = userService.get(id);
            return new ResponseEntity<User>(user, HttpStatus.OK);
        }catch (NoSuchElementException e){
            String message=RateAppException.noSuchElement("id",id);
            return new ResponseEntity<String>(message,HttpStatus.NOT_FOUND);
        }
    }
}
