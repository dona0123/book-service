package org.example.memorydatabase.user.model;

import lombok.*;
import org.example.memorydatabase.entity.entity;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserEntity extends entity {

    private String name;
    private int score;

}
