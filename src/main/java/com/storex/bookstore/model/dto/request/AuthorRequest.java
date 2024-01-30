package com.storex.bookstore.model.dto.request;

import com.storex.bookstore.costumeAnnotation.TrimmedString;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthorRequest {

 @NotNull(message = "The Name Of Author is Required")
 @NotEmpty(message = "The Name Of Author should not be empty")
 @NotBlank(message = "The Name Of Author should not be blank")
 @TrimmedString(message = "The Name Of Author must not have leading or trailing spaces")
 private String authorName;
}
