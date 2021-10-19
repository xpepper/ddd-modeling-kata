package com.cinemarcos.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class Event {
    public Long id;

    public Event(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        return new EqualsBuilder().reflectionAppend(this, o).isEquals();
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(17, 37, this);
    }

    @Override
    public String toString() {
        return new ReflectionToStringBuilder(this).toString();
    }
}
