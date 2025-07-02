package org.example.memorydatabase.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
public abstract class entity implements PrimaryKey {

    private Long id;
}
