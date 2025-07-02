package org.example.memorydatabase.user.db;

import org.example.memorydatabase.db.SimpleDataRepository;
import org.example.memorydatabase.user.model.UserEntity;

import java.util.List;
import java.util.stream.Collectors;

public class UserRepository extends SimpleDataRepository<UserEntity,Long> {

    public List<UserEntity> findAllScoreGreaterThan(int score){

        return this.findAll().stream()
                .filter(
                        it ->{
                            return it.getScore() >= score;
                        }
                ).collect(Collectors.toList());
    }
}
