package com.calTracker.cal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
// Allow cross origin from localhost:3000 and localhost:4200
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:4200"})
public class controller {

    @Autowired
    private UsersRepository usersRepository;

    
    // A get request to / will return "Hello World"
    @GetMapping("/")
    public String helloWorld() {
        return "Hello World";
    }

    @RequestMapping(value="/validate/", method=RequestMethod.POST)
    // A post request to /validate will validate the user's login credentials EMAIL and PASSWORD
    public ResponseEntity<LoginRequest> validate(@RequestBody LoginRequest loginRequest) {
        // Print emaill and password to console
        String email = loginRequest.getEmail();
        String password = loginRequest.getPassword();

        Users user = usersRepository.findByEmail(email);

        String userPass = user.getPassword();

        if(userPass.equals(password))
            return ResponseEntity.ok(loginRequest);
        else
            return ResponseEntity.badRequest().build();

        
    }
    
    
    
}
