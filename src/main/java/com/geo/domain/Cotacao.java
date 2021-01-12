package com.geo.domain;

import java.util.ArrayList;
import java.util.List;

public class Cotacao {

    private List<CotacaoValor> value = new ArrayList<>();

    public List<CotacaoValor> getValue() {
        return value;
    }

    public void setValue(List<CotacaoValor> value) {
        this.value = value;
    }
}
