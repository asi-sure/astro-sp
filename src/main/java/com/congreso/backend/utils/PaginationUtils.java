package com.congreso.backend.utils;

import org.springframework.data.domain.Page;

public class PaginationUtils {
    public static <T> PaginatedResponse<T> toPaginatedResponse(Page<T> page) {
        PaginatedResponse<T> response = new PaginatedResponse<>();
        response.setContent(page.getContent());
        response.setCurrentPage(page.getNumber());
        response.setTotalPages(page.getTotalPages());
        response.setTotalElements(page.getTotalElements());
        response.setPageSize(page.getSize());
        response.setLast(page.isLast());
        response.setFirst(page.isFirst());
        response.setHasNext(page.hasNext());
        response.setHasPrevious(page.hasPrevious());
        return response;
    }
}
