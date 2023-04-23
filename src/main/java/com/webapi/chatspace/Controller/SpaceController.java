package com.webapi.chatspace.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.webapi.chatspace.Model.Space;
import com.webapi.chatspace.Service.SequenceGeneratorService;
import com.webapi.chatspace.Service.SpaceService;

@RestController
public class SpaceController {
    @Autowired
    SpaceService spaceService;

    @Autowired
    SequenceGeneratorService sequenceGeneratorService;
    
    @GetMapping("spaces")
    public List<Space> getAllUsers(){
        return spaceService.getAllSpaces();
    }

    @GetMapping("space/{id}")
    public Space getUserById(@PathVariable long id){
        return spaceService.getSpaceById(id);
    }
    
    @PostMapping("/space")
    public Space postUser(@RequestBody Space space){
        space.setId(sequenceGeneratorService.generateSequence(Space.SEQUENCE_NAME));
        return spaceService.saveSpace((space));
    }
    

}
