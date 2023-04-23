package com.webapi.chatspace.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webapi.chatspace.Model.Space;
import com.webapi.chatspace.Repository.SpaceRepository;

@Service
public class SpaceServiceImpl implements SpaceService {

    @Autowired
    SpaceRepository spaceRepository;

    @Override
    public Space getSpaceById(long id) {
        Optional<Space> space = spaceRepository.findById(id);
        if(space.isPresent()){
            return space.get();
        }else{
            return null;
        }
    }

    @Override
    public Space saveSpace(Space space) {
        Space savedSpace = spaceRepository.save(space);
        return savedSpace;
    }

    @Override
    public List<Space> getAllSpaces() {
        return spaceRepository.findAll();
    }
    
}
