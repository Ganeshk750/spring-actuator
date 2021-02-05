package com.ganesh.actuator.endpoints;

/*
 * @created: 05/02/2021 - 4:17 PM
 * @author: Ganesh
 */


import org.springframework.boot.actuate.endpoint.annotation.*;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@Endpoint(id = "release-info")
public class CustomeEndPoints {

    Map<String, List<String>> releaseNotesMap = new LinkedHashMap<>();

    @PostConstruct
    public void initNotes() {
        releaseNotesMap.put("version-1.0", Arrays.asList("New page created", "Adding a new item form added", "View the watchlist page added"));
        releaseNotesMap.put("version-1.1", Arrays.asList("Reading from Db API added", "Actuator endpoints added"));
    }

    @ReadOperation
    public Map<String, List<String>> getReleaseNotes(){
        return releaseNotesMap;
    }

    @ReadOperation
    public List<String> getNotesByVersion(@Selector String version){
        return releaseNotesMap.get(version);
    }

    @WriteOperation
    public void addReleaseNotes(@Selector String version, String releaseNotes){
        releaseNotesMap.put(version,Arrays.stream(releaseNotes.split(",")).collect(Collectors.toList()));
    }

    @DeleteOperation
    public void  deleteNotes(@Selector String version){
        releaseNotesMap.remove(version);
    }

}
