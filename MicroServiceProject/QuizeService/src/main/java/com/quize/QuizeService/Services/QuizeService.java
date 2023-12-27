package com.quize.QuizeService.Services;

import com.quize.QuizeService.Entity.Quize;

import java.util.List;

public interface QuizeService {
    Quize add(Quize quize);

    List<Quize> getAll();

    Quize getById(Long id);

    Quize update(Long id, Quize employee);

    String delete(Long id);


}
