package org.turner.persistence;

import org.springframework.data.repository.CrudRepository;
import org.turner.model.Title;

/**
 * CRUD Repository for the titles of people (e.g. mr, ms, rev, dr, etc.)
 *
 * @author turner
 */
public interface TitleRepository extends CrudRepository<Title, Long> {
}
