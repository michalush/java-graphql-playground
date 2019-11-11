package de.michalush.graphqlplayground.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Book {
    private String id;
    private String name;
    private Integer pageCount;
}
