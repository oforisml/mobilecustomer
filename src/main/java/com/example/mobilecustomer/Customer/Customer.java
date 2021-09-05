package com.example.mobilecustomer.Customer;


import javax.persistence.*;

@Entity(name="Customer")
@Table(name="customer")
public class Customer {

    @Id
    @SequenceGenerator(name="id_sequence", sequenceName = "id_sequence", allocationSize = 1)
    @GeneratedValue(generator = "id_sequence", strategy = GenerationType.SEQUENCE)
    @Column(nullable = false)
    private Integer id;


    @Column(
            name = "msisdn",
            nullable = false)
    private String msisdn;

    @Column(
            name = "customer_id_owner",
            nullable = false
    )
    private Integer customer_id_owner;

    @Column(
            name = "customer_id_user",
            nullable = false
    )
    private Integer customer_id_user;

    @Enumerated(EnumType.STRING)
    @Column(
            name = "service_type",
            nullable = false)
    private ServiceType service_type;  //Enum{ MOBILE_PREPAID, MOBILE_POSTPAID }
    private Long date_started = System.currentTimeMillis();

    public Customer() {
    }

    public Customer(Integer id, String msisdn, Integer customer_id_owner, Integer customer_id_user, ServiceType service_type, Long date_started) {
        this.id = id;
        this.msisdn = msisdn;
        this.customer_id_owner = customer_id_owner;
        this.customer_id_user = customer_id_user;
        this.service_type = service_type;
        this.date_started = date_started;
    }

    public Customer(String msisdn, Integer customer_id_owner, Integer customer_id_user, ServiceType service_type, Long date_started) {
        this.msisdn = msisdn;
        this.customer_id_owner = customer_id_owner;
        this.customer_id_user = customer_id_user;
        this.service_type = service_type;
        this.date_started = date_started;
    }

    public Customer(String msisdn, Integer customer_id_owner, Integer customer_id_user, ServiceType service_type) {
        this.msisdn = msisdn;
        this.customer_id_owner = customer_id_owner;
        this.customer_id_user = customer_id_user;
        this.service_type = service_type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public Integer getCustomer_id_owner() {
        return customer_id_owner;
    }

    public void setCustomer_id_owner(Integer customer_id_owner) {
        this.customer_id_owner = customer_id_owner;
    }

    public Integer getCustomer_id_user() {
        return customer_id_user;
    }

    public void setCustomer_id_user(Integer customer_id_user) {
        this.customer_id_user = customer_id_user;
    }

    public ServiceType getService_type() {
        return service_type;
    }

    public void setService_type(ServiceType service_type) {
        this.service_type = service_type;
    }

    public Long getDate_started() {
        return date_started;
    }

    public void setDate_started(Long date_started) {
        this.date_started = date_started;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", msisdn='" + msisdn + '\'' +
                ", customer_id_owner=" + customer_id_owner +
                ", customer_id_user=" + customer_id_user +
                ", service_type='" + service_type + '\'' +
                ", data_started=" + date_started +
                '}';
    }
}
