package com.webapi.chatspace.Service;

import java.util.List;

import com.webapi.chatspace.Model.Space;

public interface SpaceService {
    List<Space> getAllSpaces();
    Space getSpaceById(long id);
    Space saveSpace(Space space);
}
