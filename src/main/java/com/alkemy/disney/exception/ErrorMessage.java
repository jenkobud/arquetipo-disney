package com.alkemy.disney.exception;

public class ErrorMessage {
    public static final String ID_NOT_NULL = "ID can not be null.";
    public static final String ATRIBUTE_NOT_BLANK = "This atribute can not be null, nor blank.";
    public static final String ATRIBUTE_NOT_NULL = "This atribute can not be null.";
    public static final String AGE_MIN = "Not born yet.";
    public static final String AGE_MAX = "Too old.";
    public static final String WEIGHT_MIN = "The weight can not be lower than 1";
    public static final String WEIGHT_MAX = "The weight can not be higher than 400";
    public static final String ATRIBUTE_NOT_EMPTY = "This atribute can not be an empty container";
    public static final String NO_RETRIEVE_FROM_DB = "No result retrieved from DB";
    public static final String ENTITY_ALREADY_EXIST = "There is already an entity with the same id";
    public static final String RATE_RANGE = "The rate value must be contained between 0 & 10";

    private ErrorMessage(){}
}
