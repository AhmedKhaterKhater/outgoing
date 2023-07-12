package com.example.CMSCrud;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse<T> {

    int recordCount;
    T response;
}
