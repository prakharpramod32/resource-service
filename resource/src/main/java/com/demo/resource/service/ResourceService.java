package com.demo.resource.service;


import com.demo.resource.exception.ResourceNameInvalidException;
import com.demo.resource.model.Resource;
import com.demo.resource.repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ResourceService {

    @Autowired
    ResourceRepository resourceRepository;

    public Resource createResource(Resource resource) throws ResourceNameInvalidException {
        if (validateResource(resource)) {

            return resourceRepository.save(resource);
        } else {
            throw new ResourceNameInvalidException("Resource name is invalid");
        }
    }

    public Resource getResourceById(String resourceId) {
        return resourceRepository.findById(resourceId).orElse(null);
    }


    private boolean validateResource(Resource resource) {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        List<String> validResources = new ArrayList<>(3);
        validResources.add("MIXING");
        validResources.add("PACKING");
        validResources.add("FREEZING");

        return validResources.contains(resource.getResourceId());

    }
}
