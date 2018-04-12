package com.alex.spring.repository.filter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;


public class JpaChainFilter<E> implements Specification<E> {
	
	private static final long serialVersionUID = 1L;
	
	private Map<String, Object> criteria = new TreeMap<>();
	private JpaChainPredicateConsumer chainPredicateConsumer;
	
	
	public JpaChainFilter(JpaChainPredicateConsumer chainPredicateConsumer, Map<String, Object> criteria) {
		this.chainPredicateConsumer = chainPredicateConsumer;
		this.criteria = criteria;
	}

	@Override
	public Predicate toPredicate(Root<E> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		
		List<Predicate> childPredicates = new ArrayList<Predicate>();
		
		for(Entry<String, Object> entry : criteria.entrySet()) {
			if(entry.getValue() == null) {
				continue;
			}
			Path<Object> attr = findCriteriaAttr(root, entry.getKey());
			if(attr == null) {
				continue;
			}
			
			Predicate predicate = cb.equal(attr, entry.getValue());
			
			childPredicates.add( predicate );
		}
		
		if(childPredicates.size() < 1) {
			return null;
		}
		
		Predicate[] rawArray = childPredicates.stream().toArray(Predicate[]::new);
		
		return chainPredicateConsumer.accept(cb, rawArray);
	}

	private Path<Object> findCriteriaAttr(Root<E> root, String attr) {
		
		if(!attr.contains(".")) {
			return root.get(attr);
		}
		
		// attribute contains '.' - we have child field as criteria
		// like calendar.user.userDetails.surname
		
		Path<Object> path = null;
		String[] parts = attr.split("\\.");
		
		for(String part : parts) {
			if(path == null) {
				path = root.get(part);
			} else {
				path = path.get(part);
			}
		}
		
		return path;
	}

}
