package org.aryalinux.eshoppe.repositories;

import org.aryalinux.eshoppe.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer>{

}
