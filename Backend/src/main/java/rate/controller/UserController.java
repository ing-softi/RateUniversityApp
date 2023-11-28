package rate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import rate.dto.UserDto;
import rate.exception.RateAppException;
import rate.model.User;
import rate.service.UserService;

import javax.validation.Valid;
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


    @PostMapping()
    public ResponseEntity<?> save(@RequestBody User user){
        try{
            user=userService.save(user);
            return new ResponseEntity<String>("You have successfully registered. Welcome to our community!",HttpStatus.CREATED);
        }
        catch (RuntimeException e){
            String message=RateAppException.alreadyRegistered("email",user.getEmail());
            return new ResponseEntity<String>(message,HttpStatus.BAD_REQUEST);
        }
      }





    //Test:
    @PostMapping("/u")
    ResponseEntity<String> addUser(@Valid @RequestBody UserDto userDto) {
        // persisting the user
        return ResponseEntity.ok("User is valid");
    }

}
