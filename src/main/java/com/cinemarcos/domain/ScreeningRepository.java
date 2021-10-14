package com.cinemarcos.domain;

public interface ScreeningRepository {
    Screening byId(Long id);

    void save(Screening screening);
}
