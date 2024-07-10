package com.abdul.ecommerce.category.info;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CategoryResponse {
     Integer id;
     String name;
     String description;
}
