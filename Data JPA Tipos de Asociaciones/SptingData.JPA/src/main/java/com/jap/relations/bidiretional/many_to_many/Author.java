package com.jap.relations.bidiretional.many_to_many;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name="bi_author_many_to_many")
@Table(name="bi_author_many_to_many")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(mappedBy="authorList")
    private List<Book> booksList;




}
