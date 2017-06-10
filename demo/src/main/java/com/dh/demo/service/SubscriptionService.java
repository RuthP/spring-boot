package com.dh.demo.service;

import com.dh.demo.domain.Room;
import com.dh.demo.domain.Student;
import com.dh.demo.domain.Subscription;
import com.dh.demo.domain.Teacher;
import com.dh.demo.repository.RoomRepository;
import com.dh.demo.repository.StudentRepository;
import com.dh.demo.repository.SubscriptionRepository;
import com.dh.demo.repository.TeacherRepository;
import com.dh.demo.web.SubscriptionController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jhonny on 6/10/17.
 */
@Service
public class SubscriptionService {
    @Autowired
    private SubscriptionRepository subscriptionRepository;
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private RoomRepository roomRepository;

    public List<Subscription> getAllSubscriptions(){
        return  subscriptionRepository.findAll();
    }

    public void addNewSubscription(SubscriptionController.SubscritionRequestDTO subscriptionDTO){
        Subscription newSubcription = new Subscription();
        Student newStudent = studentRepository.findOne(subscriptionDTO.getStudentId());
        Teacher newTeacher = teacherRepository.findOne(subscriptionDTO.getTeacherId());
        Room newRoom = roomRepository.findOne(subscriptionDTO.getRoomId());
        newSubcription.setStudent(newStudent);
        newSubcription.setTeacher(newTeacher);
        newSubcription.setRoom(newRoom);
        newSubcription.setSubDate(subscriptionDTO.getSubDate());

        subscriptionRepository.save(newSubcription);
    }

}
