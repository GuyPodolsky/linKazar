package com.guyp.linKazar.controller;

import com.guyp.linKazar.model.User;
import com.guyp.linKazar.model.UserClickOut;
import com.guyp.linKazar.repository.UserClickRepository;
import com.guyp.linKazar.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.StreamUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.data.util.StreamUtils.createStreamFromIterator;


@RestController
@RequestMapping("/api/")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserClickRepository userClickRepository;

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public ResponseEntity<?> createUser(@RequestParam String name) {
        if(userRepository.findFirstByName(name)==null){
            User user = User.UserBuilder.anUser().withName(name).build();
            user = userRepository.insert(user);
            return new ResponseEntity<>(user.toString(), HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("User with the name: " + name + " is already exists!", HttpStatus.BAD_REQUEST);
        }

    }

    @RequestMapping(value = "/user/{name}", method = RequestMethod.GET)
    public User getUser(@RequestParam String name) {
        User user = userRepository.findFirstByName(name);
        return user;
    }

    @RequestMapping(value = "/user/{name}/clicks", method = RequestMethod.GET)
    public List<UserClickOut> getUserClicks(@RequestParam String name) {
        List<UserClickOut> userClicks = StreamUtils.createStreamFromIterator(userClickRepository.findByUserName(name).iterator())
                .map(userClick -> UserClickOut.of(userClick))
                .collect(Collectors.toList());
        return userClicks;
    }

}
