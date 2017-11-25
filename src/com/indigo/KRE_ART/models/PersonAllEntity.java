package com.indigo.KRE_ART.models;

public class PersonAllEntity {
    KreartService service;


    public PersonAll create(Person person){
        service = new KreartService();
        int id = Integer.parseInt(String.valueOf(person.getType()) + String.valueOf(person.getId()));
        PersonAll personAll = null;
        if (person.getType() == 1) {
            Talent talent = service.findTalentById(id);
            personAll = new PersonAll(person.getId(), person.getName(), person.getPassword(), person.getDni(), person.getCellphone(), person.getLocation(), person.getEmail(), person.getProfile(), person.getDescription(), person.getRate(), "Talento", talent.getId(), talent.getCategory());
        }
        else {
            Headhunter headhunter = service.findHeadHunterById(id);
            personAll = new PersonAll(person.getId(), person.getName(), person.getPassword(), person.getDni(), person.getCellphone(), person.getLocation(), person.getEmail(), person.getProfile(), person.getDescription(), person.getRate(), "Caza Talento", headhunter.getId(), headhunter.getCategory());
        }
        return personAll;
    }
}
