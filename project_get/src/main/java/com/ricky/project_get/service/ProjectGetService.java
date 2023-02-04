package com.ricky.project_get.service;

import com.ricky.project_get.model.*;
import okhttp3.OkHttpClient;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Service("projectGetService")
public class ProjectGetService {

    public ProjectGetResponse buildResponse() {
        ProjectGetResponse response = new ProjectGetResponse();
        ResultDto resultDto = getResults();

        if (resultDto != null) {
            response.setGender(resultDto.getGender());
            response.setFullname(generateFullName(resultDto.getName()));
            response.setAddress(generateAddress(resultDto.getLocation()));
            response.setPicture(resultDto.getPicture().getLarge());
        }
        return response;
    }

    public ResultDto getResults() {
        ResultDto resultDto = new ResultDto();
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://randomuser.me/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();

        RetrofitInterface service = retrofit.create(RetrofitInterface.class);
        Call<RandomUserResponse> callSync = service.getRandomUser();

        try {
            Response<RandomUserResponse> response = callSync.execute();
            RandomUserResponse apiResponse = response.body();

            if (apiResponse.getResults().size() != 0) {
                return apiResponse.getResults().get(0);
            } else {
                return resultDto;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
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
