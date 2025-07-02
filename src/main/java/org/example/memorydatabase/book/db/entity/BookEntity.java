package org.example.memorydatabase.book.db.entity;

import lombok.*;
import org.example.memorydatabase.entity.entity;

import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookEntity extends entity {
    private String name;
    private String category;
    private BigDecimal amount;
}
