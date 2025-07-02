package org.example.memorydatabase.db;

import org.example.memorydatabase.entity.entity;

import java.util.*;
import java.util.stream.Collectors;

abstract public class SimpleDataRepository<T extends entity,ID extends Long> implements DataRepository<T,ID> {
    private List<T> dataList = new ArrayList<T>();

    private static long index = 0;

    private Comparator<T> sort = new Comparator<T>() {
        @Override
        public int compare(T o1, T o2) {
            return Long.compare(o1.getId(),o2.getId());
        }
    };
    //create, update

    @Override
    public T save(T data) {
        if (Objects.isNull(data)) {
            throw new RuntimeException("data is NUll");
        }
        // 같은 데이터가 있으면 update
        var prevData = dataList.stream().filter(
                it -> {
                    return it.getId().equals(data.getId());
                }
        ).findFirst();

        if (prevData.isPresent()){
            dataList.remove(prevData.get());
            dataList.add(data);
        }
        else{
            index++;
            data.setId(index);
            dataList.add(data);
        }

        return null;
    }
    //read
    @Override
    public Optional<T> findById(ID id){
        return dataList.stream()
                .filter(it -> {
                    return (it.getId().equals(id));
                }).findFirst();
    }
    @Override
    public List<T> findAll(){
        return dataList.stream().sorted(sort).collect(Collectors.toList());
    }

    //delete
    @Override
    public void delete(ID id){
        var deleteData = dataList.stream().filter(
                it ->{
                    return it.getId().equals(id);
                }
        ).findFirst();
        if(deleteData.isPresent()){
            dataList.remove(deleteData.get());
        }

    }
}
