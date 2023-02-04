package com.ricky.project_get.model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjectGetResponse {
    private String gender;
    private String fullname;
    private String address;
    private String picture;
}
