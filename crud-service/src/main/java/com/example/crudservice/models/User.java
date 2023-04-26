package com.example.crudservice.models;

import lombok.*;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
public class User {
 @NotNull
 private Long  id;
 private  String name;
 private  String lastname;


}

