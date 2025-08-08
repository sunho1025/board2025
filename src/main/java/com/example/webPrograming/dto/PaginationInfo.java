package com.example.webPrograming.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PaginationInfo {
    private int firstPage;
    private int prevPage;
    private int startPage;
    private int currentPage;
    private int endPage;
    private int nextPage;
    private int lastPage;
    private int totalPageCount;
}
