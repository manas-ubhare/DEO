package com.example.deo.service;
import com.example.deo.dao.DemoMilestoneDao;import org.junit.jupiter.api.Test;import static org.junit.jupiter.api.Assertions.*;
class MilestoneServiceTest { @Test void rejectsInvalidStatus(){var s=new MilestoneService(new DemoMilestoneDao());assertThrows(IllegalArgumentException.class,()->s.transition(101,"ARCHIVED"));} @Test void updatesStatus(){var s=new MilestoneService(new DemoMilestoneDao());s.transition(101,"DONE");assertEquals("DONE",s.list(10).get(0).status());}}
