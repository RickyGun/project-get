package com.ricky.project_get.model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PictureDto {
    private String large;
    private String medium;
    private String thumbnail;
}
