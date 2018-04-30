package xyz.crearts.money.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;

@Data
public class CashFlowWithCategory {
    private String description;

    private Timestamp createdAt;
    private Double amountOrigin;
    private Double amount;

    private String name;
    private String urlImage;
    private Integer operation;
}
