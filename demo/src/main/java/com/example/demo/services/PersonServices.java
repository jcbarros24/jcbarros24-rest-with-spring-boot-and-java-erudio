package com.example.demo.services;

//import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import com.example.demo.ValueObject.V1.PersonVO;
import com.example.demo.ValueObject.V2.PersonVOV2;
import com.example.demo.controllers.PersonController;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.mapper.custom.PersonMapper;
import com.example.demo.mapper.dozer.DozerMapper;
import com.example.demo.model.Person;
import com.example.demo.repositories.PersonRepository;

@Service
public class PersonServices {

    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    @Autowired
    PersonRepository repository;

    @Autowired
    PersonMapper personMapper;

    public List<PersonVO> findAll(){

        logger.info("Finding all people");
        return DozerMapper.parseListObjects(repository.findAll(), PersonVO.class);

    }

    public PersonVO findById(Long id){

        logger.info("Finding one person");
        var entity = repository.findById(id) .orElseThrow(() -> new ResourceNotFoundException("Erro test"));
        PersonVO vo = DozerMapper.parseObject(entity, PersonVO.class);
        vo.add(linkTo(methodOn(PersonController.class).findById(id)).withSelfRel());
        return vo;
    }

    public PersonVO create(PersonVO person) {

        logger.info("Creating one person");
        var entity = DozerMapper.parseObject(person, Person.class);
        var VO = DozerMapper.parseObject(repository.save(entity), PersonVO.class);
        return VO;
        
    }

    public PersonVOV2 createV2(PersonVOV2 person) {

        logger.info("Creating one person");
        var entity = personMapper.ConvertVoToEntity(person);
        var VO = personMapper.ConvertEntityToVO(repository.save(entity));
        return VO;
        
    }

    public PersonVO update(PersonVO person) {

        logger.info("Updating one person");
        var entity = repository.findById(person.getKey()) .orElseThrow(() -> new ResourceNotFoundException("Erro test"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAdress(person.getAdress());
        entity.setGender(person.getGender());

        var VO = DozerMapper.parseObject(repository.save(entity), PersonVO.class);
        return VO;
    }

    public void delete(Long id) {

        logger.info("Deleting one person");
        var entity = repository.findById(id) .orElseThrow(() -> new ResourceNotFoundException("Erro test"));
        repository.delete(entity);
    }

}