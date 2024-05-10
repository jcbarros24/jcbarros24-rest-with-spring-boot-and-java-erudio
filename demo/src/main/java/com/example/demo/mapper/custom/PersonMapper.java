package com.example.demo.mapper.custom;

import org.springframework.stereotype.Service;

import com.example.demo.ValueObject.V2.PersonVOV2;
import com.example.demo.model.Person;
import java.util.Date;

@Service
public class PersonMapper {

    public PersonVOV2 ConvertEntityToVO(Person person){

        PersonVOV2 vo = new PersonVOV2();
        vo.setId(person.getId());
        vo.setAdress(person.getAdress());
        vo.setFirstName(person.getFirstName());
        vo.setGender(person.getGender());
        vo.setLastName(person.getLastName());
        vo.setBirthDay(new Date());
        return vo;
    }

    public Person ConvertVoToEntity(PersonVOV2 person){

        Person entity = new Person();
        entity.setId(person.getId());
        entity.setAdress(person.getAdress());
        entity.setFirstName(person.getFirstName());
        entity.setGender(person.getGender());
        entity.setLastName(person.getLastName());
       // vo.setBirthDay(new Date());
        return entity;
    }
}
