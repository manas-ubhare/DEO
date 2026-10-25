package com.example.deo.controller;
import com.example.deo.service.MilestoneService;import org.springframework.stereotype.Controller;import org.springframework.web.bind.annotation.*;import org.springframework.http.*;import java.util.*;
@Controller public class MilestoneController {
 private final MilestoneService service;public MilestoneController(MilestoneService s){service=s;}
 @GetMapping("/") public String home(){return "milestones";}
 @GetMapping("/api/engagements/{id}/milestones") @ResponseBody public Object list(@PathVariable long id){return service.list(id);}
 @PostMapping("/api/milestones/{id}/status") @ResponseBody public Object update(@PathVariable long id,@RequestParam String status){service.transition(id,status);return Map.of("updated",true);}
 @ExceptionHandler(IllegalArgumentException.class) public ResponseEntity<?> bad(Exception e){return ResponseEntity.badRequest().body(Map.of("error",e.getMessage()));}
 @ExceptionHandler(NoSuchElementException.class) public ResponseEntity<?> missing(Exception e){return ResponseEntity.status(404).body(Map.of("error",e.getMessage()));}
}
