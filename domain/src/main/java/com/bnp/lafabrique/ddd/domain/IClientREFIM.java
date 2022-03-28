package com.bnp.lafabrique.ddd.domain;

import java.util.stream.Stream;

public interface IClientREFIM {

    Stream<SalleVO> findSallesByCapacite(Integer nbPersonne);
}
