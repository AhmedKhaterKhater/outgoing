package com.example.CMSCrud.service;

import com.example.CMSCrud.model.Outgoing;
import com.example.CMSCrud.repository.OutgoingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OutgoingService {

    @Autowired
    private OutgoingRepo outgoingRepo;

    public List<Outgoing> getAllOutgoings() {
        return outgoingRepo.findAll();
    }

    public Outgoing getOutgoingById(Long id) {
        Optional<Outgoing> outgoing = outgoingRepo.findById(id);
        return outgoing.get();
    }

    public void addOrUpdateOutgoing(Outgoing out) {
        outgoingRepo.save(out);
    }

    public void deleteOutgoing(Long id) {
        outgoingRepo.deleteById(id);
    }

    //sorting
    public List<Outgoing> sortOutgoingWith(String field) {
        return outgoingRepo.findAll(Sort.by(Sort.Direction.ASC, field));
    }

    //pagination
    public Page<Outgoing> findOutgoingWithPagination(int offset, int pageSize) {
        Page<Outgoing> outgoing= outgoingRepo.findAll(PageRequest.of(offset, pageSize));
        return outgoing;
    }

    //pagination and sorting
    public Page<Outgoing> findOutgoingWithPaginationAndSorting(int offset, int pageSize, String field) {
        Page<Outgoing> outgoing= outgoingRepo.findAll(PageRequest.of(offset, pageSize).withSort(Sort.by(field)));
        return outgoing;
    }

    //pagination using @requestParam
    //anther way for pagination
    /*public Pageable createPagination(String sortDircetion, String sortedField, int page, int limit) {
        Sort.Direction direction =
                sortDircetion == null ? Sort.Direction.ASC : (sortDircetion.equals("asc") ? Sort.Direction.ASC : Sort.Direction.DESC);
        Pageable pageable = PageRequest.of(page, limit, Sort.by(direction, sortedField));
        return pageable;
    }

    public Page<Outgoing> findOutgoingWithPagination(Pageable pageable, int offset, int pageSize) {
        Page<Outgoing> outgoing= outgoingRepo.findAll(PageRequest.of(offset, pageSize));
        return outgoing;
    }*/
    public List<Outgoing> getAllOutgoingWithPagination(int pageNo, int pageSize, String sortBy)
    {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

        Page<Outgoing> pagedResult = outgoingRepo.findAll(paging);

        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<Outgoing>();
        }
    }

    public List<Outgoing> findBySubjectParam(String sub) {
        return outgoingRepo.findBySubject(sub);
    }

}
