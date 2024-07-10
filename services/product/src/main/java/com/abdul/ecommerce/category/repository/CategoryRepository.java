package com.abdul.ecommerce.category.repository;

import com.abdul.ecommerce.category.info.CategoryResponse;
import java.util.List;

public interface CategoryRepository {

    List<CategoryResponse> getAll();
}
