package com.mine.inputstream;

import com.oracle.webservices.internal.api.databinding.DatabindingMode;
import lombok.*;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

/**
 * @author yanyimim
 * @since 2019/12/19 14:19
 */
@Data
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class Employee implements Serializable {
    @NonNull
    private String name;
    @NonNull
    private double salay;
    @NonNull
    private LocalDate hireday;
    private Employee secretary;
}
