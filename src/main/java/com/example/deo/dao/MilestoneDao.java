package com.example.deo.dao;
import com.example.deo.model.Milestone;import java.util.*;
public interface MilestoneDao {List<Milestone> findByEngagement(long engagementId);int updateStatus(long id,String status);}
