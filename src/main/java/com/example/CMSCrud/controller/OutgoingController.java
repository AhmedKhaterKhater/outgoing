package com.example.CMSCrud.controller;

import com.example.CMSCrud.ApiResponse;
import com.example.CMSCrud.model.Outgoing;
import com.example.CMSCrud.service.OutgoingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class OutgoingController {

    @Autowired
    private OutgoingService service;

    @GetMapping(value = "/outgoings")
    public List<Outgoing> getAllOutgoings() {
        return service.getAllOutgoings();
    }

    @GetMapping(value = "/outgoing/{id}")
    public Outgoing getOutgoingById(@PathVariable("id") Long id) {
        return service.getOutgoingById(id);
    }

    @PostMapping(value = "/outgoing")
    public Long createOutgoing(@RequestBody Outgoing outgoing) {
        service.addOrUpdateOutgoing(outgoing);
        return outgoing.getId();
    }

    @DeleteMapping(value = "/outgoing/{id}")
    public void deleteOutgoing(@PathVariable("id") Long id) {
        service.deleteOutgoing(id);
    }

    @PutMapping(value = "/outgoing")
    public Outgoing updateOutgoing(@RequestBody Outgoing outgoing) {
        service.addOrUpdateOutgoing(outgoing);
        return outgoing;
    }

    //sorting
    @GetMapping(value = "/{field}")
    public List<Outgoing> outgoingSortingBy(@PathVariable("field") String field) {
            return service.sortOutgoingWith(field);
    }

    //pagination
    @GetMapping(value = "paginatedWith/{offset}/{pageSize}")
    public Page<Outgoing> outgoingPaginationBy(@PathVariable("offset") int offset,
                                               @PathVariable("pageSize") int pageSize) {
        Page<Outgoing> outgoingPaginated = service.findOutgoingWithPagination(offset, pageSize);
        return new ApiResponse<>(outgoingPaginated.getSize(), outgoingPaginated).getResponse();
    }

    //anther way for using pagination using @RequestParam
    @GetMapping(value = "/paginated")
    public List<Outgoing> getAllEmployeespaginated(
            @RequestParam(required = false, defaultValue = "0") Integer pageNo,
            @RequestParam(required = false, defaultValue = "10") Integer pageSize,
            @RequestParam(required = false, defaultValue = "id") String sortBy)
    {
        List<Outgoing> list = service.getAllOutgoingWithPagination(pageNo, pageSize, sortBy);

        return list;
    }
    /*@GetMapping(value = "/paginated")
    public Page<Outgoing> outgoingPaginationBy(@RequestParam(required = false, defaultValue = "description") String sortedField,
                                               @RequestParam(required = false) String direction,
                                               @RequestParam(required = false, defaultValue ="0") int page,
                                               @RequestParam(required = false, defaultValue ="10") int limit,
                                               @RequestParam(required = false, defaultValue = "") int offs,
                                               @RequestParam(required = false, defaultValue = "") int pageSize
                                                ) {
        Page<Outgoing> outgoingPaginated =
                service.findOutgoingWithPagination(service.createPagination(direction, sortedField, page, limit), offs, pageSize);
        return new ApiResponse<>(outgoingPaginated.getSize(), outgoingPaginated).getResponse();
    }*/


    //paging and sorting
    @GetMapping(value = "paginatedWith/{offset}/{pageSize}/{field}")
    public Page<Outgoing> outgoingPaginationAndSorting(@PathVariable("offset") int offset,
                                                       @PathVariable("pageSize") int pageSize,
                                                       @PathVariable("field") String field) {
        Page<Outgoing> outgoingPaginated = service.findOutgoingWithPaginationAndSorting(offset, pageSize, field);
        return new ApiResponse<>(outgoingPaginated.getSize(), outgoingPaginated).getResponse();
    }

    @GetMapping(value = "/outgoing/subject/{subject}")
    public List<Outgoing> getBySubject(@PathVariable("subject") String subject) {
        List<Outgoing> outgoing = service.findBySubjectParam(subject);
        return outgoing;

    }

}
