package com.abdul.ecommerce.category.repository;

import com.abdul.ecommerce.category.info.CategoryResponse;
import com.abdul.ecommerce.category.mapper.CategoryMapper;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CategoryRepositoryImpl implements CategoryRepository{
    private final CategoryJpaRepository categoryJpaRepository;
    private final CategoryMapper categoryMapper;

    public List<CategoryResponse> getAll() {
        return categoryMapper.map(categoryJpaRepository.findAll());
    }
}
