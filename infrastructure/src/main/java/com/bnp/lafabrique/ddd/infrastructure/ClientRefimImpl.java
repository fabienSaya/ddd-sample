package com.bnp.lafabrique.ddd.infrastructure;

import com.bnp.lafabrique.ddd.domain.ClientREFIM;
import com.bnp.lafabrique.ddd.domain.SalleVO;

import java.util.stream.Stream;

public class ClientRefimImpl implements ClientREFIM {
    @Override
    public Stream<SalleVO> findSallesByCapacite(Integer nbPersonne) {
        return Stream.of(new SalleVO("Salle1"));
    }
}
