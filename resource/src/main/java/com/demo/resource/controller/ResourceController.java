package com.demo.resource.controller;

import com.demo.resource.exception.ResourceNameInvalidException;
import com.demo.resource.model.Resource;
import com.demo.resource.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/resource")
public class ResourceController {

    @Autowired
    ResourceService resourceService;

    @PostMapping("/createResource")
    public Resource createResource(@RequestBody Resource resource) throws ResourceNameInvalidException {
        try {
            return resourceService.createResource(resource);
        } catch (ResourceNameInvalidException e) {
            throw new ResourceNameInvalidException(e.getMessage());
        }
    }

    @GetMapping("/getResource/{resourceId}")
    public Resource getResource(@PathVariable String resourceId) {
        return resourceService.getResourceById(resourceId);
    }

}
