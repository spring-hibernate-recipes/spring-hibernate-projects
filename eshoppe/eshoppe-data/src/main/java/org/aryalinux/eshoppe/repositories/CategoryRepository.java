package org.aryalinux.eshoppe.repositories;

import org.aryalinux.eshoppe.model.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer> {

}
