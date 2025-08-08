package com.example.webPrograming.service;

import com.example.webPrograming.dto.PaginationInfo;
import org.springframework.stereotype.Service;

@Service
public class PaginationInfoService {
    public PaginationInfo getPaginationInfo(int currentPage, int pagesPerBlock, int itemPerPage, int totalItems){
        PaginationInfo paginationInfo = new PaginationInfo();
        paginationInfo.setFirstPage(-1);
        paginationInfo.setPrevPage(-1);
        paginationInfo.setStartPage(-1);
        paginationInfo.setCurrentPage(currentPage);
        paginationInfo.setEndPage(-1);
        paginationInfo.setNextPage(-1);
        paginationInfo.setLastPage(-1);
        paginationInfo.setTotalPageCount(1);
        return paginationInfo;
    }
}
