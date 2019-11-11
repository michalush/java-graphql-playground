package de.michalush.graphqlplayground.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Author {
    private String id;
    private String firstName;
    private String lastName;
}


