package com.ricky.project_get.unit;

import com.ricky.project_get.model.LocationDto;
import com.ricky.project_get.model.NameDto;
import com.ricky.project_get.model.StreetDto;
import com.ricky.project_get.service.ProjectGetService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class ProjectGetUnitTest {
    @InjectMocks
    ProjectGetService projectGetService;
    @Test
    public void testGivenValidName_expect_NotNull()
    {
        NameDto dto = NameDto.builder()
                .title("Mr")
                .first("Raúl")
                .last("Medina")
                .build();
        assertNotNull(projectGetService.generateFullName(dto));
    }
    @Test
    public void testGivenNullNameDto_expect_emptyString()
    {
        assertEquals("", projectGetService.generateFullName(null));
    }

    @Test
    public void testGivenValidLocation_expect_NotNull()
    {
        StreetDto streetDto = StreetDto.builder()
                .number(123)
                .name("Calle del Prado")
                .build();
        LocationDto locationDto = LocationDto.builder()
                .street(streetDto)
                .city("Pamplona")
                .build();
        assertNotNull(projectGetService.generateAddress(locationDto));
    }

    @Test
    public void testGivenNullLocationDto_expect_emptyString()
    {
        assertEquals("", projectGetService.generateAddress(null));
    }
}
