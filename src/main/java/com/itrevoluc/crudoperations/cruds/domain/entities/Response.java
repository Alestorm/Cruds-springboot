package com.itrevoluc.crudoperations.cruds.domain.entities;

import org.springframework.http.HttpStatus;

import java.util.List;

public class Response<T> {
    public HttpStatus status;
    public T data;
    public List<String> errors;

    public Response(HttpStatus httpStatus, T data) {
        this.status = httpStatus;
        this.data = data;
    }

    public Response(HttpStatus httpStatus,  List<String> errors) {
        this.status = httpStatus;
        this.errors = errors;
    }

    public static <T> Response<T> Success(HttpStatus httpStatus, T data) {
        return new Response<>(httpStatus, data);
    }

    public static <T> Response<T> Failure(HttpStatus httpStatus,List<String> errors) {
        return new Response<>(httpStatus, errors);
    }
}