package com.mogilan.companymanager.service;

import org.springframework.data.domain.Page;

public interface PagingAndSortingService <T> {
    Page<T> findPaginated(int pageNumber, int pageSize, String sortCondition, String sortDirection);
}
