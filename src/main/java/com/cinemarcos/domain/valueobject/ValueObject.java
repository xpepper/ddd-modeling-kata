package com.cinemarcos.domain.valueobject;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

class ValueObject {
    @Override public boolean equals(Object o) {
        return EqualsBuilder.reflectionEquals(this, o);
    }

    @Override public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }
}
