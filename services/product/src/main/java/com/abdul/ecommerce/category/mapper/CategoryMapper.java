package com.abdul.ecommerce.category.mapper;

import com.abdul.ecommerce.category.entity.Category;
import com.abdul.ecommerce.category.info.CategoryResponse;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CategoryMapper {
    public List<CategoryResponse> map(List<Category> categories) {
        List<CategoryResponse> categoryResponses = new ArrayList<>();
        for (Category category : categories) {
            categoryResponses.add(
                    CategoryResponse.builder()
                            .id(category.getId())
                            .name(category.getName())
                            .description(category.getDescription())
                            .build()
            );
        }
        return categoryResponses;
    }
}
