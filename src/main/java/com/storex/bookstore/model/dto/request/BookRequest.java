package com.storex.bookstore.model.dto.request;


import com.storex.bookstore.costumeAnnotation.TrimmedString;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookRequest {

    @NotNull(message = "the authorId is required")
    private Long authorId;

    @NotNull(message = "The Name Of Book is Required")
    @NotEmpty(message = "The Name Of Book should not be empty")
    @NotBlank(message = "The Name Of Author should not be blank")
    @TrimmedString(message = "The Name Of Book must not have leading or trailing spaces")
    private String name;

    private String description;

    @NotNull(message = "the createDate is required")
    @NotEmpty(message = "the createDate should not be empty")
    @NotBlank(message = "the createDate should not be blank")
    @Pattern(regexp = "^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01])$", message = " the createDate must be in this format yyyy-MM-dd")
    private String createDate;

    @Min(value = 0,message = "the min of price  is 0")
    private Double price;


}
