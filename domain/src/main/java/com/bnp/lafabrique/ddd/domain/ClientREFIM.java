package com.bnp.lafabrique.ddd.domain;

import java.util.stream.Stream;

public interface ClientREFIM {

    Stream<SalleVO> findSallesByCapacite(Integer nbPersonne);
}
