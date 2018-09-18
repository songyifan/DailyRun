package org.csco.meat.dailrun;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

interface BookRepostitory extends JpaRepository<Book, Long> {
    List<Book> findByReader(String reader);
}
