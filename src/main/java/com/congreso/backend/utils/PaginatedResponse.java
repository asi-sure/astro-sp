package com.congreso.backend.utils;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;

import java.util.List;

@Data
public class PaginatedResponse<T> {
//    @JsonView({JsonViews.Public.class, JsonViews.Internal.class})
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
