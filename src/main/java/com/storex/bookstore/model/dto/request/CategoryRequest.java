package com.storex.bookstore.model.dto.request;

import com.storex.bookstore.costumeAnnotation.TrimmedString;
import com.storex.bookstore.model.entity.Book;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class CategoryRequest {

    @NotNull(message = "The Name is Required")
    @NotEmpty(message = "The Name should not be empty")
    @NotBlank(message = "The Name should not be blank")
    @TrimmedString(message = "The Name must not have leading or trailing spaces")
    private String name;

}
