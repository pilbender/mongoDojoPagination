package net.raescott.repository.mongo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import net.raescott.dto.Part;

/**
 * @author Richard Scott Smith <scott.smith@isostech.com>
 */
public interface PartMongoRepositoryGenerated extends PagingAndSortingRepository<Part, String> {
	// findAll can't be here because it is not a property to generate a method.
	//public Iterable<Person> findAll(String id);
	public Part findByPartNumber(String partNumber);
	public Iterable<Part> findByPartName(String name);
}
