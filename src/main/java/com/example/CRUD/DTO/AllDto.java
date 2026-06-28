package com.example.CRUD.DTO;

import com.example.CRUD.Model.Faculty;
import com.example.CRUD.Model.Fees;
import com.example.CRUD.Model.Salary;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

public class  AllDto {
    @Getter
    public static class FacultyListDto {
         @NotNull @Min(1)
        int page;
        @NotNull @Min(10)
        int pageSize = 10;
    }

    @Getter
    @AllArgsConstructor
    public static class FacultyResponseDto{
        List<Faculty> data;
        int totalData;
        int totalPages;
    }

    @Getter
    @AllArgsConstructor
    public static class CreateFaculty{
        @NotNull @NotBlank
        String name;
        @NotNull @Min(3000)
        Double fees;
    }
}
