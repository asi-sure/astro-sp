package com.congreso.backend.utils;

import lombok.Data;

import java.util.List;

@Data
public class PaginatedResponse<T> {
    private List<T> content;
    private int currentPage;
    private int totalPages;
    private long totalElements;
    private int pageSize;
    private boolean last;
    private boolean first;
    private boolean hasNext;
    private boolean hasPrevious;
}
