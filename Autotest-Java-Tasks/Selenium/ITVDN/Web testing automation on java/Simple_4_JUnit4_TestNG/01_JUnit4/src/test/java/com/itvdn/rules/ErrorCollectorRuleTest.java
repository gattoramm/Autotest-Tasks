package com.itvdn.rules;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.collection.IsEmptyCollection.empty;
import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.hamcrest.core.IsNot.not;

public class ErrorCollectorRuleTest {

	@Rule
	public ErrorCollector collector = new ErrorCollector();
	
	@Test
	public void multipleErrors() {
		collector.addError(new NullPointerException());
		collector.addError(new IllegalArgumentException());
	}

	@Test
	public void multipleChecks() {
		List<String> myList = Collections.emptyList();
		
		collector.checkThat(myList, not(empty()));
		collector.checkThat(myList, hasItem("I'm not contained :("));
	}

}
