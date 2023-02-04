package com.ricky.project_get.controller;

import com.ricky.project_get.model.ProjectGetResponse;
import com.ricky.project_get.service.ProjectGetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController("projectGetController")
public class ProjectGetController {

    @Autowired
    ProjectGetService projectGetService;

    @RequestMapping(value = "/api/person", method = RequestMethod.GET, produces = "application/json")
    public ProjectGetResponse generateResponse() {
        return projectGetService.buildResponse();
    }
}
