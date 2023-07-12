package com.example.CMSCrud.repository;

import com.example.CMSCrud.model.Outgoing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OutgoingRepo extends JpaRepository<Outgoing, Long> {

    @Query("select T from Outgoing T where T.subject=?1")
    List<Outgoing> findBySubject(String subject);
}
