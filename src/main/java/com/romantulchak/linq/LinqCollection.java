package com.romantulchak.linq;

import java.util.Collection;

public interface LinqCollection<T> extends Linq<T>{
    Collection<T> execute(T...classes);
}
