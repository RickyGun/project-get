package com.ricky.project_get.model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResultDto {
    private String gender;
    private NameDto name;
    private LocationDto location;
    private PictureDto picture;

}
