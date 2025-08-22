package com.app.pizza.Presentation.DTOs;

/*
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "user_type",
        defaultImpl = CustomerSignUpRequest.class
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = DeliveryEmployeeSignUpRequest.class, name = "DELIVERY"),
        @JsonSubTypes.Type(value = OnSiteEmployeesSignUpRequest.class, name = "ON_SITE")
})
 */

public abstract class UserSignUpRequest {

}
