package com.example.demo;

import javax.persistence.Id;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.GeneratedValue;

import java.util.Date;

import javax.persistence.Entity;

@Entity
@Getter @Setter
@NoArgsConstructor
@ToString @EqualsAndHashCode
public class ChatMessage {
	@Id @GeneratedValue
    private Long id;
    private @NonNull String message;
    private @NonNull Date fecha;
}
