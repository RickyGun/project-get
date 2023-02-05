package com.ricky.project_get.service;

import com.ricky.project_get.model.LocationDto;
import com.ricky.project_get.model.NameDto;
import com.ricky.project_get.model.ProjectGetResponse;
import com.ricky.project_get.model.ResultDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("projectGetService")
public class ProjectGetService {

    @Autowired
    RetrofitService retrofitService;
    public ProjectGetResponse buildResponse() {
        ProjectGetResponse response = new ProjectGetResponse();
        ResultDto resultDto = retrofitService.getResults();

        if (resultDto != null) {
            response.setGender(resultDto.getGender());
            response.setFullname(generateFullName(resultDto.getName()));
            response.setAddress(generateAddress(resultDto.getLocation()));
            response.setPicture(resultDto.getPicture().getLarge());
        }
        return response;
    }

    public String generateFullName(NameDto dto) {
        if (dto != null) {
            StringBuilder name = new StringBuilder();
            name.append(dto.getTitle());
            name.append(" ");
            name.append(dto.getFirst());
            name.append(" ");
            name.append(dto.getLast());
            return name.toString();
        } else {
            return "";
        }
    }

    public String generateAddress(LocationDto dto) {
        if (dto != null) {
            StringBuilder address = new StringBuilder();
            address.append(dto.getStreet().getName());
            address.append(" ");
            address.append(dto.getCity());
            return address.toString();
        } else {
            return "";
        }
    }
}
