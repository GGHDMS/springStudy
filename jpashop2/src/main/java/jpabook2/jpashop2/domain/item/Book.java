package jpabook2.jpashop2.domain.item;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.swing.*;

@Entity
@DiscriminatorValue("BOOK")
@Getter
@Setter
public class Book extends Item{
    private String author;
    private String isbn;
}
