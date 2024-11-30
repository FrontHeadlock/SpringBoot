package umc.Spring.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Pageable;

@RestController
@RequestMapping("/api/missions")
public class MissionController {

    //@Autowired
    //private UserMissionService userMissionService;

    /*@GetMapping("/user/{userId}")
    public Page<MissionDto> getUserMissions(
            @PathVariable Long userId,
            Pageable pageable) {
        return userMissionService.getUserMissions(userId, pageable);
    }*/
}
