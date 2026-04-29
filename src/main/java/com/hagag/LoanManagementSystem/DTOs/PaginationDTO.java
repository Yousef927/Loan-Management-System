package com.hagag.LoanManagementSystem.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaginationDTO<T> {
    private List<T> data;
    private Integer currentPage;
    private Integer totalPages;
    private long totalElements;
    private Integer pageSize;



}
