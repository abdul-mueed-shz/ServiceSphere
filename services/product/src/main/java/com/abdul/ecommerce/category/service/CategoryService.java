package com.abdul.ecommerce.category.service;

import com.abdul.ecommerce.category.info.CategoryResponse;
import com.abdul.ecommerce.category.repository.CategoryRepositoryImpl;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepositoryImpl categoryRepositoryImpl;

    public List<CategoryResponse> getAll() {
        return categoryRepositoryImpl.getAll();
    }
}
