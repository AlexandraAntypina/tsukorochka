package com.alex.spring.repository.filter;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;

public interface JpaChainPredicateConsumer {

	JpaChainPredicateConsumer AND = (CriteriaBuilder cb, Predicate ... chain) -> { return cb.and(chain);};
	JpaChainPredicateConsumer OR = (CriteriaBuilder cb, Predicate ... chain) -> { return cb.or(chain);};
	
	Predicate accept(CriteriaBuilder cb, Predicate ... chain);
}
