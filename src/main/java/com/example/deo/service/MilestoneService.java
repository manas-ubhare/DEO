package com.example.deo.service;
import com.example.deo.dao.MilestoneDao;import com.example.deo.model.Milestone;import org.springframework.stereotype.Service;import java.util.*;
@Service public class MilestoneService {
 private final MilestoneDao dao;public MilestoneService(MilestoneDao dao){this.dao=dao;}
 public List<Milestone> list(long engagementId){return dao.findByEngagement(engagementId);}
 public void transition(long id,String status){if(!Set.of("OPEN","IN_PROGRESS","BLOCKED","DONE").contains(status))throw new IllegalArgumentException("Invalid status");if(dao.updateStatus(id,status)==0)throw new NoSuchElementException("Milestone not found");}
}
