package com.shivam.springBoot.transactions;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.shivam.springBoot.entity.BaseVo;
import com.shivam.springBoot.person.PersonVo;
import lombok.Builder;
import lombok.Value;
import lombok.experimental.Wither;

import java.util.Date;

@Value
@Wither
@Builder(toBuilder = true)
@JsonDeserialize(builder = TransactionVo.TransactionVoBuilder.class)
public class TransactionVo implements BaseVo<TransactionVo> {

    private int id;

    private long fromNumber;

    private long toNumber;

    private float amount;

    private Date time;
}
