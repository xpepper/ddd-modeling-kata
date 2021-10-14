package com.cinemarcos.domain;

import java.time.LocalDateTime;

public interface ScreeningRepository {
    Screening byTime(LocalDateTime time);

    void save(Screening screening);
}
