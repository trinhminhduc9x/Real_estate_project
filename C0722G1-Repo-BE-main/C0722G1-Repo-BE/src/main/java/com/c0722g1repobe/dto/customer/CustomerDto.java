package com.c0722g1repobe.dto.customer;


import com.c0722g1repobe.entity.account.Account;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


import javax.validation.constraints.*;

public class CustomerDto implements Validator {
    private Integer id;

    @NotBlank(message = "vui lòng nhập tên!")
    @Size(max = 28)
    private String name;

    private boolean isDelete;

    @NotNull
    private String dayOfBirth;

    @NotNull(message = "Vui lòng chọn giới tính.")
    private Integer gender;

    @NotBlank(message = "Số CMND/CCCD không được để trống.")
    @Pattern(regexp = "^(\\d{9}|\\d{12})| *$",
            message = "Số CMND/CCCD phải đúng định dạng XXXXXXXXX hoặc XXXXXXXXXXXX (X là số 0-9).")
    private String idCard;

    @NotBlank(message = "Email không được để trống.")
    @Email(message = "Địa chỉ email phải đúng định dạng.")
    private String email;

    @NotBlank(message = "Địa chỉ không được để trống.")
    private String address;

    @NotNull
    @Size(max = 14)
    @NotBlank(message = "Số điện thoại không được để trống.")
    private String phoneNumber1;


    private Account account;

    public CustomerDto() {
    }


    public CustomerDto(Integer id, String name, boolean isDelete, String dayOfBirth, Integer gender, String idCard, String email, String address, String phoneNumber1, Account account) {
        this.id = id;
        this.name = name;
        this.isDelete = isDelete;
        this.dayOfBirth = dayOfBirth;
        this.gender = gender;
        this.idCard = idCard;
        this.email = email;
        this.address = address;
        this.phoneNumber1 = phoneNumber1;
        this.account = account;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    public String getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(String dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber1() {
        return phoneNumber1;
    }

    public void setPhoneNumber1(String phoneNumber1) {
        this.phoneNumber1 = phoneNumber1;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        CustomerDto customerDto = (CustomerDto) target;

        if (!customerDto.name.matches("[A-Za-z ]+")){
            errors.rejectValue("name", "name.invalidFormat");

        }
    }
}