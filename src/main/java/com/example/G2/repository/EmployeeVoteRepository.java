package com.example.G2.repository;


import com.example.G2.Model.EmployeeVote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface EmployeeVoteRepository extends JpaRepository<EmployeeVote, Long> {

    @Query(value = "UPDATE employee_vote SET number_of_votes=number_of_votes+1 where employee_name=? RETURNING number_of_votes", nativeQuery = true)
    @Transactional
    Integer updateVote(@Param("employeeName") String employeeName);

    List<EmployeeVote> findByEmployeeName(String employeeName);

    List<EmployeeVote> findByEmployeeNameIn(List<String> names);

}
