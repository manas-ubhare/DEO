package com.example.deo.dao;
import com.example.deo.model.Milestone;import org.springframework.stereotype.Repository;import java.util.*;
@Repository public class DemoMilestoneDao implements MilestoneDao {
 private final Map<Long,Milestone> data=new HashMap<>();
 public DemoMilestoneDao(){data.put(101L,new Milestone(101,10,"Design sign-off","a.patel","2026-10-12","OPEN"));data.put(102L,new Milestone(102,10,"UAT exit","s.rao","2026-10-29","IN_PROGRESS"));}
 public synchronized List<Milestone> findByEngagement(long id){return data.values().stream().filter(m->m.engagementId()==id).sorted(Comparator.comparingLong(Milestone::id)).toList();}
 public synchronized int updateStatus(long id,String status){var m=data.get(id);if(m==null)return 0;data.put(id,new Milestone(m.id(),m.engagementId(),m.title(),m.owner(),m.dueDate(),status));return 1;}
}
