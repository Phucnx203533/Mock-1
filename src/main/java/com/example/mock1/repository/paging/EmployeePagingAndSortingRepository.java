package com.example.mock1.repository.paging;

import com.example.mock1.entity.EmployeeEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface EmployeePagingAndSortingRepository extends PagingAndSortingRepository<EmployeeEntity,Integer> {
}
